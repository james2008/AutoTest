package com.cn.api.app.bean;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class BaseEntity<T> implements Serializable {
    private static final long serialVersionUID = -3440061414071692254L;
    public String errMsg;
    public String errCode;
    public T result;
}
