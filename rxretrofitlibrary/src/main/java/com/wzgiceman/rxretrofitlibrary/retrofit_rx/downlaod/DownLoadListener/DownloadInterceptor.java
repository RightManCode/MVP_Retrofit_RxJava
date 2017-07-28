package com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.DownLoadListener;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * 成功回调处理 Created by WZG on 2016/10/20.
 *
 * @author Lester Huang
 * @created 2017 /02/23 15:22:13
 */
public class DownloadInterceptor implements Interceptor {

    /**
     * The Listener.
     */
    private DownloadProgressListener listener;
    /**
     * 描述 Sets data.
     *

     * @author Lester Huang
     * @created 2017 /02/23 15:01:48
     */
    public DownloadInterceptor(DownloadProgressListener listener) {
        this.listener = listener;
    }

    /**
     * 描述 create.
     * 
     * @author Lester Huang
     * @created 2017 /02/23 15:22:24 Intercept response.
     * @param chain
     *            the chain
     * @return the response
     * @throws IOException
     *             the io exception
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        return originalResponse.newBuilder()
                .body(new DownloadResponseBody(originalResponse.body(), listener))
                .build();
    }
}
