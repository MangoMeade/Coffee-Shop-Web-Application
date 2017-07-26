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


    public HibernateDao(SessionFactory factory) {
        this.factory = factory;
    }

    public List<User> readUsers() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<User> users = null;
        try {
            tx = session.beginTransaction();
            users = session.createQuery("FROM User").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    /* Method to CREATE an user in the database */
    public void addUser(User user) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            tx.commit();
            session.save(user);
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public User getUser(String userName, String password) {
        List<User> users = readUsers();
        User LoggedInUser = null;

        for( User user : users){
            if (user.getUserName().equals(userName)){
                if (user.getPassword().equals(password)){
                    LoggedInUser = user;
                }
                else {
                    System.out.println("Wrong Password!");
                }
            }else {
                System.out.println("Wrong User Name!");
            }
        }
        return LoggedInUser;
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
            User user =
                    (User) session.get(User.class, userID);
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
            User user =
                    (User) session.get(User.class, userID);
            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

