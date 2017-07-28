package com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.upload;

import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.HttpDownService;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpDownOnNextListener;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * apk下载请求数据基础类

 *
 * @author Lester Huang
 * @created 2017 /02/23 15:22:49
 */
@Entity
public class UploadInfo {
    @Id
    private Long id;
    private String fileName;
    private String fileSize;
    /*存储位置*/
    private String savePath;
    /*创建时间*/
    private String dateTime;
    /*文件总长度*/
    private long countLength;
    /*下载长度*/
    private long readLength;
    /*下载唯一的HttpService*/
    @Transient
    private HttpDownService service;
    /*回调监听*/
    @Transient
    private HttpDownOnNextListener listener;
    /*超时设置*/
    private  int connectonTime=60;
    /*state状态数据库保存*/
    private int stateInte;
    /*url*/
    private String url;
    @Generated(hash = 871531246)
    public UploadInfo(Long id, String fileName, String fileSize, String savePath,
            String dateTime, long countLength, long readLength, int connectonTime,
            int stateInte, String url) {
        this.id = id;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.savePath = savePath;
        this.dateTime = dateTime;
        this.countLength = countLength;
        this.readLength = readLength;
        this.connectonTime = connectonTime;
        this.stateInte = stateInte;
        this.url = url;
    }
    @Generated(hash = 837649493)
    public UploadInfo() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFileName() {
        return this.fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFileSize() {
        return this.fileSize;
    }
    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }
    public String getSavePath() {
        return this.savePath;
    }
    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
    public String getDateTime() {
        return this.dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    public long getCountLength() {
        return this.countLength;
    }
    public void setCountLength(long countLength) {
        this.countLength = countLength;
    }
    public long getReadLength() {
        return this.readLength;
    }
    public void setReadLength(long readLength) {
        this.readLength = readLength;
    }
    public int getConnectonTime() {
        return this.connectonTime;
    }
    public void setConnectonTime(int connectonTime) {
        this.connectonTime = connectonTime;
    }
    public int getStateInte() {
        return this.stateInte;
    }
    public void setStateInte(int stateInte) {
        this.stateInte = stateInte;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
