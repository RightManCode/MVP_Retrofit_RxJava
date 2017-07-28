/*
 * Copyright (c) 2005, 2017, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/** 实现下载功能需要的信息
 * Created by thinkpad on 2017/4/10.
 */
@Entity
public class ThreadInfo {
    @Id
    private Long id;
    private int threadId;
    private String url;
    private int start;
    private int end;
    private int finished;
    @Generated(hash = 1906983711)
    public ThreadInfo(Long id, int threadId, String url, int start, int end,
            int finished) {
        this.id = id;
        this.threadId = threadId;
        this.url = url;
        this.start = start;
        this.end = end;
        this.finished = finished;
    }
    @Generated(hash = 930225280)
    public ThreadInfo() {
    }



    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getThreadId() {
        return this.threadId;
    }
    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getStart() {
        return this.start;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public int getEnd() {
        return this.end;
    }
    public void setEnd(int end) {
        this.end = end;
    }
    public int getFinished() {
        return this.finished;
    }
    public void setFinished(int finished) {
        this.finished = finished;
    }



}
