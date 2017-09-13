package com.example.admin.mvp_retrofit_rxjava.bean;

/**
 * Created by admin on 2017/9/11.
 */

public class DomainChangeBean {

    /**
     * id : 数据id
     * domainState : 域名状态(0正常1不正常)
     */

    private String id;
    private String domainState;
    private String systemCode;
    private String domain;

    public DomainChangeBean(String id, String domainState, String systemCode, String domain) {
        this.id = id;
        this.domainState = domainState;
        this.systemCode = systemCode;
        this.domain = domain;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDomainState() {
        return domainState;
    }

    public void setDomainState(String domainState) {
        this.domainState = domainState;
    }
}
