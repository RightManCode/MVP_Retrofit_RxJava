/*
 * Copyright (c) 2005, 2017, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean;


import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.DownLoadListener.OnDownload;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.DownState;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/** 下载任务信息
 * Created by thinkpad on 2017/4/10.
 */
@Entity(nameInDb = "tb_task_info")
public class TaskInfo {
    @Id
    private Long id;
    private String url;
    private String filePath;
    private String fileName;
    private int lenght;
    /**
     * 已经下载的长度
     */
    private int finished;
    /*state状态数据库保存*/
    private int stateInte;
    @Transient
    private OnDownload download;
    @Generated(hash = 2015069538)
    public TaskInfo(Long id, String url, String filePath, String fileName, int lenght,
            int finished, int stateInte) {
        this.id = id;
        this.url = url;
        this.filePath = filePath;
        this.fileName = fileName;
        this.lenght = lenght;
        this.finished = finished;
        this.stateInte = stateInte;
    }
    @Generated(hash = 2022720704)
    public TaskInfo() {
    }

    public DownState getState(DownState start) {
        switch (getStateInte()){
            case 0:
                return DownState.START;
            case 1:
                return DownState.DOWN;
            case 2:
                return DownState.PAUSE;
            case 3:
                return DownState.STOP;
            case 4:
                return DownState.ERROR;
            case 5:
            default:
                return DownState.FINISH;
        }
    }

    public void setState(DownState state) {
        setStateInte(state.getState());
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getFilePath() {
        return this.filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
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

    public OnDownload getDownload() {
        return download;
    }

    public void setDownload(OnDownload download) {
        this.download = download;
    }
    public int getStateInte() {
        return this.stateInte;
    }
    public void setStateInte(int stateInte) {
        this.stateInte = stateInte;
    }
    public int getFinished() {
        return this.finished;
    }
    public void setFinished(int finished) {
        this.finished = finished;
    }
}
