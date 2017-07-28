package com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.wzgiceman.rxretrofitlibrary.retrofit_rx.RxRetrofitApp;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.bean.DaoMaster;


/**
 * 断点续传
 * 数据库工具类-geendao运用
 * Created by WZG on 2016/10/25.
 *
 * @author Lester Huang
 * @created 2017 /02/23 15:44:40
 */
public class DbHelper {

    /**
     * The Context.
     */
    private Context context;
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    public static DbHelper instance;
    /**
     * The constant dbName.
     */
    private final static String dbName = "fjjr2";

    /**
     * 描述 Sets data.
     *

     * @author Lester Huang
     * @created 2017 /02/23 15:01:48
     */
    public DbHelper() {
        context= RxRetrofitApp.getApplication();
        mHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        db = mHelper.getWritableDatabase();

    }


    public SQLiteDatabase getDb() {
        return db;
    }

    /**
     * 获取单例
     *
     * @return instance
     * @author Lester Huang
     * @created 2017 /02/23 15:44:40
     */
    public static DbHelper getInstance() {
        if (instance == null) {
            instance = new DbHelper();
        }
        return instance;
    }






}
