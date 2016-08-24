package com.prin.zlayer.demo.task;

import com.prin.zlayer.demo.model.BaseResponse;
import com.prin.zlayer.demo.model.RspWeather;
import com.prin.zlayer.lib.net.ZNetCallBack;

import retrofit2.Call;

/**
 * Created by prin on 2016/8/23.
 */
public class WeatherTask extends BaseTask {

    private String mId;
    private ZNetCallBack mCallBack;

    public WeatherTask(String id, ZNetCallBack callBack) {
        super(callBack);
        mId = id;
        mCallBack = callBack;
    }

    @Override
    protected  Call<BaseResponse<RspWeather>>  onRequest() {
        return mApiService.getWeather(mId);
    }
}
