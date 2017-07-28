package com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception;

/**
 * 运行时自定义错误信息 自由添加错误，需要自己扩展
 * 
 * @author Lester Huang
 * @created 2017 /02/23 15:24:32
 */
public class HttpTimeException extends RuntimeException {
    /**
     * The constant UNKOWN_ERROR.
     */
    /* 未知错误 */
    public static final int UNKOWN_ERROR = 0x1002;
    /**
     * The constant NO_CHACHE_ERROR.
     */
    /* 本地无缓存错误 */
    public static final int NO_CHACHE_ERROR = 0x1003;
    /**
     * The constant CHACHE_TIMEOUT_ERROR.
     */
    /* 缓存过时错误 */
    public static final int CHACHE_TIMEOUT_ERROR = 0x1004;
    /**
     * The constant CHACHE_TIMEOUT_ERROR.
     */
    /* session缓存过时错误 */
    public static final int SESSION_TIMEOUT_ERROR = 0x1005;

    /**
     * 描述 Sets data.
     *
     * 
     * @author Lester Huang
     * @created 2017 /02/23 15:01:48
     */
    public HttpTimeException(int resultCode) {
        super(getApiExceptionMessage(resultCode));
    }

    /**
     * 描述 Sets data.
     *
     * 
     * @author Lester Huang
     * @created 2017 /02/23 15:01:48
     */
    public HttpTimeException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 转换错误数据
     *
     * @author Lester Huang
     * @created 2017 /02/23 15:24:32
     * @param code
     *            the code
     * @return api exception message
     */
    private static String getApiExceptionMessage(int code) {
        switch (code) {
            case UNKOWN_ERROR:
                return "错误：网络错误";
            case NO_CHACHE_ERROR:
                return "错误：无缓存数据";
            case CHACHE_TIMEOUT_ERROR:
                return "错误：缓存数据过期";
            case SESSION_TIMEOUT_ERROR:
                return "错误：登录session缓存过期";
            default:
                return "错误：未知错误";
        }
    }
}
