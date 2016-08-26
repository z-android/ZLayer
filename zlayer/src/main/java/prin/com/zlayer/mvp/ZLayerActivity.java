package prin.com.zlayer.mvp;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by prin on 2016/8/22.
 */
public abstract class ZLayerActivity<ViewLayerType extends IBaseView, PresenterLayer extends ZLayerPresenter<ViewLayerType>> extends Activity implements IBaseView {

    protected PresenterLayer mPresenter;
    protected ViewLayerType mViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建presenter
        mViewer = createViewer();
        mPresenter = createPresenter();
        if (mViewer != null && mPresenter != null) {
            mPresenter.attachView(mViewer);
        }
    }

    public abstract PresenterLayer createPresenter();

    public abstract ViewLayerType createViewer();

}
