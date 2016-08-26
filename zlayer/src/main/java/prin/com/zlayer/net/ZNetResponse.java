package prin.com.zlayer.net;

/**
 * Created by prin on 2016/8/25.
 */
public interface ZNetResponse<T> {

    void onSuccess(T response);

    void onFailure(int errCode, String errMsg);

}
