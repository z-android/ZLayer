package com.prin.zlayer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.prin.zlayer.demo.presenter.LoginPresenter;
import com.prin.zlayer.demo.viewer.IMainView;
import com.prin.zlayer.lib.viewer.ZLayerActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends ZLayerActivity<IMainView, LoginPresenter> implements IMainView {

    @Bind(R.id.textView)
    TextView mTextView;
    @Bind(R.id.button)
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public IMainView createViewer() {
        return this;
    }

    @OnClick({R.id.textView, R.id.button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView:
                break;
            case R.id.button:
                mPresenter.getWeather();
                break;
        }
    }
}
