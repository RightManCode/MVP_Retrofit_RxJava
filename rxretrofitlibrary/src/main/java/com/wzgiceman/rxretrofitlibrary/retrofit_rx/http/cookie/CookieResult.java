package com.wzgiceman.rxretrofitlibrary.retrofit_rx.http.cookie;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * post請求緩存数据

 */
@Entity
public class CookieResult {
    @Id
    private long id;
    /*url*/
    private String url;
    /*返回结果*/
    private String result;
    /*时间*/
    private long time;

    public CookieResult(String url, String result, long time) {
        this.url = url;
        this.result = result;
        this.time = time;
    }


    @Generated(hash = 1914207567)
    public CookieResult(long id, String url, String result, long time) {
        this.id = id;
        this.url = url;
        this.result = result;
        this.time = time;
    }


    @Generated(hash = 43459054)
    public CookieResult() {
    }


    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public long getTime() {
        return this.time;
    }
    public void setTime(long time) {
        this.time = time;
    }


    public String getResult() {
        return this.result;
    }


    public void setResult(String result) {
        this.result = result;
    }
}
