package prin.com.retrofit.config;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by prin on 2016/8/24.
 * retrofit网络接口类
 * （1）retrofit背后的httpclient和序列化机制（json，xml协议都是可替换的）
 */
public class ZRetrofitManager {
    private NetConfig mNetConfig;

    public ZRetrofitManager(NetConfig netConfig) {
        mNetConfig = netConfig;
    }

    /**
     * 获得client
     */
    protected OkHttpClient getClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(8, TimeUnit.SECONDS);
        builder.writeTimeout(8, TimeUnit.SECONDS);
        builder.connectTimeout(8, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(false);    //超时重试
        return builder.build();
    }

    /**
     * 获得retrofit
     */
    public Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mNetConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();

        return retrofit;
    }


}
