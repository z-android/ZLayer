package prin.com.retrofit.model.service;

import java.util.concurrent.ConcurrentHashMap;

import prin.com.retrofit.model.RspOneBox;
import prin.com.retrofit.model.RspQueryAb;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by prin on 2016/8/25.
 * 汽车站信息查询
 */
public interface OneBoxService {
    String BASE_URL = "http://op.juhe.cn/";

    @GET("onebox/bus/query")
    Call<BaseRsp<RspOneBox>> queryOneBox(@QueryMap ConcurrentHashMap<String, Object> map);

    @GET("onebox/bus/query_ab")
    Call<BaseRsp<RspQueryAb>> queryAb(@QueryMap ConcurrentHashMap<String, Object> map);

}
