package com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api;

/**
 * 回调信息统一封装类

 *
 * @author Lester Huang
 * @created 2017 /02/23 15:22:03
 */
public class BaseResultEntity {
    /**
     * The Ret.
     */
//  判断标示
    private int ret;
    /**
     * The Msg.
     */
//    提示信息
    private String msg;
    /**
     * The Data.
     */
    //显示数据（用户需要关心的数据）
    private String data;

    /**
     * 描述 Gets msg.
     *
     * @return the msg
     * @author Lester Huang
     * @created 2017 /02/23 15:22:03
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 描述 Sets msg.
     *
     * @param msg the msg
     * @author Lester Huang
     * @created 2017 /02/23 15:22:03
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 描述 Gets data.
     *
     * @return the data
     * @author Lester Huang
     * @created 2017 /02/23 15:22:03
     */
    public String getData() {
        return data;
    }

    /**
     * 描述 Sets data.
     *
     * @param data the data
     * @author Lester Huang
     * @created 2017 /02/23 15:22:03
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * 描述 Gets ret.
     *
     * @return the ret
     * @author Lester Huang
     * @created 2017 /02/23 15:22:03
     */
    public int getRet() {
        return ret;
    }

    /**
     * 描述 Sets ret.
     *
     * @param ret the ret
     * @author Lester Huang
     * @created 2017 /02/23 15:22:03
     */
    public void setRet(int ret) {
        this.ret = ret;
    }
}
