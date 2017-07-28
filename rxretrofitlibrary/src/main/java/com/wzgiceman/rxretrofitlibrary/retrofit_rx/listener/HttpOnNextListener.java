package com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener;

import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;

/**
 * 成功回调处理
 *
 * @author Lester Huang
 * @created 2017 /02/23 15:43:18
 */
public interface HttpOnNextListener {

    /**
     * 成功后回调方法
     *
     * @param result the result
     * @param method the method
     * @author Lester Huang
     * @created 2017 /02/23 15:43:18 On next.
     */
    void onNext(String result, String method);

    /**
     * 失败
     * 失败或者错误方法
     * 自定义异常处理
     *
     * @param e the e
     * @author Lester Huang
     * @created 2017 /02/23 15:43:18 On error.
     */
    void onError(ApiException e);
}
