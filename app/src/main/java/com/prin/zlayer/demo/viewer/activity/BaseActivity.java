package com.prin.zlayer.demo.viewer.activity;

import android.os.Bundle;

import prin.com.zlayer.mvp.IZBaseView;
import prin.com.zlayer.mvp.ZLayerActivity;
import prin.com.zlayer.mvp.ZLayerPresenter;

/**
 * Created by prin on 2016/8/26.
 *
 */
public abstract class BaseActivity<ViewLayerType extends IZBaseView, PresenterLayer extends ZLayerPresenter<ViewLayerType>> extends ZLayerActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
