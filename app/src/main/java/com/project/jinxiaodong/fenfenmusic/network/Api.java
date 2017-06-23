package com.project.jinxiaodong.fenfenmusic.network;

import com.project.jinxiaodong.fenfenmusic.bean.grankApi;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by xiaodong.jin on 2017/6/22.
 */

public interface Api {

    @GET("api/data/Android/10/1")
    Call<grankApi> getAndroidInfo();
}
