package com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod;

/**
 * 下载状态

 *
 * @author Lester Huang
 * @created 2017 /02/23 15:23:07
 */
public enum  DownState {
    START(0),
    DOWN(1),
    PAUSE(2),
    STOP(3),
    ERROR(4),
    FINISH(5);
    private int state;

    /**
     * 描述 Gets state.
     *
     * @return the state
     * @author Lester Huang
     * @created 2017 /02/23 15:23:07
     */
    public int getState() {
        return state;
    }

    /**
     * 描述 Sets state.
     *
     * @param state the state
     * @author Lester Huang
     * @created 2017 /02/23 15:23:07
     */
    public void setState(int state) {
        this.state = state;
    }

    DownState(int state) {
        this.state = state;
    }
}
