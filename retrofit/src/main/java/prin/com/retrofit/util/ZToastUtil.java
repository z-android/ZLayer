package prin.com.retrofit.util;


import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/6/11.
 * Toast工具
 */

public class ZToastUtil {

    private static Context sContext;

    public static void init(Context context) {
        sContext = context;
    }

    public static void show(Context context, CharSequence text, int duration) {
        if (sContext != null) {
            Toast.makeText(sContext, text, duration).show();
        }
    }

    /**
     * @param context
     * @param text
     */
    public static void show(Context context, CharSequence text, int duration, int gravity) {
        if (sContext != null) {
            Toast toast = Toast.makeText(sContext, text, duration);
            toast.setGravity(gravity, 0, 0);
            toast.show();
        }
    }

    /**
     * @param resId
     */
    public static void show(int resId) {
        show(sContext, sContext.getResources().getText(resId), Toast.LENGTH_SHORT);
    }

    /**
     * @param resId
     * @param duration
     */
    public static void show(int resId, int duration) {
        show(sContext, sContext.getResources().getText(resId), duration);
    }

    /**
     * @param format
     * @param args
     */
    public static void show(String format, Object... args) {
        show(sContext, String.format(format, args), Toast.LENGTH_SHORT);
    }

    /**
     * @param duration
     * @param format
     * @param args
     */
    public static void show(int duration, String format, Object... args) {
        show(sContext, String.format(format, args), duration);
    }


}
