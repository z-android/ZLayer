package prin.com.retrofit.model.client;

import prin.com.retrofit.net.ZBaseClient;
import prin.com.retrofit.net.ZNetResponse;
import prin.com.retrofit.model.service.OneBoxService;
import retrofit2.Call;

/**
 * Created by prin on 2016/8/25.
 */
public abstract class ServiceOneBoxClient<T> extends ZBaseClient {

    protected OneBoxService mService;

    public ServiceOneBoxClient(ZNetResponse netResponse) {
        super(netResponse, OneBoxService.class, OneBoxService.BASE_URL);
        mService = (OneBoxService) mApiService;
    }

    @Override
    public Call onRequest() {
        mService= (OneBoxService) mApiService;
        return null;
    }
}
