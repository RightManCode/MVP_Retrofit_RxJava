package com.example.admin.mvp_retrofit_rxjava.service;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by admin on 2017/7/25.
 */

public interface LoginService {
    @FormUrlEncoded
    @POST("regeocoding")
    Observable<String> getData(@Field("type") String type);
}
