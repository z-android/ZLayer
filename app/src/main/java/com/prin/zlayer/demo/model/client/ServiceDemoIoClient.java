package com.prin.zlayer.demo.model.client;

import com.prin.zlayer.demo.model.service.DemoIOService;

import prin.com.zlayer.net.io.ZIOClient;
import prin.com.zlayer.net.io.ZIOListener;

/**
 * Created by prin on 2016/8/29.
 */
public abstract class ServiceDemoIoClient extends ZIOClient {

    protected DemoIOService mService;

    public ServiceDemoIoClient(ZIOListener listener) {
        super(listener, DemoIOService.class, DemoIOService.BASE_URL);
    }

    @Override
    protected void wrapService() {
        mService = (DemoIOService) mApiService;
    }
}
