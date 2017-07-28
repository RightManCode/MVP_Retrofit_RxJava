/*
 * Copyright (c) 2005, 2017, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.DownLoadListener;

import java.io.File;

/**
 * Created by thinkpad on 2017/4/18.
 */
public interface OnDownload {
    /**
     * 下载进度
     * @param url       下载链接
     * @param finished 下载进度
     */
    void  onDownloading(String url, int finished);

    /**
     * 下载完成
     * @param downloadFile  下载完成后的文件
     */
    void onDownloadFinished(File downloadFile);
}
