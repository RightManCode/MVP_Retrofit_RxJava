/*
 * Copyright (c) 2005, 2017, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.dao;

import android.database.sqlite.SQLiteDatabase;

import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean.DaoMaster;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean.DaoSession;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean.TaskInfo;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean.TaskInfoDao;

import java.util.List;


/**
 * 处理版本表的增删改查操作
 * Created by thinkpad on 2017/4/10.
 */
public class TaskInfoManager {

    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private TaskInfoDao mTaskInfoDao;

    public static TaskInfoManager instance;

    public TaskInfoManager() {
        db = DbHelper.getInstance().getDb();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
        mTaskInfoDao = mDaoSession.getTaskInfoDao();

    }

    public static TaskInfoManager getInstance() {
        if (instance == null) {
            instance = new TaskInfoManager();
        }
        return instance;
    }

    /**
     * 插入
     *
     * @param info
     */
    public void insert(TaskInfo info) {

        mTaskInfoDao.insert(info);
    }

    /**
     * 描述 create.
     *
     * @param info the info
     * @author Lester Huang
     * @created 2017 /02/23 15:44:40 Update.
     */
    public void update(TaskInfo info) {

        mTaskInfoDao.update(info);
    }

    /**
     * 描述 create.
     *
     * @param info the info
     * @author Lester Huang
     * @created 2017 /02/23 15:44:40 Delete downinfo.
     */
    public void delete(TaskInfo info) {
        mTaskInfoDao.delete(info);
    }

    public List<TaskInfo> query() {
        List<TaskInfo> versions = mTaskInfoDao.loadAll();
        return versions;
    }

    /*TODO 添加描述 根据id获取任务信息
    * Revision Trail: (Date/Author/Description)
    *                 2017/5/3 Laura Song CREATE
    * @author Laura Song
    */
    public List<TaskInfo> queryById(Long id){
        List<TaskInfo> list = mTaskInfoDao.queryBuilder().where(TaskInfoDao.Properties.Id.eq(id)).list();
        return list;
    }


}
