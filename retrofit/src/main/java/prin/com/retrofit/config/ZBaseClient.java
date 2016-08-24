package prin.com.retrofit.config;

import prin.com.retrofit.model.api.FamousApi;
import retrofit2.Call;

/**
 * Created by prin on 2016/8/24.
 */
public abstract class ZBaseClient<T> implements IClient {

    protected ZRetrofitManager<T, FamousApi> mManager;
    private NetConfig mNetConfig;

    public ZBaseClient(ZBaseResponse<T> response) {
        initNetConfig();

        mManager = new ZRetrofitManager<T, FamousApi>(response, FamousApi.class, mNetConfig);

    }

    protected void initNetConfig() {
        mNetConfig = new NetConfig();
    }

    @Override
    public void start() {
        mManager.setCall(onRequest());
        mManager.start();
    }

    public abstract Call<T> onRequest();

    @Override
    public void cancel() {
        mManager.cancel();
    }
}
