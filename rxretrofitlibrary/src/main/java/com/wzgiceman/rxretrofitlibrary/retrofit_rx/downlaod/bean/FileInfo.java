/*
 * Copyright (c) 2005, 2017, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by thinkpad on 2017/4/18.
 */
@Entity
public class FileInfo {
    private int id;
    private String url;
    private String fileName;
    private int lenght;
    private int finished;
    /*state状态数据库保存*/
    private int stateInte;
    @Generated(hash = 1788719467)
    public FileInfo(int id, String url, String fileName, int lenght, int finished,
            int stateInte) {
        this.id = id;
        this.url = url;
        this.fileName = fileName;
        this.lenght = lenght;
        this.finished = finished;
        this.stateInte = stateInte;
    }
    @Generated(hash = 1367591352)
    public FileInfo() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getFileName() {
        return this.fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public int getLenght() {
        return this.lenght;
    }
    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
    public int getFinished() {
        return this.finished;
    }
    public void setFinished(int finished) {
        this.finished = finished;
    }
    public int getStateInte() {
        return this.stateInte;
    }
    public void setStateInte(int stateInte) {
        this.stateInte = stateInte;
    }

}
