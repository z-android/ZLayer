package prin.com.retrofit.net;

/**
 * Created by prin on 2016/8/24.
 */
public class ZNetConfig {

    public Builder mBuilder;

    public ZNetConfig(Builder builder) {
        mBuilder = builder;
    }

    public static final class Builder {

        public String baseUrl; //请求基地址
        public long timeOut = -1;   //设置超市时间
        public boolean isRetry; //设置是否超时重试
        public boolean isCookieEnable;  //设置是否cookie可用
        public boolean isCache; //是否开启网络缓存

        public Builder() {
            baseUrl = "";
            timeOut = -1;
            isRetry = false;
            isCookieEnable = false;
            isCache = false;
        }

        public Builder setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder setTimeOut(long timeOut) {
            this.timeOut = timeOut;
            return this;
        }

        public Builder setRetry(boolean retry) {
            isRetry = retry;
            return this;
        }

        public Builder setCookieEnable(boolean cookieEnable) {
            isCookieEnable = cookieEnable;
            return this;
        }

        public Builder setCache(boolean cache) {
            isCache = cache;
            return this;
        }

        public ZNetConfig build() {

            return new ZNetConfig(this);
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public long getTimeOut() {
            return timeOut;
        }

        public boolean isRetry() {
            return isRetry;
        }

        public boolean isCookieEnable() {
            return isCookieEnable;
        }

        public boolean isCache() {
            return isCache;
        }


    }


}
