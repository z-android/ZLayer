package com.prin.zlayer;

import android.os.Bundle;

import com.prin.zlayer.demo.presenter.MainJuBaoPresenter;
import com.prin.zlayer.demo.presenter.MainOneBoxPresenter;
import com.prin.zlayer.demo.presenter.MainPresenter;
import com.prin.zlayer.demo.viewer.IMainView;
import com.prin.zlayer.demo.viewer.activity.BaseActivity;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<IMainView, MainPresenter> implements IMainView {

    private MainOneBoxPresenter mOneBoxPresenter;
    private MainJuBaoPresenter mJuBaoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mOneBoxPresenter = new MainOneBoxPresenter();
        mJuBaoPresenter = new MainJuBaoPresenter();
        extendPresenter(mOneBoxPresenter, mJuBaoPresenter);
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public IMainView createViewer() {
        return this;
    }


}
