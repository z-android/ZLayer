package com.prin.zlayer.demo.model;

import com.prin.zlayer.lib.net.ZApiClient;

import retrofit2.Call;

/**
 * Created by prin on 2016/8/22.
 */
public class ApiClient extends ZApiClient {

    private static ApiClient sApiClient;
    private static final String BASE_URL = "http://www.weather.com.cn/";
    private static ApiService sService;

    private ApiClient() {

    }

    public static ApiClient instance() {
        if (sApiClient == null) {
            synchronized (ApiClient.class) {
                if (sApiClient == null) {
                    sApiClient = new ApiClient();
                }
            }
        }
        sService = ApiClient.getBuilder(BASE_URL).build().create(ApiService.class);
        return sApiClient;
    }

    public Call<BaseResponse<RspWeather>> getWeather(String id) {
        return sService.getWeather(id);
    }

}
