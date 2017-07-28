package com.example.admin.mvp_retrofit_rxjava.mvp.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.admin.mvp_retrofit_rxjava.R;
import com.example.admin.mvp_retrofit_rxjava.api.LoginPostApi;
import com.example.admin.mvp_retrofit_rxjava.mvp.contract.LoginContract;
import com.example.admin.mvp_retrofit_rxjava.mvp.presenter.LoginPresenterImpl;
import com.example.admin.mvp_retrofit_rxjava.utils.MarqueeTextView;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends RxAppCompatActivity implements LoginContract.LoginView {

    LoginContract.LoginPresenter loginPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenterImpl(this);

    }

    @Override
    public void startLoginPost() {
        LoginPostApi loginPostApi = new LoginPostApi();
        loginPresenter.login(this, loginPostApi);
    }

    @Override
    public void onLoginNext(String result, String method) {
        Log.e("cww", "获得的数据为" + result);
    }

    @Override
    public void onLoginError(ApiException e) {
        Log.e("cww", "出错的原因" + e.getMessage());
    }

    public void getData(View view) {
        startLoginPost();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
