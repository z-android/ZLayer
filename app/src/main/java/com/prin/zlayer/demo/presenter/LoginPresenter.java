package com.prin.zlayer.demo.presenter;

import com.prin.zlayer.demo.client.LoginClient;
import com.prin.zlayer.demo.client.RegisterClient;
import com.prin.zlayer.demo.model.ApiClient;
import com.prin.zlayer.demo.model.BaseResponse;
import com.prin.zlayer.demo.model.RspWeather;
import com.prin.zlayer.demo.viewer.IMainView;
import com.prin.zlayer.lib.net.ZClient;
import com.prin.zlayer.lib.net.ZNetCallBack;
import com.prin.zlayer.lib.net.ZNetResponse;
import com.prin.zlayer.lib.net.ZRequestParams;
import com.prin.zlayer.lib.utils.ZLogUtil;
import com.prin.zlayer.lib.viewer.ZLayerPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by prin on 2016/8/22.
 */
public class LoginPresenter extends ZLayerPresenter<IMainView>{
    private static final String TAG = "LoginPresenter+";

    public void login() {
        ZRequestParams params = new ZRequestParams();

        ZClient client = new LoginClient(params, new ZNetCallBack<ZNetResponse>() {
            @Override
            public void onSuccess(ZNetResponse response) {

            }

            @Override
            public void onFailure(int errCode, String errMsg) {

            }
        });
        client.start();
    }

    public void register() {
        ZClient client = new RegisterClient(new ZNetCallBack<ZNetResponse>() {


            @Override
            public void onSuccess(ZNetResponse response) {

            }

            @Override
            public void onFailure(int errCode, String errMsg) {

            }
        });
        client.start();
    }

    public void getWeather() {
        Call<BaseResponse<RspWeather>> call = ApiClient.instance().getWeather("101010100");
        call.enqueue(new Callback<BaseResponse<RspWeather>>() {
            @Override
            public void onResponse(Call<BaseResponse<RspWeather>> call, Response<BaseResponse<RspWeather>> response) {
                ZLogUtil.i(TAG + response.body().toString());
            }

            @Override
            public void onFailure(Call<BaseResponse<RspWeather>> call, Throwable t) {
                ZLogUtil.i(TAG+t.getMessage());

            }
        });
    }
}
