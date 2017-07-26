package com.test.POJOs;

import java.util.Arrays;

/**
 * Created by user on 7/21/2017.
 */
public class User extends Person {
    private int id;
    private String password;
    private String userName;
    private String coffeePrefs;


    public User() {
    }

    public User(int id, String password, String userName, String coffeePrefs) {
        super();
        this.id = id;
        this.password = password;
        this.userName = userName;
        this.coffeePrefs = coffeePrefs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoffeePrefs() {
        return coffeePrefs;
    }

    public void setCoffeePrefs(String coffeePrefs) {
        this.coffeePrefs = coffeePrefs;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", coffeePrefs='" + coffeePrefs + '\'' +
                '}';
    }
}
