package com.cn.api.app.test.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.cn.api.app.bean.ApiDataBean;
import com.cn.api.app.bean.BaseBean;
import com.cn.api.app.contants.Contants;
import com.cn.api.app.listener.CallBackListener;
import com.cn.api.app.log.Logger;
import com.cn.api.app.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentException;
import org.dom4j.Entity;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class TestBase {
    /**
     * api请求跟路径
     */
    protected static String rootUrl;
    /**
     * 跟路径是否以‘/’结尾
     */
    protected static boolean rooUrlEndWithSlash = false;
    /**
     * 公共参数数据池（全局可用）
     */
    private static Map<String, String> saveDatas = new HashMap<String, String>();

    protected void setSaveDates(Map<String, String> map) {
        saveDatas.putAll(map);
    }

    /**
     * 所有api测试用例数据
     */
    protected List<ApiDataBean> dataList = new ArrayList<ApiDataBean>();
    /**
     * 替换符，如果数据中包含“${}”则会被替换成公共参数中存储的数据
     */
    protected Pattern replaceParamPattern = Pattern.compile("\\$\\{(.*?)\\}");
    /**
     * 截取自定义方法正则表达式：__xxx(ooo)
     */
    protected Pattern funPattern = Pattern.compile("__(\\w*?)\\((([\\w\\\\\\/:\\.\\$]*,?)*)\\)");// __(\\w*?)\\((((\\w*)|(\\w*,))*)\\)
    // __(\\w*?)\\(((\\w*,?\\w*)*)\\)

    /**
     * 格式化url,替换路径参数等。
     *
     * @param shortUrl
     * @return
     */
    public String parseUrl(String shortUrl) {
        // 替换url中的参数
        if (shortUrl.startsWith("http")) {
            return shortUrl;
        }
        if (rooUrlEndWithSlash == shortUrl.startsWith("/")) {
            if (rooUrlEndWithSlash) {
                shortUrl = shortUrl.replaceFirst("/", "");
            } else {
                shortUrl = "/" + shortUrl;
            }
        }
        return rootUrl + shortUrl;
    }

    /**
     * 组件预参数（处理__fucn()以及${xxxx}）
     *
     * @param param
     * @return
     */
    protected String buildParam(String param) {
        // 处理${}
        //param = getCommonParam(param);
        // Pattern pattern = Pattern.compile("__(.*?)\\(.*\\)");// 取__开头的函数正则表达式
        // Pattern pattern =
        // Pattern.compile("__(\\w*?)\\((\\w*,)*(\\w*)*\\)");// 取__开头的函数正则表达式
//        Matcher m = funPattern.matcher(param);
//        while (m.find()) {
//            String funcName = m.group(1);
//            String args = m.group(2);
//            String value;
//            // bodyfile属于特殊情况，不进行匹配，在post请求的时候进行处理
//            if (FunctionUtil.isFunction(funcName) && !funcName.equals("bodyfile")) {
//                // 属于函数助手，调用那个函数助手获取。
//                value = FunctionUtil.getValue(funcName, args.split(","));
//                // 解析对应的函数失败
//                Assert.assertNotNull(value, String.format("解析函数失败：%s。", funcName));
//                param = StringUtils.replaceFirst(param, m.group(), value);
//            }
//        }
        return param;
    }

    protected void savePreParam(String preParam) {
        // 通过';'分隔，将参数加入公共参数map中
        if (StringUtil.isEmpty(preParam)) {
            return;
        }
        String[] preParamArr = preParam.split(";");
        String key, value;
        for (String prepar : preParamArr) {
            if (StringUtil.isEmpty(prepar)) {
                continue;
            }
            key = prepar.split("=")[0];
            value = prepar.split("=")[1];
            ReportUtil.log(String.format("存储%s参数，值为：%s。", key, value));
            saveDatas.put(key, value);
        }
    }

    /**
     * 取公共参数 并替换参数
     *
     * @param param
     * @return
     */
    protected Map<String, String> getCommonParam(Map<String, String> param) {
        if (null == param) {
            return null;
        }
        if (saveDatas.size() > 0) {
            for (String key : saveDatas.keySet()) {
                param.put(key, saveDatas.get(key));
            }
        } else {
            Logger.info("公共参数中找不到!!!");
        }
        return param;
    }

    /**
     * 获取公共数据池中的数据
     *
     * @param key 公共数据的key
     * @return 对应的value
     */
    protected String getSaveData(String key) {
        if ("".equals(key) || !saveDatas.containsKey(key)) {
            return null;
        } else {
            return saveDatas.get(key);
        }
    }

    protected void verifyResult(String sourchData, String verifyStr, boolean contains) {
        if (StringUtil.isEmpty(verifyStr)) {
            return;
        }
        String allVerify = verifyStr;
        ReportUtil.log("验证数据：" + allVerify);
        if (contains) {
            // 验证结果包含
            AssertUtil.contains(sourchData, allVerify);
        } else {
            // 通过';'分隔，通过jsonPath进行一一校验
            Pattern pattern = Pattern.compile("([^;]*)=([^;]*)");
            Matcher m = pattern.matcher(allVerify.trim());
            while (m.find()) {
//                String actualValue = getBuildValue(sourchData, m.group(1));
//                String exceptValue = getBuildValue(sourchData, m.group(2));
//                ReportUtil.log(String.format("验证转换后的值%s=%s", actualValue, exceptValue));
//                Assert.assertEquals(actualValue, exceptValue, "验证预期结果失败。");
            }
        }
    }

    /**
     * 提取json串中的值保存至公共池中
     *
     * @param json    将被提取的json串。
     * @param allSave 所有将被保存的数据：xx=$.jsonpath.xx;oo=$.jsonpath.oo，将$.jsonpath.
     *                xx提取出来的值存放至公共池的xx中，将$.jsonpath.oo提取出来的值存放至公共池的oo中
     */
    protected void saveResult(String json, String allSave) {
        if (StringUtils.isEmpty(json) || StringUtils.isEmpty(allSave)) {
            return;
        }
        String[] keys = allSave.split(";");
        for (String key : keys) {
            JsonUtil.getJsonValue(json, key, new CallBackListener() {
                @Override
                public void onSuccess(String value) {
                    ReportUtil.log(String.format("存储公共参数   %s值为：%s ", key, value));
                    if (StringUtils.isNotEmpty(value)) {
                        saveDatas.put(Contants.TOKEN_KEY, value);
                    }
                }

                @Override
                public void onFailure(String value) {
                    ReportUtil.log(String.format("存储公共参数   %s值为：%s ", key, value));
                }
            });
        }
    }

    /**
     * 根据配置读取测试用例
     *
     * @param clz 需要转换的类
     * @return 返回数据
     * @throws DocumentException
     */
    protected <T extends BaseBean> List<T> readXmlData(Class<T> clz, String[] xmlPathArr) throws DocumentException {
        List<T> allExcelData = new ArrayList<T>();// xml文件數組
        List<T> temArrayList = new ArrayList<T>();
        for (String path : xmlPathArr) {
            File file = Paths.get(System.getProperty("user.dir"), path).toFile();
            temArrayList.clear();
            temArrayList = (List<T>) XmlUtil.readXml(clz, file.getAbsolutePath());
            allExcelData.addAll(temArrayList); // 将xml数据添加至list
        }
        return allExcelData;
    }

    public Map<String, Object> buildRequestParam(ApiDataBean apiDataBean) {
        // 分析处理预参数 （函数生成的参数）
        // String preParam = buildParam(apiDataBean.getPreParam());
        //Logger.info("preParam:",preParam);
        //savePreParam(preParam);// 保存预存参数 用于后面接口参数中使用和接口返回验证中
        String key = "";
        String value = "";
        // 处理参数
        String apiParam = apiDataBean.getParam(); //buildParam(apiDataBean.getParam());
        //Logger.info("apiParam:",apiParam);
        Map<String, Object> paramMap = new HashMap<>();
        if (!StringUtils.isEmpty(apiParam)) {
            String[] paramArray = apiParam.split(",");
            for (int i = 0; i < paramArray.length; i++) {
                String[] param = paramArray[i].split("=");
                if (param.length == 1) {
                    paramMap.put(param[0], "");
                } else if (param.length == 2) {
                    paramMap.put(param[0], param[1]);
                }
            }
        }
        return paramMap;
    }

    /**
     * 封装header
     *
     * @param param
     * @return
     */
    public Map<String, String> buildHeaderParam(Map<String, String> param) {
        return getCommonParam(param);
    }

}
