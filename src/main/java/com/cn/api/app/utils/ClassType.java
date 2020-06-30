package com.cn.api.app.util;

import com.cn.api.app.bean.BaseEntity;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Slf4j
public class ClassType<T> {

    public Class<T> convertToClass(Class<T> clazz) {
        Type classType = clazz.getGenericSuperclass();
        ParameterizedType p = (ParameterizedType) classType;
        Class<T> c = (Class<T>) p.getActualTypeArguments()[0];
        log.info("Class<T> " + c.getSimpleName());
        log.info("Class<T> " + c.toString());
        log.info("t==" + classType.getTypeName());
        return c;
    }
}
