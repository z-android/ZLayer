package prin.com.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import prin.com.retrofit.presenter.OneBoxPresenter;

public class MainActivity extends Activity {

    @Bind(R.id.tv_content)
    TextView mTvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        OneBoxPresenter presenter = new OneBoxPresenter();
        presenter.queryBoxMsg();

        presenter.queryAb();
    }

}
