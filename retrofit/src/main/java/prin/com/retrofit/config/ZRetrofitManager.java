package prin.com.retrofit.config;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import prin.com.retrofit.model.RequestParams;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by prin on 2016/8/24.
 * retrofit网络接口类
 */
public  class ZRetrofitManager<T, ApiServiceClass> implements IClient {
    protected ZBaseResponse<T> mResponse;
    protected Call<T> mCall;
    public ApiServiceClass mApi;
    protected Class<ApiServiceClass> mClazz;
    protected RequestParams mParams;
    private NetConfig mNetConfig;

    public ZRetrofitManager(ZBaseResponse<T> response, Class<ApiServiceClass> clazz, NetConfig netConfig) {
        mResponse = response;
        mNetConfig = netConfig;
        mClazz = clazz;
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
    protected Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GlobalConfig.URL_BAIDU_API)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();

        return retrofit;
    }

    protected void setCall(Call<T> call) {
        mApi = getRetrofit().create(mClazz);
        mCall = call;
    }

    @Override
    public void start() {
        mCall.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                int code = response.code();
                //确定是否肯定会走到这个方法
                if (code == 200) {
                    mResponse.onSuccess(response.body());
                } else {
                    mResponse.onError(code, response.message());
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                //确定什么时候走到这个方法
            }
        });
    }


    @Override
    public void cancel() {
        if (!mCall.isCanceled()) {
            mCall.cancel();
        }
    }
}
