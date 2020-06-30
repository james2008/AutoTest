package com.cn.api.app.listener;

public interface CallBackListener {
    /**
     * onSuccess
     *
     * @param content
     */
    public void onSuccess(String content);
    /**
     * onFailure
     *
     * @param content
     */
    public void onFailure(String content);
}
