package com.example.admin.mvp_retrofit_rxjava.mvp.contract;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;

/**
 * Created by admin on 2017/7/25.
 */

public class LoginContract {
    public interface LoginView {
        void startLoginPost();

        void onLoginNext(String result, String method);

        void onLoginError(ApiException e);
    }

    public interface LoginModel {
        void login(RxAppCompatActivity rxAppCompatActivity, BaseApi baseApi);
    }

    public interface LoginPresenter {
        void login(RxAppCompatActivity rxAppCompatActivity, BaseApi baseApi);

        void onNext(String result, String method);

        void onError(ApiException e);
    }
}
