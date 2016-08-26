package com.prin.zlayer.demo.model.request;

/**
 * Created by prin on 2016/8/26.
 */
public class BaseRequest {

    public String time;
    public String app_type;
    public String token;

    public String getApp_type() {
        return app_type;
    }

    public void setApp_type(String app_type) {
        this.app_type = app_type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTime() {

        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
