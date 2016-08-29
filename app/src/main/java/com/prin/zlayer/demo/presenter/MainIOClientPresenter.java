package com.prin.zlayer.demo.presenter;

import com.prin.zlayer.demo.model.client.UploadClient;
import com.prin.zlayer.demo.viewer.IMainView;

import java.io.File;

import prin.com.zlayer.mvp.ZLayerPresenter;
import prin.com.zlayer.net.ZRequestParams;
import prin.com.zlayer.net.io.ZUploadListener;
import prin.com.zlayer.utils.ZLogUtil;

/**
 * Created by prin on 2016/8/27.
 */
public class MainIOClientPresenter extends ZLayerPresenter<IMainView> {

    private static final String TAG = "MainIOClientPresenter:";

    public void upload() {
        File file = new File("filepath");
        ZRequestParams params = new ZRequestParams();
        params.putFile("file", file, "image/jpeg");
        UploadClient client = new UploadClient(params, new ZUploadListener() {
            @Override
            public void onUploadProgress(long byteWritten, long contentLength, boolean done) {
                ZLogUtil.i(TAG + byteWritten + "==" + contentLength + "==" + done);
            }
        });
        client.start();
    }

    public void downLoad() {

    }

}
