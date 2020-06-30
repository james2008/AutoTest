package com.cn.api.app.service;

import com.cn.api.app.listener.OnResultListener;

import java.util.HashMap;

public interface IBasicService<T> {

    public void doPost( String url,  HashMap hashMap,  OnResultListener listener);


    public void doGet( String url,  HashMap hashMap,  OnResultListener listener);
}

