package com.prin.zlayer.demo.model.client;

import com.prin.zlayer.demo.model.service.OneBoxService;

import prin.com.zlayer.net.ZBaseClient;
import prin.com.zlayer.net.ZNetResponse;

/**
 * Created by prin on 2016/8/26.
 */
public abstract class ServiceOneBoxClient extends ZBaseClient {

    protected OneBoxService mService;

    public ServiceOneBoxClient(ZNetResponse netResponse) {
        super(netResponse, OneBoxService.class, OneBoxService.BASE_URL);
    }

    public void wrapService() {
        mService = (OneBoxService) mApiService;
    }
}
