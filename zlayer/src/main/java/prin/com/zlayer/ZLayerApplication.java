package prin.com.zlayer;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import prin.com.zlayer.utils.ZToastUtil;

/**
 * Created by prin on 2016/8/26.
 *
 */
@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class ZLayerApplication extends Application implements Application.ActivityLifecycleCallbacks {

    private static Context mBaseContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mBaseContext = getBaseContext();
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
