package com.cn.api.app.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.api.app.listener.CallBackListener;
import com.cn.api.app.log.Logger;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonUtil {
    private static CallBackListener mListener;

    /**
     * 获取json中的值
     *
     * @param jsonStr
     * @param key
     * @return
     */
    public static void getJsonValue(String jsonStr, String key, CallBackListener listener) {
        mListener = listener;
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        parseMap(jsonObject, key);
    }

    private static void parseMap(Map map, String key) {
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            parseEntry(entry, key);
        }
    }

    private static void parseEntry(Map.Entry<String, Object> entry, String key) {
        if (entry.getValue() instanceof JSONArray) {
            List<Map<String, Object>> list = (List<Map<String, Object>>) entry.getValue();
            for (Map<String, Object> map : list) {
                parseMap(map, key);
            }
        } else if (entry.getValue() instanceof JSONObject) {
            Map map = (Map) entry.getValue();
            parseMap(map, key);
        } else {
            if (key.equals(entry.getKey())) {
                Logger.info("key= " + entry.getKey() + " value=" + entry.getValue());
                if (null != mListener) {
                    mListener.onSuccess(entry.getValue().toString());
                }
            }
        }
    }
}
