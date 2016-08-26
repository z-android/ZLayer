package com.prin.zlayer.demo.presenter;

import com.prin.zlayer.demo.model.client.LoginClient;
import com.prin.zlayer.demo.model.request.LoginRequest;
import com.prin.zlayer.demo.model.response.RspLogin;
import com.prin.zlayer.demo.viewer.IMainView;

import prin.com.zlayer.mvp.ZLayerPresenter;
import prin.com.zlayer.net.ZNetResponse;
import prin.com.zlayer.utils.ZJsonUtils;
import prin.com.zlayer.utils.ZLogUtil;

/**
 * Created by prin on 2016/8/26.
 */
public class MainPostPresenter extends ZLayerPresenter<IMainView> {

    private static final String TAG = "MainPostPresenter:";

    /**
     * login
     */
    public void postLogin() {
        LoginRequest loginRequest = new LoginRequest();
        LoginClient client = new LoginClient(loginRequest, new ZNetResponse<RspLogin>() {
            @Override
            public void onSuccess(RspLogin response) {
                ZLogUtil.i(TAG + ZJsonUtils.instance().objToJson(response));
            }

            @Override
            public void onFailure(int errCode, String errMsg) {
                ZLogUtil.i(TAG + errCode + errMsg);
            }
        });
        client.start();
    }
}
