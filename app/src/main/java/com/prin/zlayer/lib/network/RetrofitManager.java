package com.prin.zlayer.lib.network;

import com.prin.zlayer.lib.net.ZApiService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by prin on 2016/8/23.
 * retrofit调用网络的请求工具
 */
public class RetrofitManager implements INetManager {
    private static OkHttpClient sClient;
    private static Retrofit.Builder sBuilder;
    private static RetrofitManager mRetrofitManager;
    private static ZClientConfig mClientConfig;

    private RetrofitManager() {

    }

    public static RetrofitManager instance(ZClientConfig clientConfig) {
        mClientConfig = clientConfig;
        if (mRetrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (mRetrofitManager == null) {
                    mRetrofitManager = new RetrofitManager();
                }
            }
        }
        return mRetrofitManager;
    }


    private static OkHttpClient getClient() {
        if (sClient == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.readTimeout(mClientConfig.getTime_out(), TimeUnit.SECONDS);
            builder.writeTimeout(mClientConfig.getTime_out(), TimeUnit.SECONDS);
            builder.connectTimeout(mClientConfig.getTime_out(), TimeUnit.SECONDS);
            builder.retryOnConnectionFailure(mClientConfig.isRetry());    //取消超时重试
            builder.addInterceptor(loggingInterceptor);
            sClient = builder.build();
        }
        return sClient;
    }

    protected static Retrofit.Builder getBuilder() {
        if (sBuilder == null) {
            sBuilder = new Retrofit.Builder().client(getClient())
                    .addConverterFactory(GsonConverterFactory.create(mClientConfig.getGson()))
                    .baseUrl(mClientConfig.BASE_URL);
        }
        return sBuilder;
    }

    @Override
    public void start() {
        ZApiService call = getBuilder().build().create(ZApiService.class);

    }



    @Override
    public void cancel() {

    }
}
