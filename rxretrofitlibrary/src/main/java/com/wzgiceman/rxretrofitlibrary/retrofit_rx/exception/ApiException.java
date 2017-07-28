package com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception;

/**
 * 回调统一请求异常 Created by WZG on 2016/12/12.
 *
 * @author Lester Huang
 * @created 2017 /02/23 15:23:55
 */
public class ApiException extends Exception{
    /**
     * The Code.
     */
    /*错误码*/
    private int code;
    /**
     * The Display message.
     */
    /*显示的信息*/
    private String displayMessage;
    /**
     * 描述 Sets data.
     *

     * @author Lester Huang
     * @created 2017 /02/23 15:01:48
     */
    public ApiException(Throwable e) {
        super(e);
    }
    /**
     * 描述 Sets data.
     *

     * @author Lester Huang
     * @created 2017 /02/23 15:01:48
     */
    public ApiException(Throwable cause,@CodeException.CodeEp int code, String showMsg) {
        super(showMsg, cause);
        setCode(code);
        setDisplayMessage(showMsg);
    }

    /**
     * 描述 Gets code.
     * 
     * @author Lester Huang
     * @created 2017 /02/23 15:24:02
     * @return the code
     */
    @CodeException.CodeEp
    public int getCode() {
        return code;
    }

    /**
     * 描述 Sets code.
     * 
     * @author Lester Huang
     * @created 2017 /02/23 15:24:02
     * @param code
     *            the code
     */
    public void setCode(@CodeException.CodeEp int code) {
        this.code = code;
    }

    /**
     * 描述 Gets display message.
     * 
     * @author Lester Huang
     * @created 2017 /02/23 15:24:03
     * @return the display message
     */
    public String getDisplayMessage() {
        return displayMessage;
    }

    /**
     * 描述 Sets display message.
     * 
     * @author Lester Huang
     * @created 2017 /02/23 15:24:03
     * @param displayMessage
     *            the display message
     */
    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}
