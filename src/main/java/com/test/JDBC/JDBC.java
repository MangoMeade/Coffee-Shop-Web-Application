package com.test.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
Aaron Board
 */
public class JDBC {

    private static Connection myConn;

    private JDBC(Connection myConn) {
        JDBC.myConn = myConn;
    }

    public static Connection getInstance(){
        try{
            if (myConn == null){
                myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeeShop", "ajboard13", "Runner13");
                return myConn;
            } else {
                return myConn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
