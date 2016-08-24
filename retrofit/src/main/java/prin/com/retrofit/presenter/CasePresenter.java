package prin.com.retrofit.presenter;

import prin.com.retrofit.config.ZBaseResponse;
import prin.com.retrofit.model.RequestParams;
import prin.com.retrofit.model.RspFamous;
import prin.com.retrofit.model.client.TestClient;
import prin.com.retrofit.util.ZJsonUtils;
import prin.com.retrofit.util.ZLogUtil;

/**
 * Created by prin on 2016/8/24.
 */
public class CasePresenter {

    private static final String TAG = "CasePresenter:";

    public void getBaiduApi() {
        RequestParams params = new RequestParams();
        TestClient client = new TestClient(new ZBaseResponse<RspFamous>() {
            @Override
            public void onSuccess(RspFamous response) {
                ZLogUtil.i(TAG + "onSuccess()" + ZJsonUtils.instance().objToJson(response));
            }

            @Override
            public void onError(int errCode, String errMsg) {
                ZLogUtil.i(TAG + "onError()" + errCode + errMsg);
            }
        });
        client.start();
    }
}
