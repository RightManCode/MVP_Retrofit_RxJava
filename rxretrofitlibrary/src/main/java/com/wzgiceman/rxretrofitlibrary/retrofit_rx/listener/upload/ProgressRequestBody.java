package com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.upload;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * 自定义回调加载速度类RequestBody
 * 
 * @author Lester Huang
 * @created 2017 /02/23 15:26:16
 */
public class ProgressRequestBody extends RequestBody {
    /**
     * The Request body.
     */
    //实际的待包装请求体
    private final RequestBody requestBody;
    /**
     * The Progress listener.
     */
    //进度回调接口
    private final UploadProgressListener progressListener;
    /**
     * The Buffered sink.
     */
    //包装完成的BufferedSink
    private BufferedSink bufferedSink;
    /**
     * 描述 Sets data.
     *

     * @author Lester Huang
     * @created 2017 /02/23 15:01:48
     */
    public ProgressRequestBody(RequestBody requestBody, UploadProgressListener progressListener) {
        this.requestBody = requestBody;
        this.progressListener = progressListener;
    }
    /**
     * 重写调用实际的响应体的contentType
     * 
     * @author Lester Huang
     * @created 2017 /02/23 15:26:17 Content type media type.
     * @return MediaType media type
     */
    @Override
    public MediaType contentType() {
        return requestBody.contentType();
    }

    /**
     * 重写调用实际的响应体的contentLength
     * 
     * @author Lester Huang
     * @created 2017 /02/23 15:26:17 Content length long.
     * @return contentLength long
     * @throws IOException
     *             异常
     */
    @Override
    public long contentLength() throws IOException {
        return requestBody.contentLength();
    }

    /**
     * 重写进行写入
     * 
     * @author Lester Huang
     * @created 2017 /02/23 15:26:17 Write to.
     * @param sink
     *            BufferedSink
     * @throws IOException
     *             异常
     */
    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        if (null == bufferedSink) {
            bufferedSink = Okio.buffer(sink(sink));
        }
        requestBody.writeTo(bufferedSink);
        //必须调用flush，否则最后一部分数据可能不会被写入
        bufferedSink.flush();
    }

    /**
     * 写入，回调进度接口
     * 
     * @author Lester Huang
     * @created 2017 /02/23 15:26:17 Sink sink.
     * @param sink
     *            Sink
     * @return Sink sink
     */
    private Sink sink(Sink sink) {
        return new ForwardingSink(sink) {
            //当前写入字节数
            long writtenBytesCount = 0L;
            //总字节长度，避免多次调用contentLength()方法
            long totalBytesCount = 0L;
            @Override
            public void write(Buffer source, long byteCount) throws IOException {
                super.write(source, byteCount);
                //增加当前写入的字节数
                writtenBytesCount += byteCount;
                //获得contentLength的值，后续不再调用
                if (totalBytesCount == 0) {
                    totalBytesCount = contentLength();
                }
                Observable.just(writtenBytesCount).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        progressListener.onProgress(writtenBytesCount, totalBytesCount);
                    }
                });
            }
        };
    }
}