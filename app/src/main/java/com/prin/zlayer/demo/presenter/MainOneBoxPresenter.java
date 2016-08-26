package com.prin.zlayer.demo.presenter;

import com.prin.zlayer.demo.config.GlobalConfig;
import com.prin.zlayer.demo.model.client.BusMsgClient;
import com.prin.zlayer.demo.model.client.QueryAbClient;
import com.prin.zlayer.demo.model.response.RspBusMsg;
import com.prin.zlayer.demo.model.response.RspQueryAb;
import com.prin.zlayer.demo.viewer.IMainView;

import prin.com.zlayer.mvp.ZLayerPresenter;
import prin.com.zlayer.net.ZNetResponse;
import prin.com.zlayer.net.ZRequestParams;
import prin.com.zlayer.utils.ZJsonUtils;
import prin.com.zlayer.utils.ZLogUtil;

/**
 * Created by prin on 2016/8/26.
 */
public class MainOneBoxPresenter extends ZLayerPresenter<IMainView> {

    private static final String TAG = "MainOneBoxPresenter:";

    /**
     * 获取汽车信息
     */
    public void getBoxMsg() {
        ZRequestParams params = new ZRequestParams();
        params.put("station", "南京");
        params.put("key", GlobalConfig.JUHE_ONEBOX_KEY);
        BusMsgClient client = new BusMsgClient(params, new ZNetResponse<RspBusMsg>() {
            @Override
            public void onSuccess(RspBusMsg response) {
                //返回了response数据
                ZLogUtil.i(TAG + ZJsonUtils.instance().objToJson(response));
            }

            @Override
            public void onFailure(int errCode, String errMsg) {
                ZLogUtil.i(TAG + errCode + "==" + errMsg);
            }
        });
        client.start();
    }

    /**
     * 获得车次信息
     */
    public void getAb() {
        ZRequestParams params = new ZRequestParams();
        params.put("from", "南京");
        params.put("to", "上海");
        params.put("key", GlobalConfig.JUHE_ONEBOX_KEY);
        QueryAbClient client = new QueryAbClient(params, new ZNetResponse<RspQueryAb>() {
            @Override
            public void onSuccess(RspQueryAb response) {
                ZLogUtil.i(TAG + ZJsonUtils.instance().objToJson(response));
            }

            @Override
            public void onFailure(int errCode, String errMsg) {
                ZLogUtil.i(TAG + errCode + errMsg);
            }
        });
        client.start();
    }

}
