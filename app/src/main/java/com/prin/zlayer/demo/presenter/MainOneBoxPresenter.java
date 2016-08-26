package com.prin.zlayer.demo.presenter;

import com.prin.zlayer.demo.config.GlobalConfig;
import com.prin.zlayer.demo.model.client.BusMsgClient;
import com.prin.zlayer.demo.model.response.RspBusMsg;
import com.prin.zlayer.demo.viewer.IMainView;

import prin.com.zlayer.mvp.ZLayerPresenter;
import prin.com.zlayer.net.ZNetResponse;
import prin.com.zlayer.net.ZRequestParams;

/**
 * Created by prin on 2016/8/26.
 */
public class MainOneBoxPresenter extends ZLayerPresenter<IMainView> {

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

            }

            @Override
            public void onFailure(int errCode, String errMsg) {

            }
        });
    }
}
