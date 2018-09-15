package com.it.common.uitl.http;

import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.http.Consts;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class HttpsUtils {

    private static final String HTTP = "http";
    private static final String HTTPS = "https";
    private static SSLConnectionSocketFactory sslsf = null;
    private static PoolingHttpClientConnectionManager cm = null;
    private static SSLContextBuilder builder = null;

    static {
        try {
            builder = new SSLContextBuilder();
            // 全部信任 不做身份鉴定
            builder.loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            });
            sslsf = new SSLConnectionSocketFactory(builder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(HTTP, new PlainConnectionSocketFactory())
                    .register(HTTPS, sslsf)
                    .build();
            cm = new PoolingHttpClientConnectionManager(registry);
            //max connection
            cm.setMaxTotal(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void config(HttpRequestBase httpRequestBase,String access_token) {
        httpRequestBase.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0");
        httpRequestBase.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpRequestBase.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        httpRequestBase.setHeader("Accept-Encoding", "gzip, deflate");
        httpRequestBase.addHeader("CookieContainer", "keep-alive");
        httpRequestBase.addHeader("Upgrade-Insecure-Requests","1");
        
        if(access_token != null){
            httpRequestBase.addHeader("Authorization","Bearer " + access_token);
        }

        // 配置请求的超时设置
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(30 * 1000)
                .setConnectTimeout(30 * 1000).setSocketTimeout(30 * 1000)
                .build();
        httpRequestBase.setConfig(requestConfig);

    }


    /**
     * httpClient get请求
     * @param url 请求url
     * @return 可能为空 需要处理
     * @throws Exception
     *
     */
    public static String get(String url,String access_token)throws Exception{
        String result = "";
        CloseableHttpClient httpClient = null;
        try {
            httpClient = getHttpClient();
            HttpGet httpGet = new HttpGet(url);
            // 设置头信息
            config(httpGet,access_token);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity resEntity = httpResponse.getEntity();
                result = EntityUtils.toString(resEntity);
            } else {
                readHttpResponse(httpResponse);
            }
        } catch (Exception e) {throw e;
        } finally {
            if (httpClient != null) {
                httpClient.close();
            }
        }
        return result;
    }

//    public static void main(String[] args) {
//        Map<String,File> fileMap = new HashMap<>();
//        fileMap.put("file",new File("C:\\82af0c7ef6d715c59b.jpg"));
//        fileMap.put("file1",new File("C:\\82af0c7ef6d7151111.jpg"));
//        try {
//            String res = postFile(fileMap,"http://localhost:8042//batchUpload.json");
//            System.out.println(res);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    /**
     * 将文件提交至文件服务器
     * @param fileMap 文件对象
     * @return FileStatus 上传结果
     */
    public static String postFile(Map<String,File> fileMap,String url) throws Exception {
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        String result = null;
        try {
            httpclient = getHttpClient();
            HttpPost httpPost = new HttpPost(url);
            MultipartEntityBuilder mEntityBuilder = MultipartEntityBuilder.create();
            for (Map.Entry<String, File> entry : fileMap.entrySet()) {
                mEntityBuilder.addBinaryBody(entry.getKey(), entry.getValue());
            }

            httpPost.setEntity(mEntityBuilder.build());
            response = httpclient.execute(httpPost);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity resEntity = response.getEntity();
                result = EntityUtils.toString(resEntity);
                // 消耗掉response
                EntityUtils.consume(resEntity);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            HttpClientUtils.closeQuietly(httpclient);
            HttpClientUtils.closeQuietly(response);
        }
        return result;
    }


    /**
     * httpClient post请求
     * @param url 请求url
     * @param param 请求参数 form提交适用
     * @return 可能为空 需要处理
     * @throws Exception
     *
     */
    public static String post(String  url, Map<String, Object> param,String access_token) throws Exception {
        String result = "";
        CloseableHttpClient httpClient = null;
        try {
            httpClient = getHttpClient();
            HttpPost httpPost = new HttpPost(url);
            
            // 设置头信息
            config(httpPost, access_token);
            // 设置请求参数
            if (MapUtils.isNotEmpty(param)) {
                List<NameValuePair> formparams = new ArrayList<NameValuePair>();
                for (Map.Entry<String, Object> entry : param.entrySet()) {
                    //给参数赋值
                    formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
                }
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
                httpPost.setEntity(urlEncodedFormEntity);
            }
            HttpResponse httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK
                    || statusCode == HttpStatus.SC_UNAUTHORIZED
                    || statusCode == HttpStatus.SC_UNPROCESSABLE_ENTITY) {
                HttpEntity resEntity = httpResponse.getEntity();
                result = EntityUtils.toString(resEntity);
            } else {
                readHttpResponse(httpResponse);
            }
        } catch (Exception e) {throw e;
        } finally {
            if (httpClient != null) {
                httpClient.close();
            }
        }
        return result;
    }

    public static CloseableHttpClient getHttpClient() throws Exception {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .setConnectionManager(cm)
                .setConnectionManagerShared(true)
                .build();
        return httpClient;
    }

    public static String readHttpResponse(HttpResponse httpResponse)
            throws ParseException, IOException {
        StringBuilder builder = new StringBuilder();
        // 获取响应消息实体
        HttpEntity entity = httpResponse.getEntity();
        // 响应状态
        builder.append("status:" + httpResponse.getStatusLine());
        builder.append("headers:");
        HeaderIterator iterator = httpResponse.headerIterator();
        while (iterator.hasNext()) {
            builder.append("\t" + iterator.next());
        }
        // 判断响应实体是否为空
        if (entity != null) {
            String responseString = EntityUtils.toString(entity);
            builder.append("response length:" + responseString.length());
            builder.append("response content:" + responseString.replace("\r\n", ""));
        }
        return builder.toString();
    }
}
