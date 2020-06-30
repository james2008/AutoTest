package com.cn.api.app.log;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Logger {
    private static Enum tag = Type.DEBUG;

    public static void println(String msg) {
        System.out.println(msg);
    }

    public static void error(String tag, Exception e) {
        System.out.println(tag + ": " + e.getLocalizedMessage());
    }

    public static void error(String tag, String msg) {
        System.out.println(tag + ": " + msg);
    }

    public static void error(String msg) {
        System.out.println(msg);
    }

    public static void info(String message) {
        info(null, message);
    }

    public static void info(String method, String message) {
        if (tag == Type.DEBUG) {
            if (null != method) {
                log.debug(method, message);
            } else {
                log.debug(message);
            }
        } else if (tag == Type.INFO) {
            if (null != method) {
                log.info(method, message);
            } else {
                log.info(message);
            }
        }
    }

    public static enum Type {
        DEBUG, INFO
    }
}
