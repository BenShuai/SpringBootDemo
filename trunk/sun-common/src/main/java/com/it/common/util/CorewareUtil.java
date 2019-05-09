package com.it.common.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * 工具类
 *
 * @author 孙帅
 */
public class CorewareUtil {
    private static String encoding = "UTF-8";

    /**
     * 返回json文件的内容
     *
     * @param jsonFileName
     * @return
     * @throws Exception
     */
    public static String jsonCon(String jsonFileName) throws Exception {
        CorewareUtil cu = new CorewareUtil();
        InputStream in = cu.getClass().getClassLoader().getResourceAsStream(jsonFileName);
        byte[] b = new byte[10240000];
        int n;
        StringBuffer content = new StringBuffer();
        while ((n = in.read(b)) != -1) {
            content.append(new String(b, 0, n, encoding));
        }
        in.close();
        return content.toString();
    }

    /**
     * @param conn 通过get方式获取StringBuffer(内部方法)
     * @return
     */
    private static StringBuffer getJsonString(URLConnection conn) {
        InputStreamReader isr = null;
        BufferedReader br = null;
        StringBuffer sb = null;
        try {
            isr = new InputStreamReader(conn.getInputStream(), encoding);
            br = new BufferedReader(isr);
            String line = null;
            sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\r\n");
            }
        } catch (Exception e) {
            System.out.println("读取流异常\r\n" + e.getMessage());
        } finally {
            try {
                if (isr != null)
                    isr.close();
            } catch (IOException e) {
                System.out.println("流关闭异常\r\n" + e.getMessage());
            }
        }
        return sb;
    }

    /**
     * 调用远端接口返回数据(无参数)
     *
     * @param urlStr 远端数据接口地址
     * @return
     */
    public static String getHttpClentsJson(String urlStr){
    	try{
	    	URL u = new URL(urlStr);
			URLConnection conn = u.openConnection();// 打开网页链接
			//返回结果
			String cloudJson = getJsonString(conn).toString();
	    	return cloudJson;
    	}catch (Exception e) {
    		System.out.println( "连接【"+urlStr+"】失败\r\n"+e.getMessage());
    		return "请求或数据接口出现错误";
    	}

    }


    /**
     * 有参数的httpClent请求(POST)
     * @param urlStr    请求地址
     * @param params    参数[Map类型] Map<String,Object>
     * @return  请求结果
     */
    public static String postHttpClentsJson(String urlStr,Map<String,Object> params){
    	HttpClient clients = new HttpClient();
//    	clients.getHostConfiguration().setProxy(proxy.get("ip"),Integer.parseInt(proxy.get("port")));//设置代理
//    	clients.getParams().setAuthenticationPreemptive(true);//使用抢先认证
    	
    	PostMethod connPost = new PostMethod();
    	try{
			URI u=new URI(urlStr);
    		connPost.setURI(u);
    		if(params!=null && params.size()>0){
				for (String key : params.keySet()) {
					connPost.setParameter(key, params.get(key).toString());
					connPost.getParams().setContentCharset(encoding);//参数转码
				}
    		}
			clients.getHttpConnectionManager().getParams().setConnectionTimeout(20000);//默认20秒链接超时
			clients.getHttpConnectionManager().getParams().setSoTimeout(20000);//默认20秒读取超时
			int status = clients.executeMethod(connPost);
			if(status==200){
				BufferedReader buReader = new BufferedReader(new InputStreamReader(connPost.getResponseBodyAsStream(),encoding));
				StringBuffer cloudJson = new StringBuffer();
				String line;
				while((line=buReader.readLine())!=null){
					cloudJson.append(line);
				}
				buReader.close();
		    	return cloudJson.toString();
			}else{
				System.out.println("请求接口错误=====错误码："+status+"\r\n请求地址："+urlStr);
				return "请求或数据接口出现错误";
			}
    		
    	}catch (Exception e) {
    		System.out.println( "连接【"+urlStr+"】失败\r\n"+e.getMessage());
    		return "请求或数据接口出现错误";
    	}finally {
    		//释放掉HTTP连接
    		connPost.releaseConnection();
    		clients.getHttpConnectionManager().closeIdleConnections(0);
		}
    }


    /**
     * 没有参数名，只有参数值的httpClent请求(POST)
     *
     * @param urlStr 请求地址
     * @param params 参数[JSONArray类型(数据格式模拟：/---[{"key":"username","value":"sunshuai"},{"key","password","value":"123456"}]---/ )]
     * @return 结果
     */

    public static String postHttpClentsJsonNoEntity(String urlStr,String params){
    	HttpClient clients = new HttpClient();
    	PostMethod connPost = new PostMethod();
    	try{
			URI u=new URI(urlStr);
    		connPost.setURI(u);
    		if(params!=null && !params.equals("")){
				connPost.setRequestBody(params);
    		}
			clients.getHttpConnectionManager().getParams().setConnectionTimeout(20000);//默认20秒链接超时
			clients.getHttpConnectionManager().getParams().setSoTimeout(20000);//默认20秒读取超时
			int status = clients.executeMethod(connPost);
			if(status==200){
				BufferedReader buReader = new BufferedReader(new InputStreamReader(connPost.getResponseBodyAsStream(),encoding));
				StringBuffer cloudJson = new StringBuffer();
				String line;
				while((line=buReader.readLine())!=null){
					cloudJson.append(line);
				}
				buReader.close();
		    	return cloudJson.toString();
			}else{
				System.out.println("请求接口错误=====错误码："+status+"\r\n请求地址："+urlStr);
				return "请求或数据接口出现错误";
			}
    		
    	}catch (Exception e) {
    		System.out.println( "连接【"+urlStr+"】失败\r\n"+e.getMessage());
    		return "请求或数据接口出现错误";
    	}finally {
    		//释放掉HTTP连接
    		connPost.releaseConnection();
    		clients.getHttpConnectionManager().closeIdleConnections(0);
		}
    }


    /**
     * 获取系统当前时间组成的字符串，( GeShi : 显示格式 )
     *
     * @return 当前时间组成的字符串
     */
    public static String GetDataStr(String GeShi) {
        SimpleDateFormat sdf = new SimpleDateFormat(GeShi);
        String getDate = sdf.format(new Date());
        return getDate;
    }


    /**
     * 将指定的时间转为字符串格式
     *
     * @param date  指定的时间
     * @param GeShi 转换后显示的格式
     * @return
     */
    public static String GetDataStrs(Date date, String GeShi) {
        SimpleDateFormat sdf = new SimpleDateFormat(GeShi);
        String getDate = sdf.format(date);
        return getDate;
    }
    
    /**
     * 将指定的时间的Long值转为对应格式的字符串格式时间
     *
     * @param dateLong  指定的时间(Long值)
     * @param GeShi 转换后显示的格式
     * @return
     */
    public static String GetDataStrs(Long dateLong, String GeShi) {
        Date date = new Date(dateLong);
        SimpleDateFormat sdf = new SimpleDateFormat(GeShi);
        String getDate = sdf.format(date);
        return getDate;
    }

    /**
     * 计算两个时间的差值(秒数)
     *
     * @param date
     * @param date2
     * @return
     */
    public static double GetDataMinis(Date date, Date date2) {
        long t1 = date.getTime();
        long t2 = date2.getTime();
        double tnum = (t2 - t1) / 1000;
        return tnum;
    }

    /**
     * 将字符串时间转换成对应格式的DATA类型
     *
     * @param GeShi 格式
     * @param times 字符串时间
     * @return
     */
    public static Date GetStringToDate(String GeShi, String times) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(GeShi);
            return sdf.parse(times);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回当前时间的LONG值
     *
     * @return
     */
    public static Long GetTimeLong() {
        Date dt = new Date();
        return dt.getTime();
    }
    
    /**
     * 将对应的时间格式转换成String类型
     * @param geShi
     * @param times
     * @return
     */
    public static String getTimeStr(String geShi, String times){
    	try{
    		SimpleDateFormat sdf = new SimpleDateFormat(geShi);
    		Date time = sdf.parse(times);
    		return sdf.format(time);
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	return "";
	}
	/**
	 * 验证字符串是否为 null 或 ""
	 * @param value
	 * @return  false:是 null 或 ""     true：不为空
	 */
	public static boolean isNotEmpty(String value){
		if(value==null){
			return false;
		}
		if(value.equals("")){
			return false;
		}
		return true;
	}
	
	
    /**
     * 返回当天0点0分0秒的时间的Long值
     *
     * @return
     */
    public static Long GetZeroTimeLong() {
        String ZeroTimeStr = GetDataStr("yyyy-MM-dd 00:00:00");
        Date ZeroTimeDt = GetStringToDate("yyyy-MM-dd 00:00:00", ZeroTimeStr);
        return ZeroTimeDt.getTime();
    }

    /**
     * 获取UUID
     *
     * @return
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString().replace("-", "");
        return str;
    }

    /**
     * 返回随机字符串
     *
     * @param StrLength
     * @return
     */
    public static String GetRmStr(int StrLength) {
        String[] list = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        StringBuffer strB = new StringBuffer();
        for (int i = 0; i < StrLength; i++) {
            Random rd = new Random();
            int Ind = rd.nextInt(list.length);
            strB.append(list[Ind]);
        }
        return strB.toString();
    }

    /**
     * List集合去重
     *
     * @param list
     * @return
     */
    public static List unique(List list) {
        List tempList = new ArrayList();
        for (Object i : list) {
            if (!tempList.contains(i)) {
                tempList.add(i);
            }
        }
        return tempList;
    }

    /**
     * String[]数组去重
     *
     * @param arr 需要去重的原始String[]对象
     * @return
     */
    public static String[] unique(String[] arr) {
        List<String> lists = new LinkedList<String>();
        for (int i = 0; i < arr.length; i++) {
            if (!lists.contains(arr[i])) {
                lists.add(arr[i]);
            }
        }
        return (String[]) lists.toArray(new String[lists.size()]);
    }
    
    /**
     * 剪切成正方形缩略图
     * @param src   原图位置        如   /image/a.jpg
     * @param dest  剪切图位置    如   /image_thumbnail/a.jpg
     * @param Dw    最后的宽度
     * @param Dh    最后的高度
     * @throws IOException
     */
    public static void CutZoomImage(String src,String dest,int Dw,int Dh) throws IOException{
    	float Dratio=Float.parseFloat(Dw+"")/Float.parseFloat(Dh+"");//结果图的宽高的比例
        Iterator iterator = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = (ImageReader)iterator.next();
        InputStream in=new FileInputStream(src);
        ImageInputStream iis = ImageIO.createImageInputStream(in);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        int w=reader.getWidth(0);//获得图片的宽度
        int h=reader.getHeight(0);//获得图片的高度
        float ratio=Float.parseFloat(w+"")/Float.parseFloat(h+"");//原图的宽高比例
        //将宽高调整为一样比例的大小
        int x=0;//剪切坐标X
    	int y=0;//剪切坐标Y
        if(ratio>Dratio){//原图过宽(以高度为基本大小截取)
        	int NewW=Integer.parseInt(new DecimalFormat("###").format(h*Dratio));//按比例计算的原图宽度
        	x=(w-NewW)/2;
        	w=NewW;
        	y=0;
        }else{//原图过高(以宽度为基本大小截取)
        	int NewH=Integer.parseInt(new DecimalFormat("###").format(w/Dratio));//按比例计算的原图高度
        	x=0;
        	y=(h-NewH)/2;
        	h=NewH;
        }
        
        Rectangle rect = new Rectangle(x, y, w,h);
        param.setSourceRegion(rect);
        BufferedImage bi = reader.read(0,param);
        
        //开始缩小=============================================
        Image Itemp = bi.getScaledInstance(w, h, bi.SCALE_SMOOTH);
        double wr=Dw*1.0/bi.getWidth();
        double hr=Dh*1.0/bi.getHeight();
        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);
        Itemp = ato.filter(bi, null);
        
        //将剪切缩略的图片最后保存到指定的地址
        try {
        	File destFile = new File(dest);
            ImageIO.write((BufferedImage) Itemp,dest.substring(dest.lastIndexOf(".")+1), destFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
	 * 字符串混淆
	 * @param strS   
	 * @return
	 */
	public static String getEncode(String strS){
		StringBuilder EncodePass=new StringBuilder(CorewareUtil.GetRmStr(5));
		for (int i = 0; i < strS.length(); i++) {
			EncodePass.append(strS.substring(i, i+1)+CorewareUtil.GetRmStr(5));
		}
		return EncodePass.toString();
	}
	/**
	 * 还原字符串
	 * @param Str   需要还原的字符串
	 * @return
	 */
	public static String getDecode(String Str){
		StringBuilder EncodePass=new StringBuilder();
		for (int i = 5; i < Str.length(); i++) {
			EncodePass.append(Str.substring(i, i+1));
			i=i+5;
		}
		return EncodePass.toString();
	}
	
	/**
	 * 写入本地文件
	 * @param path
	 * @param value
	 * @return
	 */
	public static String WriteTxt(String path,String value){
		BufferedWriter writer=null;
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream(path);
			writer = new BufferedWriter(new OutputStreamWriter(fos,encoding));
			writer.write(value);
        } catch (Exception e) {
        	System.out.println("写入文件失败,地址："+path);
        	return "ERROR";
        }finally{
        	if(writer!=null){
				try {
					writer.close();
					writer=null;
				} catch (Exception e) {
					System.out.println("文件读写关闭输入流失败");
				}
			}
        	if(fos!=null){
				try {
					fos.close();
					fos=null;
				} catch (Exception e) {
					System.out.println("文件读写关闭输入流失败");
				}
			}
        }
		return "OK";
	}
	/**
	 * 读取本地文件
	 * @param path
	 * @return
	 */
	public static String ReadTxt(String path){
		FileInputStream fs=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		try {
			fs = new FileInputStream(path);
			isr = new InputStreamReader(fs,encoding);
			br = new BufferedReader(isr);
			StringBuilder value=new StringBuilder();
			while (true) {
				String DataLong=br.readLine();//上次获取AccessToken的时间的Long值
				if(DataLong!=null){
					value.append(DataLong).append("\r\n");
				}else{
					break;
				}
			}
			return value.toString();
		} catch (Exception e) {
//			System.out.println("文件读取失败，地址："+path);
		}finally{
			if(br!=null){
				try {
					br.close();
					br=null;
				} catch (Exception e) { }
			}
			if(isr!=null){
				try {
					isr.close();
					isr=null;
				} catch (Exception e) { }
			}
			if(fs!=null){
				try {
					fs.close();
					fs=null;
				} catch (Exception e) { }
			}
		}
		return "";
	}
	/**
	 * 给图片加水印
	 * @param ImgPath    原图
	 */
	public static void ImgWatermark(String ImgPath){
		String IcoImgPath=CorewareUtil.class.getResource("/").getFile().toString()+"wm.png";//水印图片地址
//		System.out.println(IcoImgPath);
		OutputStream os = null;
		try{
			Image srcImg = ImageIO.read(new File(ImgPath));
			BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
			// 得到画笔对象
			Graphics2D g = buffImg.createGraphics();
			// 设置对线段的锯齿状边缘处理 
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);
			Image imgIcon = ImageIO.read(new File(IcoImgPath));//水印图片
			g.drawImage(imgIcon, 0, 0, null);
			g.drawImage(imgIcon, 1500, 0, null);
			g.drawImage(imgIcon, 3000, 0, null);
			
			g.drawImage(imgIcon, 0, 1700, null);
			g.drawImage(imgIcon, 1500, 1700, null);
			g.drawImage(imgIcon, 3000, 1700, null);
			
			g.drawImage(imgIcon, 0, 3400, null);
			g.drawImage(imgIcon, 1500, 3400, null);
			g.drawImage(imgIcon, 3000, 3400, null);
			
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
			g.dispose();
			os = new FileOutputStream(ImgPath);
			ImageIO.write(buffImg, "JPG", os);
		}catch(Exception ep){System.out.println("图像加水印出错"+ep.getMessage());ep.printStackTrace();}finally{
			try {
				if (null != os)
					os.close();
			} catch (Exception e) { }
		}
	}
	
	/**
	 * 1.从旧文件拷贝内容到新文件
	 * 2.删除旧文件
	 * @param oldPath
	 * @param newPath
	 * @throws Exception
	 */
	public static void transferFile(String oldPath,String newPath) throws Exception {
		int byteread = 0;
		File oldFile = new File(oldPath);
		FileInputStream fin = null;
		FileOutputStream fout = null;
		try {
			if (oldFile.exists()) {
				fin = new FileInputStream(oldFile);
				fout = new FileOutputStream(newPath);
				byte[] buffer = new byte[1024];
				while ((byteread = fin.read(buffer)) != -1) {
//					System.out.println("byteread==" + byteread);
					fout.write(buffer, 0, byteread);
					fout.flush();
					buffer = new byte[1024];
				}
				if (fin != null) {
					fin.close();// 如果流不关闭,则删除不了旧文件
					delFile(oldFile);
				}
			} else {
				throw new Exception("需要转移的文件不存在!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (fin != null) {
				fin.close();
			}
		}
	}
	/**
	 * 删除文件,只支持删除文件,不支持删除目录
	 * @param file
	 * @throws Exception
	 */
	public static void delFile(File file) throws Exception {
		if (!file.exists()) {
			throw new Exception("文件" + file.getName() + "不存在,请确认!");
		}
		if (file.isFile()) {
			if (file.canWrite()) {
				file.delete();
			} else {
				throw new Exception("文件" + file.getName() + "只读,无法删除,请手动删除!");
			}
		} else {
			throw new Exception("文件" + file.getName() + "不是一个标准的文件,有可能为目录,请确认!");
		}
	}
	/**
	 * 将文件转换成BYTE字符串(用于网络传输)
	 * @param path
	 * @return
	 */
	public static String FileToByte(String path){
		try{
			File audio=new File(path);
			FileInputStream inputFile = new FileInputStream(audio);
			byte[] buffer = new byte[(int) audio.length()];
			inputFile.read(buffer);
			inputFile.close();
			String ByteStr = new String(Base64.encodeBase64(buffer));
//			try{
//				delFile(audio);//读取完之后就删除临时文件
//			}catch (Exception e) { }
			return ByteStr;
		}catch (Exception e) { }
		return "";
	}
	
	
    /**
     * @param args
     */
    public static void main(String[] args) {
//    	ImgWatermark("Z:/0.jpg");//添加水印
    	
    	
//    	try{//调用本地的VBS文件
//	    	String[] cpCmd  = new String[]{"wscript", "G:/孙帅C#软件/TextToVoice/TextToVoice/bin/Debug/sp/2017323/201732316409.vbs"};    
//	        Process process = Runtime.getRuntime().exec(cpCmd);    
//	        // wait for the process end    
//	        int val = process.waitFor();//val 是返回值  
//    	}catch(Exception e){}
    	
    	
    	
//		System.out.println(CorewareUtil.GetRmStr(100));
    	
    	
    	

//		CorewareUtil cu=new CorewareUtil();
//		//没有参数的请求方式
//		String jsonStr=getHttpClentsJson("http://10.132.5.24:8080/objectserver/restapi/alerts/status?collist=ServerSerial");
//		System.out.println(jsonStr);

        //有参数的请求方式
//		JSONArray params=new JSONArray();
//		JSONObject param1=new JSONObject();
//		param1.put("key", "name");
//		param1.put("value", "sunshuai");
//		params.add(param1);
//		
//		JSONObject param2=new JSONObject();
//		param2.put("key", "password");
//		param2.put("value", "123456");
//		params.add(param2);
//		
//		String jsonStr=postHttpClentsJson("http://localhost:8888/som-mobile/comroom/getmenulist",params);
//		System.out.println(jsonStr);
    	
    	
//    	Map a=new HashMap();
//    	a.put("bizEnName", "BIZ_1JZJY");
//    	System.out.println(postHttpClentsJson("http://192.168.1.5/cw-cmdb/getaction/getBizConfig",a));

    	
    	
//    	try{
//    		CutZoomImage("Z:/IMG_20150810_190921.jpg","Z:/suo123456.jpg",640,366);
//    	}catch(Exception ep){ep.printStackTrace();}
    	
//    	try{
//	    	File audio=new File("Z:\\1.jpg");
//	    	FileInputStream inputFile = new FileInputStream(audio);
//	    	byte[] buffer = new byte[(int) audio.length()];
//	    	inputFile.read(buffer);
//			inputFile.close();
//			String json = new String(Base64.encodeBase64(buffer));  
//	        System.out.println(json);
//
//	        BufferedOutputStream bos = null;
//	        FileOutputStream fos = null;
//	        File file = null;
//      	}catch(Exception ep){ep.printStackTrace();}

       /* String json="{\"body\":{\"organ_id\":null,\"phone_number\":\"13580235004\",\"user_type\":\"1\",\"team_name\":\"稽核中心南部区域中心\",\"dept_type\":\"0\",\"rolenames\":\"测试审批角色A,区域中心经责部负责人,常规培训一级审批人,区域副职,测试一下,测,测试测试,6-19测试 ,常规部会签,新增审批角色B,testone,测试666\",\"isleader\":\"0\",\"user_name\":\"tt1\",\"company_name\":null,\"email\":\"tt1@ac.cntaiping.com\",\"real_name\":\"tt1\",\"approvalroleids\":\"208,84,141,64,283,282,281,280,279,268,242,218,217\",\"user_id\":\"20000\",\"team_id\":\"23\"},\"head1\":{\"api_id\":\"\",\"service_ip\":\"10.225.15.9:8080\",\"request_type\":\"02\",\"sender_code\":\"030001\",\"sendreqtime\":\"2017-06-28 10:16:00\",\"version\":\"1.0\"},\"head2\":{\"message\":\"登陆成功！\",\"isflag\":\"1\",\"action_type\":\"\",\"action_name\":\"AppLogin\",\"user_id\":\"20000\",\"pjcode\":\"\"}}";
        JSONObject JA=JSONObject.fromObject(json);
        JSONObject body=JA.optJSONObject("body");
        JSONObject head2=JA.optJSONObject("head2");
        String userId= body .optString("user_id");
        userId=EncryptUtil.encryptAES(userId,"");
        body.put("user_id",userId);
        head2.put("user_id",userId);
        String u=EncryptUtil.decrypt(userId,"");
        System.out.println(JA.toString());*/
        System.out.println(getEncode("asd1234-"));
    }
}
