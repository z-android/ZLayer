package prin.com.zlayer.mvp;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by prin on 2016/8/22.
 */
public abstract class ZLayerFragment<ViewLayerType extends IZBaseView, PresenterLayerType extends ZLayerPresenter<IZBaseView>> extends Fragment {

    private ViewLayerType mView;
    private PresenterLayerType mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建presenter
        mView = createViewer();
        mPresenter = createPresenter();
    }

    protected abstract PresenterLayerType createPresenter();

    public abstract ViewLayerType createViewer();


}
