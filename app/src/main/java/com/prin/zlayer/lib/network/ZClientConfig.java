package com.prin.zlayer.lib.network;

import com.google.gson.Gson;

/**
 * Created by prin on 2016/8/23.
 * 网络请求的配置
 */
public class ZClientConfig {

    protected String BASE_URL;  //网络请求的基地址
    protected long time_out;    //网络请求的超时时间
    //    protected
    public boolean isRetry; //超时重试
    public Gson mGson;  //自定义gson

    public ZClientConfig() {
        time_out = 8;
        isRetry = false;
        mGson = new Gson();
    }

    public Gson getGson() {
        return mGson;
    }

    public void setGson(Gson gson) {
        mGson = gson;
    }

    public boolean isRetry() {
        return isRetry;
    }

    public void setRetry(boolean retry) {
        isRetry = retry;
    }

    public String getBASE_URL() {
        return BASE_URL;
    }

    public void setBASE_URL(String BASE_URL) {
        this.BASE_URL = BASE_URL;
    }

    public long getTime_out() {
        return time_out;
    }

    public void setTime_out(long time_out) {
        this.time_out = time_out;
    }
}
