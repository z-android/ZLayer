package prin.com.zlayer.net;

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
        public long timeOut = -1;   //设置超时时间
        public boolean isRetry; //设置是否超时重试
        public boolean isCookieEnable;  //设置是否cookie可用
        public boolean isCache; //是否开启网络缓存
        public boolean enableHttps; //是否支持https
        public String cer_server;
        public String cer_client;
        public String bks_file;
        public int sslType;

        public Builder() {
            baseUrl = "";
            timeOut = -1;
            isRetry = false;
            isCookieEnable = false;
            isCache = false;
            enableHttps = false;
        }

        public Builder setEnableHttps(boolean enable, String cer_server, String cer_client, String bks_file, int sslType) {
            enableHttps = enable;
            this.cer_server = cer_server;
            this.cer_client = cer_client;
            this.bks_file = bks_file;
            this.sslType = sslType;
            return this;
        }

        public boolean getEnableHttps() {
            return enableHttps;
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
