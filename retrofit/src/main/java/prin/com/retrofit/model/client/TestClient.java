package prin.com.retrofit.model.client;

import prin.com.retrofit.config.ZBaseClient;
import prin.com.retrofit.config.ZBaseResponse;
import prin.com.retrofit.model.RspFamous;
import retrofit2.Call;

/**
 * Created by prin on 2016/8/24.
 */
public class TestClient extends ZBaseClient<RspFamous> {


    public TestClient(ZBaseResponse<RspFamous> response) {
        super(response);
    }

    @Override
    public Call<RspFamous> onRequest() {
        return mManager.mApi.getFamous("skey", "人", 1, 1);
    }

}
