package com.wzgiceman.rxretrofitlibrary.retrofit_rx.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.wzgiceman.rxretrofitlibrary.retrofit_rx.RxRetrofitApp;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.HttpDownManager;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean.DaoMaster;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean.DaoSession;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.http.cookie.CookieResult;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.http.cookie.CookieResultDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;


/**
 * 数据缓存 数据库工具类-geendao运用 Created by WZG on 2016/10/25.
 *
 * @author Lester Huang
 * @created 2017 /02/23 15:44:29
 */
public class CookieDbUtil {
    /**
     * The constant db.
     */
    private static CookieDbUtil db;
    /**
     * The constant dbName.
     */
    private final static String dbName = "fjjr_db";
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
    private CookieDbUtil() {
        context = RxRetrofitApp.getApplication();
        openHelper = new DaoMaster.DevOpenHelper(context, dbName);
    }

    /**
     * 获取单例
     *
     * @return instance
     * @author Lester Huang
     * @created 2017 /02/23 15:44:29
     */
    public static CookieDbUtil getInstance() {
        if (db == null) {
            synchronized (HttpDownManager.class) {
                if (db == null) {
                    db = new CookieDbUtil();
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
     * @created 2017 /02/23 15:44:29
     */
    private SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }

    /**
     * 获取可写数据库
     *
     * @return the writable database
     * @author Lester Huang
     * @created 2017 /02/23 15:44:29
     */
    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }


    /**
     * 描述 create.
     *
     * @param info the info
     * @author Lester Huang
     * @created 2017 /02/23 15:44:29 Save cookie.
     */
    public void saveCookie(CookieResult info) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        CookieResultDao downInfoDao = daoSession.getCookieResultDao();
        downInfoDao.insert(info);
    }

    /**
     * 描述 create.
     *
     * @param info the info
     * @author Lester Huang
     * @created 2017 /02/23 15:44:29 Update cookie.
     */
    public void updateCookie(CookieResult info) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        CookieResultDao downInfoDao = daoSession.getCookieResultDao();
        downInfoDao.update(info);
    }

    /**
     * 描述 create.
     *
     * @param info the info
     * @author Lester Huang
     * @created 2017 /02/23 15:44:29 Delete cookie.
     */
    public void deleteCookie(CookieResult info) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        CookieResultDao downInfoDao = daoSession.getCookieResultDao();
        downInfoDao.delete(info);
    }


    /**
     * 描述 create.
     *
     * @param url the url
     * @return the cookie resulte
     * @author Lester Huang
     * @created 2017 /02/23 15:44:29 Query cookie by cookie resulte.
     */
    public CookieResult queryCookieBy(String url) {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        CookieResultDao downInfoDao = daoSession.getCookieResultDao();
        QueryBuilder<CookieResult> qb = downInfoDao.queryBuilder();
        qb.where(CookieResultDao.Properties.Url.eq(url));
        List<CookieResult> list = qb.list();
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    /**
     * 描述 create.
     *
     * @return the list
     * @author Lester Huang
     * @created 2017 /02/23 15:44:29 Query cookie all list.
     */
    public List<CookieResult> queryCookieAll() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        CookieResultDao downInfoDao = daoSession.getCookieResultDao();
        QueryBuilder<CookieResult> qb = downInfoDao.queryBuilder();
        return qb.list();
    }
}
