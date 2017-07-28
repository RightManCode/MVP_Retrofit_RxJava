package com.wzgiceman.rxretrofitlibrary.retrofit_rx;

import android.app.Application;

/**
 * 全局app
 * Created by WZG on 2016/12/12.
 *
 * @author Lester Huang
 * @created 2017 /02/23 15:44:54
 */
public class RxRetrofitApp  {
    /**
     * The constant application.
     */
    private static Application application;

    /**
     * 描述 create.
     *
     * @param app the app
     * @author Lester Huang
     * @created 2017 /02/23 15:44:54 Init.
     */
    public static void init(Application app){
        setApplication(app);
    }

    /**
     * 描述 Gets application.
     *
     * @return the application
     * @author Lester Huang
     * @created 2017 /02/23 15:44:54
     */
    public static Application getApplication() {
        return application;
    }

    /**
     * 描述 Sets application.
     *
     * @param application the application
     * @author Lester Huang
     * @created 2017 /02/23 15:44:54
     */
    private static void setApplication(Application application) {
        RxRetrofitApp.application = application;
    }
}
