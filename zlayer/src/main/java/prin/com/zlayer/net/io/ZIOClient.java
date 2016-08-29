package prin.com.zlayer.net.io;

import prin.com.zlayer.net.IClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.protobuf.ProtoConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by prin on 2016/8/27.
 * 文件上传下载
 */
public abstract class ZIOClient<T, ApiServiceClass> implements IClient {

    protected ApiServiceClass mApiService;
    protected Class<ApiServiceClass> mClazz;
    private Call<T> mCall;
    protected String mBaseUrl;
    private ZIOListener mListener;
    private static Retrofit.Builder mBuilder;



    public enum IOType {
        Upload, DownLoad
    }

    public ZIOClient(ZIOListener listener, Class clazz, String baseUrl) {
        mListener = listener;
        mClazz = clazz;
        mBaseUrl = baseUrl;
        mBuilder = getRetrofitBuilder();

    }

    public Retrofit.Builder getRetrofitBuilder() {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(ProtoConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
    }

    /**
     * 创建上传service
     */
    public static <T> T createUploadService(Class<T> clazz, ZUploadListener listener) {
        return mBuilder.client(IOClientHelper.buildUploadClient(listener))
                .build()
                .create(clazz);
    }

    /**
     * 创建下载service
     */
    public static <T> T createDownloadService(Class<T> clazz, ZDownloadListener listener) {
        return mBuilder.client(IOClientHelper.buildDownLoadClient(listener))
                .build()
                .create(clazz);
    }

    @Override
    public void start() {
        if (mListener instanceof  ZDownloadListener) {
            mApiService = createDownloadService(mClazz, (ZDownloadListener) mListener);
        } else if (mListener instanceof  ZUploadListener) {
            mApiService = createUploadService(mClazz, (ZUploadListener) mListener);
        }
        wrapService();
        mCall = onRequest();
        mCall.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {

            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {

            }
        });
    }

    protected abstract void wrapService();

    @Override
    public void cancel() {
        if (mCall != null) {
            mCall.cancel();
        }
    }

    public abstract Call<T> onRequest();


}
