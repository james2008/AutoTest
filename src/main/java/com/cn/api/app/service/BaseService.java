package com.cn.api.app.service;

import com.alibaba.fastjson.JSONObject;
import com.cn.api.app.bean.BaseEntity;
import com.cn.api.app.contants.Contants;
import com.cn.api.app.listener.CallBackListener;
import com.cn.api.app.listener.OnResultListener;
import com.cn.api.app.net.OkHttpClient;
import com.cn.api.app.util.ClassType;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

@Slf4j
public class BaseService<T> implements IBasicService {
    public String url = Contants.SERVICE_URL;

    public BaseService() {
//        Type t = getClass().getGenericSuperclass();
//        ParameterizedType p = (ParameterizedType) t;
//        Class<T> c = (Class<T>) p.getActualTypeArguments()[0];
//        log.info("Class<T> " + c.getSimpleName());
    }

    public void doPost( String url,  HashMap hashMap,final  OnResultListener listener) {
//        OkHttpClient.getInstance().doPost(getRemoteUrl(url), hashMap, new CallBackListener() {
//
//            public void onSuccess(String json) {
//                if (null != listener) {
//                    Class<T> clazz = new ClassType().convertToClass(BaseService.this.getClass());
//                    listener.onDataResult(toJson(json, clazz));
//                }
//            }
//
//            public void onFailure(String content) {
//                if (null != listener) {
//                    log.info("onFailure==" + content);
//                    listener.onFailure(content);
//                }
//            }
//        });
    }

    public void doGet( String url,  HashMap hashMap,final  OnResultListener listener) {
//        OkHttpClient.getInstance().doGet(url, hashMap, new CallBackListener() {
//
//            public void onSuccess(String content) {
//
//            }
//
//            public void onFailure(String content) {
//
//            }
//        });
    }

    private String getRemoteUrl(String url) {
        return this.url + "/" + url;
    }

    private BaseEntity<T> toJson(String jsonData, Class<T> clazz) {
        log.info("jsonData " + jsonData);
        BaseEntity bean = null;
        JSONObject jsonObject = JSONObject.parseObject(jsonData);
        if (null != jsonObject) {
            BaseEntity<T> baseEntity = new BaseEntity();
            String errorCode = jsonObject.getString("errCode");
            if (errorCode.equals(Contants.ERROR_CODE)) {
                baseEntity.setErrMsg(jsonObject.getString("errMsg"));
                baseEntity.setErrCode(errorCode);
                log.info("BaseEntity==" + baseEntity.toString());
                return baseEntity;
            }
            Gson gson = new Gson();
            Type objectType = type(BaseEntity.class, clazz);
            bean = gson.fromJson(jsonData, objectType);
        }
        return bean;
    }

    static ParameterizedType type(final Class raw, final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return raw;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }

}
