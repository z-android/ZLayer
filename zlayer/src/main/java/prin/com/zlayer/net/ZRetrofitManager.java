package prin.com.zlayer.net;

import android.content.Context;

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
    private ZNetConfig mNetConfig;
    private static Context mContext;

    public ZRetrofitManager(ZNetConfig netConfig) {
        mNetConfig = netConfig;
    }

    public static void init(Context context) {
        mContext = context;
    }


    /**
     * 获得client
     */
    protected OkHttpClient getClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(new HeaderInteraptor());

        //设置是否支持https
        if (mNetConfig.mBuilder.getEnableHttps()) {
            HttpsUtils httpsUtils=new HttpsUtils();
            httpsUtils.init(mContext,mNetConfig.mBuilder.cer_server,mNetConfig.mBuilder.cer_client,mNetConfig.mBuilder.bks_file,mNetConfig.mBuilder.sslType);
            //其他配置
            builder.sslSocketFactory(httpsUtils.getSSLParams().sSLSocketFactory, httpsUtils.getSSLParams().trustManager);
        }

        //设置超时时间
        if (mNetConfig.mBuilder.getTimeOut() != -1) {
            builder.readTimeout(mNetConfig.mBuilder.getTimeOut(), TimeUnit.SECONDS);
            builder.writeTimeout(mNetConfig.mBuilder.getTimeOut(), TimeUnit.SECONDS);
            builder.connectTimeout(mNetConfig.mBuilder.getTimeOut(), TimeUnit.SECONDS);
        }

        //设置超时重试
        if (!mNetConfig.mBuilder.isCookieEnable()) {
            builder.retryOnConnectionFailure(false);
        }

        //设置缓存
        if (mNetConfig.mBuilder.isCache()) {
            builder.addNetworkInterceptor(CacheInterceptor.buildInterceptor(mContext));
            builder.cache(CacheInterceptor.buildCache(mContext, "retrofit_cache"));
        }

        //设置cookie
        if (mNetConfig.mBuilder.isCookieEnable()) {
            builder.addInterceptor(new ReceivedCookiesInterceptor(mContext));
            builder.addInterceptor(new AddCookiesInterceptor(mContext, ""));
        }

        return builder.build();
    }


    /**
     * 获得retrofit
     */
    public Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mNetConfig.mBuilder.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();

        return retrofit;
    }


}
