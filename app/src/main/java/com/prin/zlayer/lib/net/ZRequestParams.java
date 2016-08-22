package com.prin.zlayer.lib.net;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by prin on 2016/8/22.
 * 请求参数封装
 */
public class ZRequestParams {

    protected ConcurrentHashMap<String, Object> urlParms = new ConcurrentHashMap<>();

    private String getBoundary() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_".charAt(random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_".length())));
        }
        return sb.toString();
    }

}
