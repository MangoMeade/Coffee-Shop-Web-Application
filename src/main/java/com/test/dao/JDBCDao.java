package com.test.dao;

import com.test.JDBC.JDBC;
import com.test.POJOs.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
Aaron Board
 */
public class JDBCDao implements userDao {
    public ArrayList<User> readUsers() {
        Connection Jdbc = JDBC.getInstance();

        Statement myStmt;
        try {
            myStmt = Jdbc.createStatement();

            ResultSet myRS = myStmt.executeQuery("select * from user");

            while (myRS.next()){
                System.out.println(myRS.getString("userName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void addUser(User user) {
        Connection Jdbc = JDBC.getInstance();

        Statement myStmt;
        try {
            myStmt = Jdbc.createStatement();

            myStmt.executeUpdate("INSERT INTO user (username, email, password, coffeePrefs, sex, phone, name, age)\n" +
                    "VALUES ("+user.getUserName()+", "+user.getEmail()+", "+user.getPassword()+", "+user.getCoffeePrefs()+", "+user.getSex()+", "+user.getPhone()+", "+user.getName()+", "+user.getAge()+");");
            System.out.println("update complete");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public User getUser(String email, String password) {
        return null;
    }
}
