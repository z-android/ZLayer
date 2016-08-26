package prin.com.zlayer.net;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by prin on 2016/8/26.
 * 在header头中发送cookie发送cookie
 */
public class AddCookiesInterceptor implements Interceptor {
    private Context context;
    private String lang;

    public AddCookiesInterceptor(Context context, String lang) {
        super();
        this.context = context;
        this.lang = lang;

    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        final Request.Builder builder = chain.request().newBuilder();
        SharedPreferences sharedPreferences = context.getSharedPreferences("cookie", Context.MODE_PRIVATE);
        String cookie = sharedPreferences.getString("cookie", "");
        if (cookie.contains("lang=ch")) {
            cookie = cookie.replace("lang=ch", "lang=" + lang);
        }
        if (cookie.contains("lang=en")) {
            cookie = cookie.replace("lang=en", "lang=" + lang);
        }
        //添加cookie
        builder.addHeader("Cookie", cookie);
        return chain.proceed(builder.build());
    }
}
