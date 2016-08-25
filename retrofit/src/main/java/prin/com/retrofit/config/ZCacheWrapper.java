package prin.com.retrofit.config;

import android.content.Context;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import prin.com.retrofit.util.ZDeviceInfoUtil;

/**
 * Created by prin on 2016/8/25.
 */
public class ZCacheWrapper {

    private static ZCacheWrapper mCacheWrapper;
    private static Context mContext;
    public static Cache cache;
    public static ZCacheInterceptor interceptor;


    public static ZCacheWrapper instance(Context context, String fileName) {
        mContext = context.getApplicationContext();
        if (mCacheWrapper == null) {
            synchronized (ZCacheWrapper.class) {
                if (mCacheWrapper == null) {
                    mCacheWrapper = new ZCacheWrapper();
                    buildCache(fileName);
                    buildInterceptor();
                }
            }
        }
        return mCacheWrapper;
    }

    public Cache getCache() {
        return cache;
    }

    public ZCacheInterceptor getInterceptor() {
        return interceptor;
    }

    /**
     * 构建缓存
     *
     * @return
     */
    public static void buildCache(String cacheName) {
        final File baseDir = mContext.getCacheDir();
        final File cacheDir = new File(baseDir, cacheName);
        cache = new Cache(cacheDir, 10 * 1024 * 1024);   //缓存可用大小为10M
    }

    /**
     * 构建缓存中断
     */
    public static void buildInterceptor() {
        interceptor = new ZCacheInterceptor();
    }

    public static class ZCacheInterceptor implements Interceptor {
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
