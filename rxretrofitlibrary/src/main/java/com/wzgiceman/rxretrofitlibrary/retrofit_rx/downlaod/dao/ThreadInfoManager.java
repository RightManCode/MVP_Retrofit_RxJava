/*
 * Copyright (c) 2005, 2017, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.dao;

import android.database.sqlite.SQLiteDatabase;


import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean.DaoMaster;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean.DaoSession;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean.ThreadInfo;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean.ThreadInfoDao;


import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;


/**
 * 处理版本表的增删改查操作
 * Created by thinkpad on 2017/4/10.
 */
public class ThreadInfoManager {

    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private ThreadInfoDao mThreadInfoDao;

    public static ThreadInfoManager instance;

    public ThreadInfoManager() {
        db = DbHelper.getInstance().getDb();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
        mThreadInfoDao = mDaoSession.getThreadInfoDao();

    }

    public static ThreadInfoManager getInstance() {
        if (instance == null) {
            instance = new ThreadInfoManager();
        }
        return instance;
    }

    /**
     * 插入
     *
     * @param info
     */
    public void insert(ThreadInfo info) {

        mThreadInfoDao.insert(info);
    }

    /**
     * 描述 create.
     *
     * @param info the info
     * @author Lester Huang
     * @created 2017 /02/23 15:44:40 Update.
     */
    public void update(ThreadInfo info) {

        mThreadInfoDao.update(info);
    }

    /**
     * 描述 create.
     *
     * @param info the info
     * @author Lester Huang
     * @created 2017 /02/23 15:44:40 Delete downinfo.
     */
    public void delete(ThreadInfo info) {
        mThreadInfoDao.delete(info);
    }

    public List<ThreadInfo> query() {
        List<ThreadInfo> versions = mThreadInfoDao.loadAll();
        return versions;
    }

    /**
     * 删除所有匹配url的记录
     *
     * @param url
     */
    public void deleteThread(String url) {
        List<ThreadInfo> list = mThreadInfoDao.queryBuilder().where(ThreadInfoDao.Properties.Url.eq(url)).build().list();
        if (list != null) {
            mThreadInfoDao.deleteInTx(list);
        }
    }

    /**
     * 获取所有匹配url的数据
     *
     * @param url
     * @return
     */
    public List<ThreadInfo> getThread(String url) {
        return mThreadInfoDao.queryBuilder()
                .where(ThreadInfoDao.Properties.Url.eq(url))
                .list();
    }

    /**
     * 更新 与url和id匹配的记录
     *
     * @param url
     * @param id
     * @param finished
     */
    public void updateThread(String url, int id, int finished) {
        QueryBuilder<ThreadInfo> qb = mThreadInfoDao.queryBuilder();
        qb.where(qb.and(ThreadInfoDao.Properties.Url.eq(url), ThreadInfoDao.Properties.ThreadId.eq(id)));
        List<ThreadInfo> list = qb.list();
        if (list == null){
            return;
        }
        for(int i=0; i<list.size(); i++){
            list.get(i).setFinished(finished);
        }
        mThreadInfoDao.updateInTx(list);

    }
}
