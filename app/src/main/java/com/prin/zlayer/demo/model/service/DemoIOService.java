package com.prin.zlayer.demo.model.service;

import com.prin.zlayer.demo.model.response.RspBase;
import com.prin.zlayer.demo.model.response.RspUpload;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by prin on 2016/8/27.
 */
public interface DemoIOService {

    @Multipart
    @POST("upload.php")
    Call<RspBase<RspUpload>> upload(@Part MultipartBody.Part file);

}
