package com.wzgiceman.rxretrofitlibrary.retrofit_rx.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.wzgiceman.rxretrofitlibrary.retrofit_rx.RxRetrofitApp;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.DownInfo;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.DownInfoDao;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.HttpDownManager;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean.DaoMaster;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean.DaoSession;


import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;




/**
 * 断点续传
 * 数据库工具类-geendao运用
 * Created by WZG on 2016/10/25.
 *
 * @author Lester Huang
 * @created 2017 /02/23 15:44:40
 */
public class DbDwonUtil {
    /**
     * The constant db.
     */
    private static DbDwonUtil db;
    /**
     * The constant dbName.
     */
    private final static String dbName = "fjjr_db1";
    /**
     * The Open helper.
     */
    private DaoMaster.DevOpenHelper openHelper;
    /**
     * The Context.
     */
    private Context context;

    /**
     * 描述 Sets data.
     *

     * @author Lester Huang
     * @created 2017 /02/23 15:01:48
     */
    public DbDwonUtil() {
        context= RxRetrofitApp.getApplication();
        openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
    }


    /**
     * 获取单例
     *
     * @return instance
     * @author Lester Huang
     * @created 2017 /02/23 15:44:40
     */
    public static DbDwonUtil getInstance() {
        if (db == null) {
            synchronized (HttpDownManager.class) {
                if (db == null) {
                    db = new DbDwonUtil();
                }
            }
        }
        return db;
    }


    /**
     * 获取可读数据库
     *
     * @return the readable database
     * @author Lester Huang
     * @created 2017 /02/23 15:44:40
     */
    private SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }

    /**
     * 获取可写数据库
     *
     * @return the writable database
     * @author Lester Huang
     * @created 2017 /02/23 15:44:40
     */
    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }


    /**
     * 描述 create.
     *
     * @param info the info
     * @author Lester Huang
     * @created 2017 /02/23 15:44:40 Save.
     */
    public void save(DownInfo info){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        DownInfoDao downInfoDao = daoSession.getDownInfoDao();
        downInfoDao.insert(info);
    }

    /**
     * 描述 create.
     *
     * @param info the info
     * @author Lester Huang
     * @created 2017 /02/23 15:44:40 Update.
     */
    public void update(DownInfo info){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        DownInfoDao downInfoDao = daoSession.getDownInfoDao();
        downInfoDao.update(info);
    }

    /**
     * 描述 create.
     *
     * @param info the info
     * @author Lester Huang
     * @created 2017 /02/23 15:44:40 Delete downinfo.
     */
    public void deleteDowninfo(DownInfo info){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        DownInfoDao downInfoDao = daoSession.getDownInfoDao();
        downInfoDao.delete(info);
    }


    /**
     * 描述 create.
     *
     * @param Id the id
     * @return the down info
     * @author Lester Huang
     * @created 2017 /02/23 15:44:40 Query down by down info.
     */
    public DownInfo queryDownBy(long Id) {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        DownInfoDao downInfoDao = daoSession.getDownInfoDao();
        QueryBuilder<DownInfo> qb = downInfoDao.queryBuilder();
        qb.where(DownInfoDao.Properties.Id.eq(Id));
        List<DownInfo> list = qb.list();
        if(list.isEmpty()){
            return null;
        }else{
            return list.get(0);
        }
    }

    /**
     * 描述 create.
     *
     * @return the list
     * @author Lester Huang
     * @created 2017 /02/23 15:44:40 Query down all list.
     */
    public List<DownInfo> queryDownAll() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        DownInfoDao downInfoDao = daoSession.getDownInfoDao();
        QueryBuilder<DownInfo> qb = downInfoDao.queryBuilder();
        return qb.list();
    }
}
