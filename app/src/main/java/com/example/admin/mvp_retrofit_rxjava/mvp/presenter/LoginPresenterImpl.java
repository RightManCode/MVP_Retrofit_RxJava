package com.example.admin.mvp_retrofit_rxjava.mvp.presenter;

import com.example.admin.mvp_retrofit_rxjava.mvp.contract.LoginContract;
import com.example.admin.mvp_retrofit_rxjava.mvp.model.LoginModelImpl;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;

/**
 * Created by admin on 2017/7/25.
 */

public class LoginPresenterImpl implements LoginContract.LoginPresenter {
    LoginContract.LoginModel loginModel;
    LoginContract.LoginView loginView;

    public LoginPresenterImpl(LoginContract.LoginView loginView) {
        this.loginModel = new LoginModelImpl(this);
        this.loginView = loginView;
    }

    @Override
    public void login(RxAppCompatActivity rxAppCompatActivity, BaseApi baseApi) {
        loginModel.login(rxAppCompatActivity, baseApi);
    }

    @Override
    public void onNext(String result, String method) {
        loginView.onLoginNext(result, method);
    }

    @Override
    public void onError(ApiException e) {
        loginView.onLoginError(e);
    }
}
