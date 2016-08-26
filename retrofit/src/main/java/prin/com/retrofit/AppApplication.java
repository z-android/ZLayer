package prin.com.retrofit;

import android.app.Application;

import prin.com.retrofit.net.ZRetrofitManager;

/**
 * Created by prin on 2016/8/25.
 */
public class AppApplication extends Application {

    private static AppApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        ZRetrofitManager.init(this);
    }

    public static AppApplication instance() {
        return mApplication;
    }
}
