package com.prin.zlayer.demo.model.client;

import prin.com.zlayer.net.ZRequestParams;
import prin.com.zlayer.net.io.ZIOListener;
import retrofit2.Call;

/**
 * Created by prin on 2016/8/29.
 */
public class UploadClient extends ServiceDemoIoClient {

    private ZRequestParams mParams;

    public UploadClient(ZRequestParams params,ZIOListener listener) {
        super( listener);
        mParams = params;
    }

    @Override
    public Call onRequest() {
//        return mService.upload(mParams);
    }
}
