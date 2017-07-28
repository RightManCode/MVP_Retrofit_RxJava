package com.example.admin.mvp_retrofit_rxjava.api;

import com.example.admin.mvp_retrofit_rxjava.service.LoginService;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by admin on 2017/7/25.
 */

public class LoginPostApi extends BaseApi {

    @Override
    public Observable getObservable(Retrofit retrofit) {
        LoginService loginService = retrofit.create(LoginService.class);
        return loginService.getData("001");
    }
}
