package com.prin.zlayer.lib;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

/**
 * Created by prin on 2016/8/22.
 * <p>
 * Api14+以上使用ActivityLifecycleCallbacks集中处理activity的生命周期事件
 */
@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class ZLayerApplication extends Application implements Application.ActivityLifecycleCallbacks {

    private static Context mBaseContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mBaseContext = getBaseContext();
        ZLayer.init(this);
        ZLayer.setDebug(true);  //设置可调试
    }

    public static Context getContext() {
        return mBaseContext;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
