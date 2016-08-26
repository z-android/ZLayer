package prin.com.zlayer.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;

/**
 * Created by prin on 2016/8/22.
 */
public abstract class ZLayerActivity<ViewLayerType extends IZBaseView, PresenterLayer extends ZLayerPresenter<ViewLayerType>> extends Activity implements IZBaseView {

    protected PresenterLayer mPresenter;
    protected ViewLayerType mViewer;
    protected SparseArray<ZLayerPresenter> mPresenterArray;

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

    /**
     * 实现view绑定多个presenter
     */
    public void extendPresenter(ZLayerPresenter... presenterArray) {

        for (ZLayerPresenter presenter : presenterArray) {
            if (mViewer != null && presenter != null) {
                presenter.attachView(mViewer);
            }
        }

    }

}
