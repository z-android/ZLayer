package com.prin.zlayer.demo.presenter;

import com.prin.zlayer.demo.viewer.IMainView;

import java.io.File;

import prin.com.zlayer.mvp.ZLayerPresenter;
import prin.com.zlayer.net.ZRequestParams;
import prin.com.zlayer.net.io.ZIOClient;

/**
 * Created by prin on 2016/8/27.
 */
public class MainIOClientPresenter extends ZLayerPresenter <IMainView>{

    public void upload() {
        File file=new File("filepath");
        ZRequestParams params=new ZRequestParams();
        params.putFile("file",file,"image/jpeg");
        ZIOClient client=new ZIOClient()
    }
}
