package prin.com.zlayer.mvp;

import java.lang.ref.SoftReference;

/**
 * Created by prin on 2016/8/22.
 */
public class ZLayerPresenter<V extends IBaseView> {

    private SoftReference<V> mView;

    /**
     * 将presenter与view绑定
     */
    public void attachView(V view) {
        mView = new SoftReference<V>(view);
    }

    /**
     * 将presenter与view解绑
     */
    public void detachView() {
        if (mView != null) {
            mView.clear();
        }
    }

    /**
     * 获取具体的view对象
     */
    public V getRealView() {
        return mView != null ? mView.get() : null;
    }
}
