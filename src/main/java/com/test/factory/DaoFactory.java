package com.test.factory;

import com.test.dao.JDBCDao;
import com.test.dao.userDao;

/**
 * Created by user on 7/21/2017.
 */
public class DaoFactory {
    public static userDao getInstance(int selection){
        switch (selection){
            case userDao.JDBC_DAO:
                return new JDBCDao();
            case  userDao.FLAT_DAO:
                return null;
            default:
                return null;
        }

    }
}
