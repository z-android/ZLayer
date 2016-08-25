package prin.com.retrofit.presenter;

import prin.com.retrofit.config.GlobalConfig;
import prin.com.retrofit.config.ZNetResponse;
import prin.com.retrofit.model.RequestParams;
import prin.com.retrofit.model.RspOneBox;
import prin.com.retrofit.model.RspQueryAb;
import prin.com.retrofit.model.client.OneBoxClient;
import prin.com.retrofit.model.client.QueryAbClient;
import prin.com.retrofit.util.ZJsonUtils;
import prin.com.retrofit.util.ZLogUtil;
import prin.com.retrofit.util.ZToastUtil;

/**
 * Created by prin on 2016/8/25.
 */
public class OneBoxPresenter {
    private static final String TAG = "OneBoxPresenter:";

    public void queryBoxMsg() {
        RequestParams params = new RequestParams();
        params.put("station", "南京");
        params.put("key", GlobalConfig.JUHE_ONEBOX_KEY);
        OneBoxClient client = new OneBoxClient(params, new ZNetResponse<RspOneBox>() {

            @Override
            public void onSuccess(RspOneBox response) {
                ZLogUtil.i(TAG + "onSuccess()");
                ZLogUtil.i(TAG + ZJsonUtils.instance().objToJson(response));
            }

            @Override
            public void onFailure(int errCode, String msg) {
                ZLogUtil.i(TAG + "onFailure()");
            }
        });
        client.start();
    }

    public void queryAb() {
        RequestParams params = new RequestParams();
        params.put("from", "南京");
        params.put("to", "上海");
        params.put("key", GlobalConfig.JUHE_ONEBOX_KEY);
        QueryAbClient client = new QueryAbClient(params, new ZNetResponse<RspQueryAb>() {
            @Override
            public void onSuccess(RspQueryAb response) {
                ZLogUtil.i(TAG + ZJsonUtils.instance().objToJson(response));
            }

            @Override
            public void onFailure(int errCode, String msg) {
                ZLogUtil.i(TAG + errCode + "===" + msg);
                if (errCode == -1) {
                    ZToastUtil.show("网络连接失败");
                }
            }
        });
        client.start();
    }


}
