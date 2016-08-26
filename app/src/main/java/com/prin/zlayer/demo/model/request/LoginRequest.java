package com.prin.zlayer.demo.model.request;

/**
 * Created by prin on 2016/8/26.
 */
public class LoginRequest extends BaseRequest {

    public String username;
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
