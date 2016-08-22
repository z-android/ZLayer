package com.prin.zlayer.lib;

import com.prin.zlayer.lib.utils.ZLogUtil;
import com.prin.zlayer.lib.utils.ZToastUtil;

/**
 * Created by prin on 2016/8/22.
 * 统一管理
 * （1）初始化
 * (2)设置调试
 */
public class ZLayer {

    private static boolean sDebug;
    private static ZLayerApplication sApplication;

    private ZLayer() {

    }

    public static void init(ZLayerApplication application) {
        if (sApplication == null) {
            sApplication = application;
        }
        ZToastUtil.init(application);

    }

    public static void setDebug(boolean debug) {
        sDebug = debug;
        if (sDebug) {
            ZLogUtil.openAll();
        } else {
            ZLogUtil.closeAll();
        }
    }

    public static boolean isDebug() {
        return sDebug;
    }


}
