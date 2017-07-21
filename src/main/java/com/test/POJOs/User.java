package com.test.POJOs;

/**
 * Created by user on 7/21/2017.
 */
public class User extends Person {
    private String pw;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    @Override
    public String toString() {
        return super.toString() + '\'' +
                ", pw='" + pw + '\'';
    }
}
