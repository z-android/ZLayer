package com.prin.zlayer.lib.net;

/**
 * Created by prin on 2016/8/22.
 * 网络回调
 */
public interface ZNetCallBack<T> {

    void onSuccess(T response);

    void onFailure(int errCode, String errMsg);
}
