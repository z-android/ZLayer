package com.prin.zlayer.demo.model.service;

import com.prin.zlayer.demo.model.response.RspBase;
import com.prin.zlayer.demo.model.response.RspUpload;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

/**
 * Created by prin on 2016/8/27.
 */
public interface DemoIOService {

    public static final String BASE_URL = "http://demoio.com/";

    @Multipart
    @POST("upload.php")
    Call<RspBase<RspUpload>> upload(@Part MultipartBody.Part file);

    @GET
    Call<ResponseBody> downLoad(@Url String url);

}
