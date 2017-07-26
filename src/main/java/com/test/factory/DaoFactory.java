package com.test.factory;

import com.test.dao.HibernateDao;
import com.test.dao.JDBCDao;
import com.test.dao.userDao;
import org.hibernate.cfg.Configuration;

/*
Aaron Board
 */
public class DaoFactory {
    public static userDao getInstance(int selection){
        switch (selection){
            case userDao.JDBC_DAO:
                return new JDBCDao();
            case  userDao.HIBERNATE_DAO:
                return new HibernateDao(new Configuration().configure("hibernate.cfg.xml").buildSessionFactory());
            default:
                return null;
        }

    }
}
