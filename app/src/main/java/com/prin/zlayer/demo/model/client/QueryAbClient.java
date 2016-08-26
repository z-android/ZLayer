package com.prin.zlayer.demo.model.client;

import prin.com.zlayer.net.ZNetResponse;
import prin.com.zlayer.net.ZRequestParams;
import retrofit2.Call;

/**
 * Created by prin on 2016/8/26.
 */
public class QueryAbClient extends ServiceOneBoxClient {

    private ZRequestParams mParams;

    public QueryAbClient(ZRequestParams params, ZNetResponse netResponse) {
        super(netResponse);
        mParams = params;
    }

    @Override
    public Call onRequest() {
        return mService.getAb(mParams.mUrlParams);
    }
}
