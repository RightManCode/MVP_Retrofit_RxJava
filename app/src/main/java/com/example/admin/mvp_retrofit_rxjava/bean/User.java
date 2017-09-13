package com.example.admin.mvp_retrofit_rxjava.bean;

/**
 * Created by admin on 2017/9/3.
 */

public class User {
    String userName;
    String passWord;

    DefaultInfo info;

    String jsonString;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public DefaultInfo getInfo() {
        return info;
    }

    public void setInfo(DefaultInfo info) {
        this.info = info;
    }


    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }
}
