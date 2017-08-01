package com.test.dao;

import com.test.POJOs.InventoryEntity;
import com.test.POJOs.ItemsEntity;
import com.test.POJOs.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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

    public List<ItemsEntity> readItems() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<ItemsEntity> items = null;
        try {
            tx = session.beginTransaction();
            items = session.createQuery("FROM ItemsEntity ").list();
            tx.commit();  //COMMIT MUST COME AFTER THE ACTION
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return items;
    }

    public void addInventory(int iditems) {
        Session session = factory.openSession();
        Transaction tx = null;
        InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setItemsid(iditems);
        try {
            tx = session.beginTransaction();
            session.save(inventoryEntity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public int getLastItemID() {
        Session session = factory.openSession();
        Transaction tx = null;
        ItemsEntity item = null;
        try {
            tx = session.beginTransaction();
            item = (ItemsEntity) session.createQuery("FROM ItemsEntity ORDER BY iditems DESC").setMaxResults(1).uniqueResult();
            tx.commit();  //COMMIT MUST COME AFTER THE ACTION
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        assert item != null;
        return item.getIditems();
    }

    public void deleteItem(int itemID) {
        Session session = factory.openSession();
        Transaction tx = null;
        ItemsEntity itemsEntity = (ItemsEntity) session.createQuery("FROM ItemsEntity where iditems = " +itemID).setMaxResults(1).uniqueResult();
        try {
            tx = session.beginTransaction();
            session.delete(itemsEntity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
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

    public void addItem(ItemsEntity item) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(item);
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
        boolean isUser = false;
        for( User user : users){
            if (isUserNameEquals(userName, user)) {
                isUser = true;
                if (isPasswordEquals(password, user)) {
                    return user;
                } else {
                    msg = "Wrong Password!";

                }
            }
        }
        if (!isUser) {
            msg = "User does not exist, please register";
        }
        return null;
    }

    private boolean isPasswordEquals(String password, User user) {
        return user.getPassword().equals(password);
    }

    private boolean isUserNameEquals(String userName, User user) {
        return user.getUserName().equals(userName);
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

}

