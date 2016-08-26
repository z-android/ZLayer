package prin.com.retrofit.model.client;

import prin.com.retrofit.model.RequestParams;
import prin.com.retrofit.model.RspOneBox;
import prin.com.retrofit.net.ZNetResponse;
import retrofit2.Call;

/**
 * Created by prin on 2016/8/25.
 */
public class OneBoxClient extends ServiceOneBoxClient<RspOneBox> {

    private RequestParams mParams;

    public OneBoxClient(RequestParams params, ZNetResponse<RspOneBox> response) {
        super(response);
        mParams = params;
    }

    @Override
    public Call onRequest() {
        return mService.queryOneBox(mParams.mUrlParams);
    }
}
