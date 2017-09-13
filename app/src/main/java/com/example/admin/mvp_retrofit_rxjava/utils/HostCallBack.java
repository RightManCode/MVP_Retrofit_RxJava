package com.example.admin.mvp_retrofit_rxjava.utils;

import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.exception.OkGoException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by admin on 2017/9/8.
 */

public abstract class HostCallBack extends AbsCallback<String> {

    @Override
    public String convertSuccess(Response response) throws Exception {
        return null;
    }

    @Override
    public void onError(Call call, Response response, Exception e) {
        super.onError(call, response, e);
    }

    public OkGoException showExceptionMsg(String code) {
        return null;
    }
}
