package com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.upload;

/**
 * 上传进度回调类

 *
 * @author Lester Huang
 * @created 2017 /02/23 15:26:33
 */
public interface UploadProgressListener {
    /**
     * 上传进度
     *
     * @param currentBytesCount the current bytes count
     * @param totalBytesCount   the total bytes count
     * @author Lester Huang
     * @created 2017 /02/23 15:26:33 On progress.
     */
    void onProgress(long currentBytesCount, long totalBytesCount);
}