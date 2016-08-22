package com.prin.zlayer.demo.presenter;

import com.prin.zlayer.demo.client.LoginClient;
import com.prin.zlayer.demo.client.RegisterClient;
import com.prin.zlayer.demo.model.BaseResponse;
import com.prin.zlayer.lib.net.ZClient;
import com.prin.zlayer.lib.net.ZNetCallBack;
import com.prin.zlayer.lib.net.ZNetResponse;
import com.prin.zlayer.lib.net.ZRequestParams;

/**
 * Created by prin on 2016/8/22.
 */
public class LoginPresenter {

    public void login() {
        ZRequestParams params = new ZRequestParams();

        ZClient client = new LoginClient(params, new ZNetCallBack() {
            @Override
            public void onSuccess(ZNetResponse response) {

            }

            @Override
            public void onFailure(int errCode, String errMsg) {

            }
        });
    }

    public void register() {
        ZClient client = new RegisterClient(new ZNetCallBack<BaseResponse>() {


            @Override
            public void onSuccess(BaseResponse response) {

            }

            @Override
            public void onFailure(int errCode, String errMsg) {

            }
        });
        client.start();
    }
}
