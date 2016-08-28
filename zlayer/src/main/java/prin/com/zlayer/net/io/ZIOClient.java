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
    private IOType mType;
    private ZIOListener mListener;
    private static Retrofit.Builder mBuilder;

    public enum IOType {
        Upload, DownLoad
    }

    public ZIOClient(IOType type, ZIOListener listener, String baseUrl) {
        mType = type;
        mListener = listener;
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
        if (mType == IOType.DownLoad) {
            mApiService = createDownloadService(mClazz, (ZDownloadListener) mListener);
        } else if (mType == IOType.Upload) {
            mApiService = createUploadService(mClazz, (ZUploadListener) mListener);
        }
        mCall = onRequest();
        mCall.enqueue(new ZDownloadListener() {
            @Override
            public void onDownloadProgress(long byteRead, long contentLength, boolean done) {

            }
        });
    }

    @Override
    public void cancel() {
        if (mCall != null) {
            mCall.cancel();
        }
    }

    public abstract Call<T> onRequest();


}
