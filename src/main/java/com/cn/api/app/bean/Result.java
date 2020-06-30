package com.cn.api.app.bean;

import lombok.ToString;

@ToString
public class Result<T> {
    public int code;
    public String message;
    public T data;
}
