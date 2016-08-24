package com.prin.zlayer.lib.network;

import retrofit2.Call;

/**
 * Created by prin on 2016/8/23.
 * 网络请求封装类
 * （1）可自由切换底层网络请求的实现
 */
public abstract class ZBaseClient implements IClient {

    protected ZClientConfig mClientConfig;
    protected INetManager mManager;

    public ZBaseClient(ZClientConfig config) {
        mClientConfig = config;
        setNetManager();
    }

    private void setNetManager() {
        mManager = RetrofitManager.instance(new ZClientConfig());
    }


    @Override
    public void start() {
        mManager.start();
    }

    //发起请求
    public abstract Call<ZBaseResponse<T>> onRequest();


    @Override
    public void cancel() {
        mManager.cancel();
    }
}
