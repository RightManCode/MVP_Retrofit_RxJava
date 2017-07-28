/*
 * Copyright (c) 2005, 2017, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.DownLoadListener;

/** 下载文件在通知栏上的展示接口
 * Created by thinkpad on 2017/4/27.
 */
public interface INoticeListener {
    /*TODO 添加描述 更新通知栏的下载进度
    * Revision Trail: (Date/Author/Description)
    *                 2017/4/27 Laura Song CREATE
    * @author Laura Song
    */
    void noticeBrief(String fileName, int progress);
}
