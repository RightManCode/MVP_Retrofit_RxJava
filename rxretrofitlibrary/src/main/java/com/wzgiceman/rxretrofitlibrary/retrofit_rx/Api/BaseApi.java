package com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api;

import com.alibaba.fastjson.JSONObject;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.HttpTimeException;

import retrofit2.Retrofit;
import rx.Observable;
import rx.functions.Func1;

/**
 * 请求数据统一封装类
 *
 * @param <T> the type parameter
 * @author Lester Huang
 * @created 2017 /02/23 15:21:43
 */
public abstract class BaseApi<T> implements Func1<T, String> {
    /**
     * The Cancel.
     */
    /* 是否能取消加载框 */
    private boolean cancel = false;
    /**
     * The Show progress.
     */
    /* 是否显示加载框 */
    private boolean showProgress = true;
    /**
     * The Cache.
     */
    /* 是否需要缓存处理 */
    private boolean cache = false;
    /**
     * The Base url.
     */
    /* 基础url */
    // private String baseUrl = "http://fjjr.tunnel.qydev.com/fjjrgs/";
    // private String baseUrl = "http://192.168.59.27:8080/fjjrgs/";
    // private String baseUrl = "http://120.35.30.151:8085/fjjrgs/";

    private String baseUrl = "http://gc.ditu.aliyun.com/";

    /**
     * The Mothed.
     */
    //private String baseUrl="http://msi.ngrok.cc/fjjrgs/";
    // private String baseUrl="http://120.35.30.151:8085/fjjrgs/";
    // private String baseUrl="http://www.izaodao.com/Api/";
    /* 方法-如果需要缓存必须设置这个参数；不需要不用設置 */
    private String method;
    /**
     * The Connection time.
     */
    /* 超时时间-默认60秒 */
    private int connectionTime = 60;
    /**
     * The Cookie net work time.
     */
    /* 有网情况下的本地缓存时间默认60秒 */
    private int cookieNetWorkTime = 60;
    /**
     * The Cookie no net work time.
     */
    /* 无网络的情况下本地缓存时间默认30天 */
    private int cookieNoNetWorkTime = 24 * 60 * 60 * 30;

    /**
     * 设置参数
     *
     * @param retrofit the retrofit
     * @return observable
     * @author Lester Huang
     * @created 2017 /02/23 15:21:43
     */
    public abstract Observable getObservable(Retrofit retrofit);

    /**
     * 描述 Gets cookie no net work time.
     *
     * @return the cookie no net work time
     * @author Lester Huang
     * @created 2017 /02/23 15:21:43
     */
    public int getCookieNoNetWorkTime() {
        return cookieNoNetWorkTime;
    }

    /**
     * 描述 Sets cookie no net work time.
     *
     * @param cookieNoNetWorkTime the cookie no net work time
     * @author Lester Huang
     * @created 2017 /02/23 15:21:43
     */
    public void setCookieNoNetWorkTime(int cookieNoNetWorkTime) {
        this.cookieNoNetWorkTime = cookieNoNetWorkTime;
    }

    /**
     * 描述 Gets cookie net work time.
     *
     * @return the cookie net work time
     * @author Lester Huang
     * @created 2017 /02/23 15:21:43
     */
    public int getCookieNetWorkTime() {
        return cookieNetWorkTime;
    }

    /**
     * 描述 Sets cookie net work time.
     *
     * @param cookieNetWorkTime the cookie net work time
     * @author Lester Huang
     * @created 2017 /02/23 15:21:43
     */
    public void setCookieNetWorkTime(int cookieNetWorkTime) {
        this.cookieNetWorkTime = cookieNetWorkTime;
    }

    /**
     * 描述 Gets mothed.
     *
     * @return the mothed
     * @author Lester Huang
     * @created 2017 /02/23 15:21:43
     */
    public String getMethod() {
        return method;
    }

    /**
     * 描述 Gets connection time.
     *
     * @return the connection time
     * @author Lester Huang
     * @created 2017 /02/23 15:21:43
     */
    public int getConnectionTime() {
        return connectionTime;
    }

    /**
     * 描述 Sets connection time.
     *
     * @param connectionTime the connection time
     * @author Lester Huang
     * @created 2017 /02/23 15:21:43
     */
    public void setConnectionTime(int connectionTime) {
        this.connectionTime = connectionTime;
    }

    /**
     * 描述 Sets mothed.
     *
     * @param method the method
     * @author Lester Huang
     * @created 2017 /02/23 15:21:43
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 描述 Gets base url.
     *
     * @return the base url
     * @author Lester Huang
     * @created 2017 /02/23 15:21:43
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * 描述 Sets base url.
     *
     * @param baseUrl the base url
     * @author Lester Huang
     * @created 2017 /02/23 15:21:43
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * 描述 Gets url.
     *
     * @return the url
     * @author Lester Huang
     * @created 2017 /02/23 15:21:44
     */
    public String getUrl() {
        return baseUrl + (method == null ? "" : method);
    }

    /**
     * 描述 create.
     *
     * @return the boolean
     * @author Lester Huang
     * @created 2017 /02/23 15:21:44 Is cache boolean.
     */
    public boolean isCache() {
        return cache;
    }

    /**
     * 描述 Sets cache.
     *
     * @param cache the cache
     * @author Lester Huang
     * @created 2017 /02/23 15:21:44
     */
    public void setCache(boolean cache) {
        this.cache = cache;
    }

    /**
     * 描述 create.
     *
     * @return the boolean
     * @author Lester Huang
     * @created 2017 /02/23 15:21:44 Is show progress boolean.
     */
    public boolean isShowProgress() {
        return showProgress;
    }

    /**
     * 描述 Sets show progress.
     *
     * @param showProgress the show progress
     * @author Lester Huang
     * @created 2017 /02/23 15:21:44
     */
    public void setShowProgress(boolean showProgress) {
        this.showProgress = showProgress;
    }

    /**
     * 描述 create.
     *
     * @return the boolean
     * @author Lester Huang
     * @created 2017 /02/23 15:21:44 Is cancel boolean.
     */
    public boolean isCancel() {
        return cancel;
    }

    /**
     * 描述 Sets cancel.
     *
     * @param cancel the cancel
     * @author Lester Huang
     * @created 2017 /02/23 15:21:44
     */
    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * 描述 create.
     *
     * @param httpResult the http result
     * @return the string
     * @author Lester Huang
     * @created 2017 /02/23 15:21:44 Call string.
     */
    @Override
    public String call(T httpResult) {
        MyBaseResultEntity baseResult = JSONObject.parseObject(httpResult.toString(), MyBaseResultEntity.class);
//        if (baseResulte.getRet() != 1) {
//            throw new HttpTimeException(baseResulte.getMsg());
//        }
        return baseResult.getQueryLocation().toString();
    }
}
