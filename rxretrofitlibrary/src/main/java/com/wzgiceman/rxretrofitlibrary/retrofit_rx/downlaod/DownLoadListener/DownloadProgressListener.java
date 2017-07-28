package com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.DownLoadListener;


/**
 * 成功回调处理
 * Created by WZG on 2016/10/20.
 *
 * @author Lester Huang
 * @created 2017 /02/23 15:22:32
 */
public interface DownloadProgressListener {
    /**
     * 下载进度
     *
     * @param read  the read
     * @param count the count
     * @param done  the done
     * @author Lester Huang
     * @created 2017 /02/23 15:22:32 Update.
     */
    void update(long read, long count, boolean done);
}
