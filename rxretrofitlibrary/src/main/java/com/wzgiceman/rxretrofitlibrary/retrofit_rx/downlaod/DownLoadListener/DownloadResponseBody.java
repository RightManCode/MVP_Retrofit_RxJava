package com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.DownLoadListener;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * 自定义精度的body
 *
 * @author Lester Huang
 * @created 2017 /02/23 15:22:40
 */
public class DownloadResponseBody extends ResponseBody {

    /**
     * The Response body.
     */
    private ResponseBody responseBody;
    /**
     * The Progress listener.
     */
    private DownloadProgressListener progressListener;
    /**
     * The Buffered source.
     */
    private BufferedSource bufferedSource;
    /**
     * 描述 Sets data.
     *

     * @author Lester Huang
     * @created 2017 /02/23 15:01:48
     */
    public DownloadResponseBody(ResponseBody responseBody, DownloadProgressListener progressListener) {
        this.responseBody = responseBody;
        this.progressListener = progressListener;
    }

    /**
     * 描述 create.
     *
     * @return the media type
     * @author Lester Huang
     * @created 2017 /02/23 15:22:40 Content type media type.
     */
    @Override
    public MediaType contentType() {
        return responseBody.contentType();
    }

    /**
     * 描述 create.
     *
     * @return the long
     * @author Lester Huang
     * @created 2017 /02/23 15:22:40 Content length long.
     */
    @Override
    public long contentLength() {
        return responseBody.contentLength();
    }

    /**
     * 描述 create.
     *
     * @return the buffered source
     * @author Lester Huang
     * @created 2017 /02/23 15:22:40 Source buffered source.
     */
    @Override
    public BufferedSource source() {
        if (bufferedSource == null) {
            bufferedSource = Okio.buffer(source(responseBody.source()));
        }
        return bufferedSource;
    }

    /**
     * 描述 create.
     *
     * @param source the source
     * @return the source
     * @author Lester Huang
     * @created 2017 /02/23 15:22:41 Source source.
     */
    private Source source(Source source) {
        return new ForwardingSource(source) {
            long totalBytesRead = 0L;

            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                long bytesRead = super.read(sink, byteCount);
                // read() returns the number of bytes read, or -1 if this source is exhausted.
                totalBytesRead += bytesRead != -1 ? bytesRead : 0;
                if (null != progressListener) {
                    progressListener.update(totalBytesRead, responseBody.contentLength(), bytesRead == -1);
                }
                return bytesRead;
            }
        };

    }
}
