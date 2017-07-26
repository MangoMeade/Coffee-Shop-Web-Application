package com.test.dao;

import com.test.POJOs.User;

import java.util.ArrayList;
import java.util.List;

/*
Aaron Board

 */
public interface userDao {
    static int JDBC_DAO = 1;
    static int HIBERNATE_DAO = 2;

    public List<User> readUsers();
    public void addUser(User user);
    public User getUser(String email, String password);

    String getMsg();
}
