package prin.com.retrofit.net;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by prin on 2016/8/25.
 */
public abstract class ZBaseClient<T, ApiServiceClass> implements IClient {

    protected ApiServiceClass mApiService;
    protected Class<ApiServiceClass> mClazz;
    private ZRetrofitManager mManager;
    private ZNetResponse<T> mNetResponse;
    private Call<T> mCall;
    protected String mBaseUrl;

    public ZBaseClient(ZNetResponse netResponse, Class clazz, String baseUrl) {
        mNetResponse = netResponse;
        mBaseUrl = baseUrl;
        mClazz = clazz;
        mManager = new ZRetrofitManager(buildNetConfig());
    }


    private ZNetConfig buildNetConfig() {
        ZNetConfig netConfig = new ZNetConfig.Builder()
                .setBaseUrl(mBaseUrl)
                .setCookieEnable(true)
                .setCache(true)
                .setTimeOut(8)
                .setRetry(false)
                .build();
        return netConfig;
    }


    @Override
    public void start() {
        mApiService = mManager.getRetrofit().create(mClazz);
        wrapService();
        mCall = onRequest();
        mCall.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                //封装网络状态码的解析
                if (response.isSuccessful()) {
                    mNetResponse.onSuccess(response.body());
                } else if (response.code() == 1) {
                    //请求失败，登录过期
                } else if (response.code() == 2) {
                    //2-请求失败，无权限
//                    toLogin
                } else {
                    mNetResponse.onFailure(response.code(), response.message());
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                //网络问题会走该回调
                mNetResponse.onFailure(-1, t.getMessage());
            }
        });
    }

    protected abstract void wrapService();

    public abstract Call<T> onRequest();

    @Override
    public void cancel() {
        if (mCall != null) {
            mCall.cancel();
        }
    }
}
