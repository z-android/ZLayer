package com.prin.zlayer.demo.model.service;

import com.prin.zlayer.demo.model.request.LoginRequest;
import com.prin.zlayer.demo.model.response.RspBase;
import com.prin.zlayer.demo.model.response.RspBusMsg;
import com.prin.zlayer.demo.model.response.RspQueryAb;

import java.util.concurrent.ConcurrentHashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by prin on 2016/8/26.
 */
public interface OneBoxService {

    String BASE_URL = "http://op.juhe.cn/";

    @GET("onebox/bus/query")
    Call<RspBase<RspBusMsg>> getBusMsg(@QueryMap ConcurrentHashMap<String, Object> map);

    @GET("onebox/bus/query_ab")
    Call<RspBase<RspQueryAb>> getAb(@QueryMap ConcurrentHashMap<String, Object> map);

    @POST("onebox/login")
    Call postLogin(LoginRequest request);
}
