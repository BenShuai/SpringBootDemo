package com.it.common.uitl.uitls;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map; 
/*** 
 * 日期工具类 
 *  
 * @author damao 
 * 
 */  
public class DateAndTimeUtil {
	public static String getRunDateFormat() {
	   Date date = new Date();
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 return sdf.format(date);  
}
	/*** 
     * 日期月份减一个月 
     *  
     * @param datetime 
     *            日期(2014-11) 
     * @return 2014-10 
     */  
    public static String dateFormat(String datetime) {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");  
        Date date = null;  
        try {  
            date = sdf.parse(datetime);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        Calendar cl = Calendar.getInstance();  
        cl.setTime(date);  
        cl.add(Calendar.MONTH, -1);  
        date = cl.getTime();  
        return sdf.format(date);  
    }  
  
    public static String dateFormat(Date date) {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");  
        return sdf.format(date);  
    }  
    public static String dateFormatValue(Date date) {  
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
        
        return sdf.format(date);  
    }  
    /**** 
     * 传入具体日期 ，返回具体日期减一个月。 
     *  
     * @param date 
     *            日期(2014-04-20) 
     * @return 2014-03-20 
     * @throws ParseException 
     */  
    public static String subMonth(String date) throws ParseException {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Date dt = sdf.parse(date);  
        Calendar rightNow = Calendar.getInstance();  
        rightNow.setTime(dt);  
  
        rightNow.add(Calendar.MONTH, -1);  
        Date dt1 = rightNow.getTime();  
        String reStr = sdf.format(dt1);  
  
        return reStr;  
    }  
    
    /**** 
     * 传入具体增加月份 ，返回具体日期加N个月。 
     *  
     * @return Date
     * @throws ParseException 
     */  
    public static Date getAddMonth(int addMonthNumber) throws ParseException { 
        Date dt = new Date();
        Calendar rightNow = Calendar.getInstance();  
        rightNow.setTime(dt);  
        rightNow.add(Calendar.MONTH, addMonthNumber);  
        Date dt1 = rightNow.getTime();  
        return dt1;  
    }  
    /**** 
     * 传入具体日期 ，返回具体日期加N个月。 
     *  
     * @return Date
     * @throws ParseException 
     */  
    public static int getAddYear(Date dt,int addMonthNumber) throws ParseException { 
        
        Calendar rightNow = Calendar.getInstance();  
        rightNow.setTime(dt);  
        rightNow.add(Calendar.MONTH, addMonthNumber);  
        
        int year = rightNow.get(Calendar.YEAR); 
        return year;
    }  
   
    /**** 
     * 传入具体日期 ，返回具体日期加N个月。 
     *  
     * @return Date
     * @throws ParseException 
     */  
    public static int getAddMonthValue(Date dt,int addMonthNumber) throws ParseException { 
        Calendar rightNow = Calendar.getInstance();  
        rightNow.setTime(dt);  
        rightNow.add(Calendar.MONTH, addMonthNumber);  
        int month = rightNow.get(Calendar.MONTH) + 1;
        return month;
    }  
    /**** 
     * 获取月末最后一天 
     *  
     * @param sDate 
     *            2014-11-24 
     * @return 30 
     */  
    private static String getMonthMaxDay(String sDate) {  
        SimpleDateFormat sdf_full = new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();  
        Date date = null;  
        try {  
            date = sdf_full.parse(sDate + "-01");  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        cal.setTime(date);  
        int last = cal.getActualMaximum(Calendar.DATE);  
        return String.valueOf(last);  
    }  
  
    // 判断是否是月末  
    public static boolean isMonthEnd(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        if (cal.get(Calendar.DATE) == cal  
                .getActualMaximum(Calendar.DAY_OF_MONTH))  
            return true;  
        else  
            return false;  
    }  
  
    /*** 
     * 日期减一天、加一天 
     *  
     * @param option 
     *            传入类型 pro：日期减一天，next：日期加一天 
     * @param _date 
     *            2014-11-24 
     * @return 减一天：2014-11-23或(加一天：2014-11-25) 
     */  
    public static String checkOption(String option, String _date) {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cl = Calendar.getInstance();  
        Date date = null;  
  
        try {  
            date = (Date) sdf.parse(_date);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        cl.setTime(date);  
        if ("pre".equals(option)) {  
            // 时间减一天  
            cl.add(Calendar.DAY_OF_MONTH, -1);  
  
        } else if ("next".equals(option)) {  
            // 时间加一天  
            cl.add(Calendar.DAY_OF_YEAR, 1);  
        } else {  
            // do nothing  
        }  
        date = cl.getTime();  
        return sdf.format(date);  
    }  
  
    /*** 
     * 判断日期是否为当前月， 是当前月返回当月最小日期和当月目前最大日期以及传入日期上月的最大日和最小日 
     * 不是当前月返回传入月份的最大日和最小日以及传入日期上月的最大日和最小日 
     *  
     * @param date 
     *            日期 例如：2014-11 
     * @return String[] 开始日期，结束日期，上月开始日期，上月结束日期 
     * @throws ParseException 
     */  
    public static String[] getNow_Pre_Date(String date) throws ParseException {  
  
        String[] str_date = new String[4];  
        Date now = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");  
        SimpleDateFormat sdf_full = new SimpleDateFormat("yyyy-MM-dd");  
        String stMonth = sdf.format(now);  
        String stdate = "";// 开始日期  
        String endate = "";// 结束日期  
        String preDate_start = "";// 上月开始日期  
        String preDate_end = "";// 上月结束日期  
  
        // 当前月  
        if (date.equals(stMonth)) {  
            stdate = stMonth + "-01"; // 2014-11-01  
            endate = sdf_full.format(now);// 2014-11-24  
            preDate_start = subMonth(stdate);// 2014-10-01  
            preDate_end = subMonth(endate);// 2014-10-24  
        } else {  
            // 非当前月  
            String monthMaxDay = getMonthMaxDay(date);  
            stdate = date + "-01";// 2014-10-01  
            endate = date + "-" + monthMaxDay;// 2014-10-31  
            preDate_start = subMonth(stdate);// 2014-09-01  
            preDate_end = subMonth(endate);// 2014-09-30  
        }  
        str_date[0] = stdate;  
        str_date[1] = endate;  
        str_date[2] = preDate_start;  
        str_date[3] = preDate_end;  
  
        return str_date;  
    }  
	 
	
	 
//    public static void main(String[] args) throws  Exception {
////    	List<YearMonthModel>  list = getYearMonth1(45);
////    	for(YearMonthModel ym:list) {
////    		System.out.println(ym.getYear()+"年"+ym.getMonth()+"月");
////    	}
//
//    	for(int i=0;i<60;i++) {
//    		 int month=DateAndTimeUtil.getAddMonthValue(new Date(),i);
//    		 int  year= DateAndTimeUtil.getAddYear(new Date(),i);
//    		 System.out.println(year+"年"+month+"月");
//    	}
//    }
}
