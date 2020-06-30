package com.cn.api.app.test.test;

import com.cn.api.app.bean.ApiDataBean;
import com.cn.api.app.configs.ApiConfig;
import com.cn.api.app.listener.OnResultListener;
import com.cn.api.app.log.Logger;
import com.cn.api.app.net.OkHttpClient;
import com.cn.api.app.utils.ReportUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.dom4j.DocumentException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

@Slf4j
public class ApiAutoTest extends TestBase {
    /**
     * 配置
     */
    private static ApiConfig apiConfig;

    /**
     * 是否使用form-data传参 会在post与put方法封装请求参数用到
     */
    private static boolean requestByFormData = false;
    /**
     * 所有api测试用例数据
     */
    protected List<ApiDataBean> dataList = new ArrayList<ApiDataBean>();

    /**
     * 初始化测试数据
     *
     * @throws Exception
     */
    @Parameters("envName")
    @BeforeSuite
    public void init(@Optional("api-config.xml") String envName) throws Exception {
        ReportUtil.log("init---");
        String configFilePath = Paths.get(System.getProperty("user.dir"), envName).toString();
        ReportUtil.log("api config path:" + configFilePath);
        apiConfig = new ApiConfig(configFilePath);
        // 获取基础数据
        rootUrl = apiConfig.getRootUrl();
        rooUrlEndWithSlash = rootUrl.endsWith("/");
        ReportUtil.log("rootUrl:" + rootUrl);
        // 读取 param，并将值保存到公共数据map
        Map<String, String> params = apiConfig.getParams();
        ReportUtil.log("params---"+params.toString());
        //setSaveDates(params);

//        List<Header> headers = new ArrayList<Header>();
//        apiConfig.getHeaders().forEach((key, value) -> {
//            Header header = new BasicHeader(key, value);
//            if(!requestByFormData && key.equalsIgnoreCase("content-type") && value.toLowerCase().contains("form-data")){
//                requestByFormData=true;
//            }
//            headers.add(header);
//        });
//        publicHeaders = headers.toArray(new Header[headers.size()]);
    }

    @Parameters("xmlPath")
    @BeforeTest
    public void readData(@Optional("case/api-data.xml") String xmlPath) throws DocumentException {
        ReportUtil.log("readData---");
        dataList = readXmlData(ApiDataBean.class, xmlPath.split(";"));
    }

    /**
     * 过滤数据，run标记为Y的执行。
     *
     * @return
     * @throws DocumentException
     */
    @DataProvider(name = "ApiData")
    public Iterator<Object[]> getApiData(ITestContext context) throws DocumentException {
        ReportUtil.log("getApiData---");
        List<Object[]> dataProvider = new ArrayList<Object[]>();
        for (ApiDataBean data : dataList) {
            if (data.isRun()) {
                dataProvider.add(new Object[]{data});
            }
        }
        return dataProvider.iterator();
    }

    @Test(dataProvider = "ApiData")
    public void apiAutoTest(ApiDataBean apiDataBean) throws Exception {
        ReportUtil.log("apiAutoTest test start ---");
        if (apiDataBean.getSleep() > 0) {
            // sleep休眠时间大于0的情况下进行暂停休眠
            ReportUtil.log(String.format("sleep %s seconds", apiDataBean.getSleep()));
            Thread.sleep(apiDataBean.getSleep() * 1000);
        }
        Map<String,Object> paramMap = buildRequestParam(apiDataBean);
        Map<String,String> headerMap= buildHeaderParam(apiConfig.getHeaders());
        Logger.info("headerMap=" + headerMap.toString());
        try {
            OkHttpClient.getInstance().execute(parseUrl(apiDataBean.getUrl()), apiDataBean.getMethod(), paramMap, headerMap, new OnResultListener() {
                @Override
                public void onResponse(Response response) {
                    try {
                        dealResponse(apiDataBean, response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onFailure(Exception e) {
                    Logger.error("apiAutoTest", e);
                }
            });
        } catch (Exception e) {
            Logger.error("apiAutoTest:",e);
        }
    }

    private void dealResponse(ApiDataBean apiDataBean, Response response) throws IOException {
        String resultStr = response.body().string();
        int responseStatus = response.code();
        if (response.isSuccessful()) {//200
            if (apiDataBean.getStatus() != 0) {
                Assert.assertEquals(responseStatus, apiDataBean.getStatus(), "返回状态码与预期不符合!");
            }
        } else if (200 > responseStatus || responseStatus >= 300) {//非2开头状态码为异常请求，抛异常后会进行重跑
            ReportUtil.log("返回状态码非200开头：" + responseStatus);
        }

        // 输出返回数据log
        ReportUtil.log("resp:" + resultStr);
        // 验证预期信息
        //ReportUtil.log("getVerify:" + apiDataBean.getVerify() + "isContains:" + apiDataBean.isContains());
//        verifyResult(resultStr, apiDataBean.getVerify(),apiDataBean.isContains());
        // 对返回结果进行提取保存。
        // ReportUtil.log("getSave:" + apiDataBean.getSave());
        saveResult(resultStr, apiDataBean.getSave());
    }

}
