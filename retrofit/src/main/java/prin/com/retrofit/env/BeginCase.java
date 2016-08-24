package prin.com.retrofit.env;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import prin.com.retrofit.config.GlobalConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by prin on 2016/8/24.
 * retrofit 入门
 * （1）RestFul架构的Android（java客户端）实现
 * （2）提供json to pojo，pojo（简单java对象） to json
 * （3）网络请求（GET，POST，PUT，DELETE等7种）
 * （4）依赖包导入
 */
public class BeginCase {
    private static final String TAG = "BeginCase:";
    private static BeginCase sBeginCase;

    private BeginCase() {
    }

    public static BeginCase instance() {
        if (sBeginCase == null) {
            synchronized (BeginCase.class) {
                if (sBeginCase == null) {
                    sBeginCase = new BeginCase();
                }
            }
        }
        return sBeginCase;
    }

    protected OkHttpClient getClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(8, TimeUnit.SECONDS);
        builder.writeTimeout(8, TimeUnit.SECONDS);
        builder.connectTimeout(8, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(false);    //超时重试
        return builder.build();
    }

    protected Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GlobalConfig.URL_BAIDU_API)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();

        return retrofit;
    }


    public <T> T createApi(Class<T> clazz) {
        T api = getRetrofit().create(clazz);
        return api;
    }


}
