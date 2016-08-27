package prin.com.zlayer.net.io;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by prin on 2016/8/27.
 * 用于创建OKHttpClient 并对OkhttpClient增加拦截事件
 * 替换requestbody
 */
public class IOClientHelper {

    /**
     * 包装OKHttpClient，用于下载文件的回调
     */
    public static OkHttpClient buildDownLoadClient(final ZDownloadListener listener) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //增加拦截器
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //拦截
                Response response = chain.proceed(chain.request());
                //包装响应体并返回
                return response.newBuilder().body(new ZDownloadBody(response.body(), listener)).build();
            }
        });
        return builder.build();
    }

    /**
     * 包装OKHttpClient 用于上传文件的回调
     */
    public static OkHttpClient buildUploadClient(final ZUploadListener listener) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest=chain.request();
                Request request=originalRequest.newBuilder().method(originalRequest.method(),new ZUploadBody(originalRequest.body(),listener)).build();

                return chain.proceed(request);
            }
        });
        return builder.build();
    }
}
