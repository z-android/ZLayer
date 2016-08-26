package prin.com.retrofit.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import java.util.Map;

/**
 * Created by prin on 2016/8/26.
 * 管理cookie和session
 */
public class ZCookieManager {
    private static final String SET_COOKIE_KEY = "Set-Cookie";
    public static final String COOKIE_KEY = "Cookie";
    public static final String SESSION_COOKIE = "cookie_";
    private static ZCookieManager sManager;
    private SharedPreferences mPreferences;

    private ZCookieManager() {
    }

    public static ZCookieManager instance() {
        if (sManager == null) {
            synchronized (ZCookieManager.class) {
                if (sManager == null) {
                    sManager = new ZCookieManager();
                }
            }
        }
        return sManager;
    }

    public void init(Context context) {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public final void checkSessionCookie(Map<String, String> headers) {
        if (headers.containsKey("Set-Cookie")) {
            String cookie = (String) headers.get("Set-Cookie");
            if (!TextUtils.isEmpty(cookie)) {
                SharedPreferences.Editor preEditor = mPreferences.edit();
                preEditor.putString("cookie_", cookie);
                preEditor.commit();
            }
        }
    }

    public final void addSessionCookie(Map<String, String> headers) {
        String session = mPreferences.getString("cookie_", "");
        if (!TextUtils.isEmpty(session)) {
            StringBuilder builder = new StringBuilder();
            builder.append(session);
            if (headers.containsKey("Cookie")) {
                builder.append("; ");
                builder.append((String) headers.get("Cookie"));
            }
            headers.put("Cookie", builder.toString());
        }
    }

    public final String getSessionCookie() {
        return this.mPreferences != null?this.mPreferences.getString("cookie_", ""):"";
    }
}
