package com.prin.zlayer.demo;

import android.app.Application;
import android.content.Context;

import prin.com.zlayer.ZLayer;

/**
 * Created by prin on 2016/8/22.
 */
public class BaseApplication extends Application {

    private Context mBaseContext;
    private static BaseApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        mBaseContext = getBaseContext();
        ZLayer.init(mBaseContext);
        ZLayer.setDebug(true);
    }

    public static BaseApplication getApplication() {
        return mApplication;
    }
}
