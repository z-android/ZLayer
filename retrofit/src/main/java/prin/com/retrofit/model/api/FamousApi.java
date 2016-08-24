package prin.com.retrofit.model.api;

import prin.com.retrofit.config.GlobalConfig;
import prin.com.retrofit.model.RspFamous;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by prin on 2016/8/24.
 * get请求
 *
 */
public interface FamousApi{

    @GET(GlobalConfig.ACTION_BAIDU_API)
    Call<RspFamous> getAllFamous();

    @GET(GlobalConfig.ACTION_BAIDU_API)
    Call<RspFamous> getFamous(@Header("apiKey") String apiKey,
                              @Query("keyword") String keyWord,
                              @Query("page") int page,
                              @Query("rows") int rows);
}
