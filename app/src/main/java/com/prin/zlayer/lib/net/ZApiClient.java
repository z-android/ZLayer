package com.prin.zlayer.lib.net;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by prin on 2016/8/22.
 */
public class ZApiClient {

    private static OkHttpClient sClient;
    private static Retrofit.Builder sBuilder;

    private static OkHttpClient getClient() {
        if (sClient == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.readTimeout(8, TimeUnit.SECONDS);
            builder.writeTimeout(8, TimeUnit.SECONDS);
            builder.connectTimeout(8, TimeUnit.SECONDS);
            builder.retryOnConnectionFailure(false);//超时重试
            builder.addInterceptor(loggingInterceptor);
            sClient = builder.build();
        }
        return sClient;
    }

    /**
     * 配置OkHttpClient
     */
    protected static void setOkHttpClientConfig() {

    }

    /**
     * 获取请求实例
     */
    public static Retrofit.Builder getBuilder(String url) {
        if (sBuilder == null) {
            sBuilder = new Retrofit.Builder().client(getClient())
                    .addConverterFactory(GsonConverterFactory.create(new Gson()));
            sBuilder.baseUrl(url);
        }
        return sBuilder;
    }


}
