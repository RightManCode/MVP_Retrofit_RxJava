/*
 * Copyright (c) 2005, 2017, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.dao;

import android.database.sqlite.SQLiteDatabase;

import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean.DaoMaster;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean.DaoSession;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.upload.UploadInfo;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.upload.UploadInfoDao;

import java.util.List;


/**
 * 处理版本表的增删改查操作
 * Created by thinkpad on 2017/4/10.
 */
public class UploadInfoManager {

    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private UploadInfoDao mUploadInfoDao;

    public static UploadInfoManager instance;

    public UploadInfoManager() {
        db = DbHelper.getInstance().getDb();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
        mUploadInfoDao = mDaoSession.getUploadInfoDao();

    }

    public static UploadInfoManager getInstance() {
        if (instance == null) {
            instance = new UploadInfoManager();
        }
        return instance;
    }

    /**
     * 插入
     *
     * @param info
     */
    public void insert(UploadInfo info) {

        mUploadInfoDao.insert(info);
    }

    /**
     * 描述 create.
     *
     * @param info the info
     * @author Lester Huang
     * @created 2017 /02/23 15:44:40 Update.
     */
    public void update(UploadInfo info) {

        mUploadInfoDao.update(info);
    }

    /**
     * 描述 create.
     *
     * @param info the info
     * @author Lester Huang
     * @created 2017 /02/23 15:44:40 Delete downinfo.
     */
    public void delete(UploadInfo info) {
        mUploadInfoDao.delete(info);
    }

    public List<UploadInfo> query() {
        List<UploadInfo> versions = mUploadInfoDao.loadAll();
        return versions;
    }



}
