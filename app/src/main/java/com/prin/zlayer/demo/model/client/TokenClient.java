package com.prin.zlayer.demo.model.client;

import prin.com.zlayer.net.ZNetResponse;
import retrofit2.Call;

/**
 * Created by prin on 2016/8/26.
 */
public class TokenClient extends ServiceOneBoxClient {

    public static boolean token_dead;

    public TokenClient(ZNetResponse netResponse) {
        super(netResponse);
    }

    @Override
    public Call onRequest() {
        return null;
    }
}
