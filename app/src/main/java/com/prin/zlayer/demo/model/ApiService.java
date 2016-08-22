package com.prin.zlayer.demo.model;

import com.prin.zlayer.lib.net.ZApiService;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by prin on 2016/8/22.
 */
public interface ApiService extends ZApiService {

    @GET("adat/sk/{cityId}.html")
    Call<BaseResponse<RspWeather>> getWeather(@Path("cityId") String cityId);
}
