package com.prin.zlayer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.prin.zlayer.demo.presenter.MainJuBaoPresenter;
import com.prin.zlayer.demo.presenter.MainOneBoxPresenter;
import com.prin.zlayer.demo.presenter.MainPostPresenter;
import com.prin.zlayer.demo.presenter.MainPresenter;
import com.prin.zlayer.demo.viewer.IMainView;
import com.prin.zlayer.demo.viewer.activity.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<IMainView, MainPresenter> implements IMainView {

    @Bind(R.id.bt_ob_bus_msg)
    Button mBtObBusMsg;
    @Bind(R.id.bt_ob_bus_number)
    Button mBtObBusNumber;
    @Bind(R.id.bt_demo_login)
    Button mBtDemoLogin;
    private MainOneBoxPresenter mOneBoxPresenter;
    private MainJuBaoPresenter mJuBaoPresenter;
    private MainPostPresenter mPostPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mOneBoxPresenter = new MainOneBoxPresenter();
        mJuBaoPresenter = new MainJuBaoPresenter();
        mPostPresenter = new MainPostPresenter();
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


    @OnClick({R.id.bt_ob_bus_msg, R.id.bt_ob_bus_number, R.id.bt_demo_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_ob_bus_msg:
                mOneBoxPresenter.getBoxMsg();
                break;
            case R.id.bt_ob_bus_number:
                mOneBoxPresenter.getAb();
                break;
            case R.id.bt_demo_login:
                mPostPresenter.postLogin();
                break;
        }
    }
}
