package com.cn.api.app.listener;

import okhttp3.Response;

public interface OnResultListener {
    /**
     * onResponse
     *
     * @param response
     */
    public void onResponse(Response response);

    /**
     * onFailure
     *
     * @param e
     */
    public void onFailure(Exception e);
}
