package prin.com.zlayer.net;

import android.content.Context;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import prin.com.zlayer.utils.ZDeviceInfoUtil;

/**
 * Created by prin on 2016/8/25.
 */
public class CacheInterceptor {


    /**
     * 构建缓存
     *
     * @return
     */
    public static Cache buildCache(Context context, String cacheName) {
        final File baseDir = context.getCacheDir();
        final File cacheDir = new File(baseDir, cacheName);
        return new Cache(cacheDir, 10 * 1024 * 1024);   //缓存可用大小为10M
    }

    /**
     * 构建缓存中断
     */
    public static ZCacheInterceptor buildInterceptor(Context context) {
        return new ZCacheInterceptor(context);
    }

    public static class ZCacheInterceptor implements Interceptor {

        private Context mContext;

        public ZCacheInterceptor(Context context) {
            mContext = context;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!ZDeviceInfoUtil.isNetworkAvailable(mContext)) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }

            Response originalResponse = chain.proceed(request);
            if (ZDeviceInfoUtil.isNetworkAvailable(mContext)) {
                int maxAge = 60;                  //在线缓存一分钟
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();

            } else {
                int maxStale = 60 * 60 * 24 * 4 * 7;     //离线缓存4周
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        }
    }


}
