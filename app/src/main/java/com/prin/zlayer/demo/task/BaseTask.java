package com.prin.zlayer.demo.task;

import com.prin.zlayer.demo.model.ApiService;
import com.prin.zlayer.demo.model.BaseResponse;
import com.prin.zlayer.lib.net.ZApiClient;
import com.prin.zlayer.lib.net.ZClient;
import com.prin.zlayer.lib.net.ZNetCallBack;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by prin on 2016/8/23.
 */
public abstract class BaseTask<T> implements ZClient {

    protected ApiService mApiService;
    private static final String BASE_URL = "http://www.weather.com.cn/";
    private ZNetCallBack<T> mCallBack;

    public BaseTask(ZNetCallBack<T> callBack) {
        mCallBack = callBack;
        mApiService = ZApiClient.getBuilder(BASE_URL).build().create(ApiService.class);
    }

    @Override
    public void start() {
        Call<BaseResponse<T>> call = onRequest();
        call.enqueue(new Callback<BaseResponse<T>>() {
            @Override
            public void onResponse(Call<BaseResponse<T>> call, Response<BaseResponse<T>> response) {
                mCallBack.onSuccess(response);
            }

            @Override
            public void onFailure(Call<BaseResponse<T>> call, Throwable t) {
                mCallBack.onSuccess(t);
            }
        });
    }

    @Override
    public void cancel() {

    }

    protected abstract Call<BaseResponse<T>> onRequest();
}
