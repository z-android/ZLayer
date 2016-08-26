package prin.com.retrofit.model.client;

import prin.com.retrofit.net.ZNetResponse;
import prin.com.retrofit.model.RequestParams;
import prin.com.retrofit.model.RspQueryAb;
import retrofit2.Call;

/**
 * Created by prin on 2016/8/25.
 */
public class QueryAbClient extends ServiceOneBoxClient<RspQueryAb> {

    private RequestParams mParams;

    public QueryAbClient(RequestParams params, ZNetResponse netResponse) {
        super(netResponse);
        mParams = params;
    }

    @Override
    public Call onRequest() {
        super.onRequest();
        return mService.queryAb(mParams.mUrlParams);
    }


}
