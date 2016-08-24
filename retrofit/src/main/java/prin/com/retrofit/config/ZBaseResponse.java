package prin.com.retrofit.config;

/**
 * Created by prin on 2016/8/24.
 */
public interface ZBaseResponse<T> {
    void onSuccess(T response);
    void onError(int errCode,String errMsg);
}
