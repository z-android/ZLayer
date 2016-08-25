package prin.com.retrofit.config;

/**
 * Created by prin on 2016/8/24.
 */
public class NetConfig {

    public String BASE_URL; //请求基地址
    public long TIME_OUT;   //设置超市时间
    public boolean isRetry; //设置是否超时重试

    public String getBASE_URL() {
        return BASE_URL;
    }

    public void setBASE_URL(String BASE_URL) {
        this.BASE_URL = BASE_URL;
    }

    public long getTIME_OUT() {
        return TIME_OUT;
    }

    public void setTIME_OUT(long TIME_OUT) {
        this.TIME_OUT = TIME_OUT;
    }

    public boolean isRetry() {
        return isRetry;
    }

    public void setRetry(boolean retry) {
        isRetry = retry;
    }
}
