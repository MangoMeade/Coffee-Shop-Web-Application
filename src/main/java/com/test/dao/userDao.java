package com.test.dao;

import com.test.POJOs.User;

import java.util.ArrayList;

/*
Aaron Board

 */
public interface userDao {
    static int JDBC_DAO = 1;
    static int FLAT_DAO = 2;

    public ArrayList<User> readUsers();
    public void addUser(User user);
    public User getUser(String email, String password);
}
