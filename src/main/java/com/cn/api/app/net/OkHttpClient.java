package com.cn.api.app.net;

import com.cn.api.app.listener.OnResultListener;
import com.cn.api.app.utils.ReportUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
public class OkHttpClient {
    private static OkHttpClient mInstance;
    private okhttp3.OkHttpClient client = null;

    private OkHttpClient() {
    }

    public static OkHttpClient getInstance() {
        if (null == mInstance) {
            synchronized (OkHttpClient.class) {
                if (null == mInstance) {
                    mInstance = new OkHttpClient();
                }
            }
        }
        return mInstance;
    }

    private static TrustManager[] buildTrustManagers() {
        return new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return new java.security.cert.X509Certificate[]{};
                    }
                }
        };
    }

    /**
     * OkHttpClient的实现
     * 包括cookie的实现
     *
     * @return
     */
    public okhttp3.OkHttpClient getClient() {
        if (null == client) {
            try {
                TrustManager[] trustAllCerts = buildTrustManagers();
                final SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
                final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
                //okHttp3
                okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient().newBuilder();
                builder.readTimeout(30, TimeUnit.SECONDS);
                builder.connectTimeout(30, TimeUnit.SECONDS);
                builder.writeTimeout(60, TimeUnit.SECONDS);
                //clientBuilder.cookieJar(new CookieJarImpl());
                builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
                client = builder.build();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return client;
    }

    private String parseUrl(String url, Map<String, Object> hashMap) {
        StringBuilder sbf = new StringBuilder(url);
        if (sbf.indexOf("?") == -1) {
            sbf.append("?");
        }
        if (sbf.lastIndexOf("&") == -1) {
            sbf.append("&");
        }
        if (null != hashMap) {
            for (String key : hashMap.keySet()) {
                sbf.append(key).append("=").append(hashMap.get(key)).append("&");
            }
            url = sbf.deleteCharAt(sbf.lastIndexOf("&")).toString();
        } else {
            url = sbf.toString();
        }
        return url;
    }

    public void execute(String url, String method, Map<String, Object> paramMap, Map<String, String> headerMap, @Nullable OnResultListener listener) {
        ReportUtil.log("url:" + url);
        //ReportUtil.log("param:" + param.replace("\r\n", "").replace("\n", ""));
        if ("get".equalsIgnoreCase(method)) { // 封装get方法
            doGet(url, paramMap, listener);
        } else {// 封装post、upload、delete方法 , upload表示上传，也是使用post进行请求
            doRequest(url, method, paramMap, headerMap, listener);
        }
    }

    /**
     * doGet
     *
     * @param url
     * @param paramMap
     * @param listener
     */
    public void doGet(String url, Map<String, Object> paramMap, @Nullable OnResultListener listener) {
        try {
            Request request = new Request.Builder().url(parseUrl(url, paramMap)).build();
            Response response = getClient().newCall(request).execute();
            listener.onResponse(response);
        } catch (IOException e) {
            listener.onFailure(e);
        }
    }

    /**
     * doPost
     *
     * @param url
     * @param paramMap
     * @param headerMap
     * @param listener
     */
    public void doPost(String url, Map<String, Object> paramMap, Map<String, String> headerMap, @Nullable OnResultListener listener) {
        doRequest(url, "post", paramMap, headerMap, listener);
    }

    /**
     * doRequest
     *
     * @param url
     * @param paramMap
     * @param headerMap
     * @param listener
     */
    private void doRequest(String url, String method, Map<String, Object> paramMap, Map<String, String> headerMap, @Nullable OnResultListener listener) {
        try {
            FormBody.Builder formBodyBuilder = new FormBody.Builder();
            //缺少封装MutilpartBody
            if (null != paramMap && paramMap.size() > 0) {
                for (String key : paramMap.keySet()) {
                    formBodyBuilder.add(key, paramMap.get(key).toString());
                }
            }
            FormBody formBody = formBodyBuilder.build();
            Headers.Builder headerBuilder = new Headers.Builder();
            headerBuilder.add("accept", "text/plain, text/html,application/json");
            headerBuilder.add("accept-encoding", "gzip, deflate, br");
            headerBuilder.add("accept-language", "zh-CN,zh;q=0.9,en;q=0.8");
            headerBuilder.add("content-type", "Content-Type: text/html; charset=utf-8");
            if (null != headerMap && headerMap.size() > 0) {
                for (String key : headerMap.keySet()) {
                    headerBuilder.add(key, headerMap.get(key));
                }
            }
            Headers headers = headerBuilder.build();
            Request.Builder requestBuilder = new Request.Builder();
            if ("post".equalsIgnoreCase(method) || "upload".equalsIgnoreCase(method)) {// 封装post方法
                requestBuilder.post(formBody);
            } else if ("put".equalsIgnoreCase(method)) {// 封装put方法
                requestBuilder.put(formBody);
            } else if ("delete".equalsIgnoreCase(method)) {// 封装delete方法
                requestBuilder.delete(formBody);
            }
            requestBuilder.headers(headers);
            requestBuilder.url(url);
            Request request = requestBuilder.build();
            //log.info("doPost=" + url);
            Response response = getClient().newCall(request).execute();
            listener.onResponse(response);
        } catch (IOException e) {
            listener.onFailure(e);
        }
    }

}
