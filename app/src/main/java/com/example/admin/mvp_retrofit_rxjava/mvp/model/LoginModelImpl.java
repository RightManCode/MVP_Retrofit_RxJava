package com.example.admin.mvp_retrofit_rxjava.mvp.model;

import com.example.admin.mvp_retrofit_rxjava.mvp.contract.LoginContract;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.http.HttpManager;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;

/**
 * Created by admin on 2017/7/25.
 */

public class LoginModelImpl implements LoginContract.LoginModel, HttpOnNextListener {

    LoginContract.LoginPresenter loginPresenter;

    public LoginModelImpl(LoginContract.LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void login(RxAppCompatActivity rxAppCompatActivity, BaseApi baseApi) {
        HttpManager httpManager = new HttpManager(this, rxAppCompatActivity);
        httpManager.doHttpDeal(baseApi);
    }

    @Override
    public void onNext(String result, String method) {
        loginPresenter.onNext(result, method);
    }

    @Override
    public void onError(ApiException e) {
        loginPresenter.onError(e);
    }
}
