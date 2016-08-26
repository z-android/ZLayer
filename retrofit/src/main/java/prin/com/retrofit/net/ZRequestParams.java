package prin.com.retrofit.net;

import java.util.concurrent.ConcurrentHashMap;

import prin.com.retrofit.util.ZJsonUtils;

/**
 * Created by prin on 2016/8/24.
 * 请求参数
 */
public class ZRequestParams {
    public ConcurrentHashMap<String, Object> mUrlParams = new ConcurrentHashMap<>();

    public void put(String key, Object value) {
        if (key != null && value != null) {
            mUrlParams.put(key, value);
        }
    }

    public String getParamsJsonString() {
        return mUrlParams==null?null: ZJsonUtils.instance().objToJson(mUrlParams);
    }
}
