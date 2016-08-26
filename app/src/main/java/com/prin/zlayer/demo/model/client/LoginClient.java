package com.prin.zlayer.demo.model.client;

import com.prin.zlayer.demo.model.request.LoginRequest;

import prin.com.zlayer.net.ZNetResponse;
import retrofit2.Call;

/**
 * Created by prin on 2016/8/22.
 */
public class LoginClient extends ServiceOneBoxClient {

    private LoginRequest mRequest;

    public LoginClient(LoginRequest request,ZNetResponse netResponse) {
        super(netResponse);
        if (TokenClient.token_dead) {
            //如果token过期，调用token接口
            new TokenClient(null).start();
        } else {
            mRequest=request;
        }
    }

    @Override
    public Call onRequest() {
        return mService.postLogin(mRequest);
    }
}
