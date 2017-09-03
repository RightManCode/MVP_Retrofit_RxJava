package com.example.admin.mvp_retrofit_rxjava.application;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.IOException;



/**
 * Created by admin on 2017/7/26.
 */

public class MyApplication extends Application {

    private static final String APATCH_PATH = "/out.apatch";

    private static final String TAG = "cww";

    @Override
    public void onCreate() {
        super.onCreate();
        PatchManager patchManager = new PatchManager(this);
        patchManager.init("1.0");
        patchManager.loadPatch();

        //和后台商量，更新包下载到本地
        try {
            // .apatch file path
            String patchFileString = Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + APATCH_PATH;
            patchManager.addPatch(patchFileString);
            Log.d(TAG, "apatch:" + patchFileString + " added.");
        } catch (IOException e) {
            Log.e(TAG, "", e);
        }
    }
}
