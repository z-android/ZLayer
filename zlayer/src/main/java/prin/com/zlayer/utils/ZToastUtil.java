package prin.com.zlayer.utils;


import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/6/11.
 * Toast工具
 * (1)优化多次提示问题
 */

public class ZToastUtil {

    private static Context sContext;
    private static Toast sToast;

    public static void init(Context context) {
        sContext = context.getApplicationContext();
    }

    public static void show(CharSequence text, int duration) {
        if (sContext != null) {
            if (sToast == null) {
                sToast = Toast.makeText(sContext, text, duration);
            } else {
                sToast.setText(text);
            }
            sToast.show();
        }
    }

    public static void show(CharSequence text, int duration, int gravity) {
        if (sContext != null) {
            if (sToast == null) {
                sToast = Toast.makeText(sContext, text, duration);
                sToast.setGravity(gravity, 0, 0);
            } else {
                sToast.setText(text);
            }
            sToast.show();

        }
    }


    public static void show(int resId) {
        show(sContext.getResources().getText(resId), Toast.LENGTH_SHORT);
    }

    /**
     * @param resId
     * @param duration
     */
    public static void show(int resId, int duration) {
        show(sContext.getResources().getText(resId), duration);
    }

    /**
     * @param format
     * @param args
     */
    public static void show(String format, Object... args) {
        show(String.format(format, args), Toast.LENGTH_SHORT);
    }

    /**
     * @param duration
     * @param format
     * @param args
     */
    public static void show(int duration, String format, Object... args) {
        show(String.format(format, args), duration);
    }
}
