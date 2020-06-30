package com.cn.api.app.service;

import com.cn.api.app.bean.LoginEntity;
import com.cn.api.app.listener.OnResultListener;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class LoginService extends BaseService<LoginEntity> {
    public String url = "Api/h5/user/p/login";
    private static HashMap<String, Object> hashMap = null;

    public void doLogin( HashMap hashMap,  OnResultListener listener) {
        super.doPost(this.url, hashMap, listener);
    }

    public void doGet( String url,  HashMap hashMap,  OnResultListener listener) {
        //super.doGet(loginEntity, url, hashMap, listener);
    }
}
