package com.test.dao;

import com.test.JDBC.JDBC;
import com.test.POJOs.ItemsEntity;
import com.test.POJOs.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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


        Statement myStmt;
        try {
            Connection Jdbc = JDBC.getInstance();
            myStmt = Jdbc.createStatement();

            String vals = String.format(" Values('%s','%s','%s','%s','%s','%d','%s','%d')", user.getUserName(),user.getEmail(),user.getPassword(),user.getCoffeePrefs(),user.getSex(),user.getPhone(),user.getName(),user.getAge());

            myStmt.executeUpdate("INSERT INTO user(username, email, password, coffeePrefs, sex, phone, name, age)\n" + vals);
            System.out.println("update complete");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public User getUser(String email, String password) {
        return null;
    }

    public String getMsg() {
        return null;
    }

    public void addItem(ItemsEntity item) {

    }

    public List<ItemsEntity> readItems() {
        return null;
    }

    public void addInventory(int iditems) {

    }

    public int getLastItemID() {
        return 0;
    }

    public void deleteItem(int itemID) {

    }

    public void editItem(ItemsEntity itemID) {

    }

    public ItemsEntity getItemsEntity(int itemID) {
        return null;
    }
}
