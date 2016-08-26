package prin.com.zlayer;

import android.content.Context;

import prin.com.zlayer.net.ZRetrofitManager;
import prin.com.zlayer.utils.ZToastUtil;

/**
 * Created by prin on 2016/8/26.
 * Zlayer初始化
 */
public class ZLayer {

    private static Context sContext;

    public static void init(Context context) {
        sContext = context;
        ZToastUtil.init(context);
        ZRetrofitManager.init(context);
    }
}
