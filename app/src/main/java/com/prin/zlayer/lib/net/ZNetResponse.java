package com.prin.zlayer.lib.net;

import android.text.TextUtils;

import com.prin.zlayer.lib.utils.ZJsonParserInterface;
import com.prin.zlayer.lib.utils.ZJsonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by prin on 2016/8/22.
 * 网络响应
 * （1）处理json
 */
public class ZNetResponse {

    private String mResult;
    private ZErrorResult mErrorResult;
    private String mCookie;

    public ZNetResponse(String result, String cookie, ZJsonParserInterface jsonParser) {
        mResult = result;
        mCookie = cookie;
    }

    public ZNetResponse(String result, String cookie) {
        this(result, cookie, null);
    }

    public ZNetResponse(String result) {
        this(result, null, null);
    }

    public ZNetResponse(ZErrorResult errorResult) {
        mErrorResult = errorResult;
    }

    public <T> T getModel(Class<T> clazz) {
        return TextUtils.isEmpty(mResult) ? null : ZJsonUtils.instance().jsonToModel(mResult, clazz);
    }

    public Map<String, Object> getMap() {
        return TextUtils.isEmpty(mResult) ? null : ZJsonUtils.instance().jsonToMap(mResult);
    }

    public JSONObject getJSONObject() {
        if (TextUtils.isEmpty(mResult)) {
            return null;
        } else {
            try {
                return new JSONObject(mResult);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public String getResult() {
        return mResult;
    }

    public String getCookie() {
        return mCookie;
    }

    public ZErrorResult getErrorResult() {
        return mErrorResult != null ? mErrorResult : null;
    }


}
