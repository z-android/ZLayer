package com.prin.zlayer.demo.model.client;

import com.prin.zlayer.lib.net.ZClient;
import com.prin.zlayer.lib.net.ZNetCallBack;
import com.prin.zlayer.lib.net.ZRequestParams;

/**
 * Created by prin on 2016/8/22.
 */
public class LoginClient implements ZClient {

    private ZRequestParams mParams;
    private ZNetCallBack mCallBack;

    public LoginClient(ZRequestParams params, ZNetCallBack callBack) {
        mParams = params;
        mCallBack = callBack;
    }

    @Override
    public void start() {

    }

    @Override
    public void cancel() {

    }
}
