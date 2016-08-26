package prin.com.zlayer.net;

/**
 * Created by prin on 2016/8/25.
 */
public interface ZNetResponse<T> {

    public void onSuccess(T response);

    public void onFailure(int errCode, String errMsg);

}
