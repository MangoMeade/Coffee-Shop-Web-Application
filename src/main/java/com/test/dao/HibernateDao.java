package com.test.dao;

import com.test.POJOs.User;
import com.test.dao.userDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
Aaron Board
 */
public class HibernateDao implements userDao {

    private static SessionFactory factory;
    private static String msg;

    public HibernateDao(SessionFactory factory) {
        this.factory = factory;
    }

    /* Method to  READ all the users */
    public List<User> readUsers() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<User> users = null;
        try {
            tx = session.beginTransaction();
            users = session.createQuery("FROM User").list();
            tx.commit();  //COMMIT MUST COME AFTER THE ACTION
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    /* Method to CREATE a user in the database */
    public void addUser(User user) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public User getUser(String userName, String password) {
        List<User> users = readUsers();


        for( User user : users){
            if (user.getUserName().equals(userName)){
                if (user.getPassword().equals(password)){
                    return user;
                }
                else {
                    msg = "Wrong Password!";
                }
            }else {
                msg = "User does not exist, please register";
            }
        }
        return null;
    }


    /* Method to  READ all the users */
    public void listUsers() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List users = session.createQuery("FROM User").list();
            for (Iterator iterator =
                 users.iterator(); iterator.hasNext(); ) {
                User user = (User) iterator.next();
                System.out.print("Username: " + user.getUserName());
                System.out.print("  email: " + user.getEmail());
                System.out.println("  phone: " + user.getPhone());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    /* Method to UPDATE password for an user */
    public void updateUser(Integer userID, String newPass) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            User user = (User) session.get(User.class, userID);
            user.setPassword(newPass);
            session.update(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    /* Method to DELETE an user from the records */
    public void deleteUser(Integer userID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            User user = (User) session.get(User.class, userID);
            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public String getMsg() {
        return msg;
    }

    public static void setMsg(String msg) {
        HibernateDao.msg = msg;
    }
}

