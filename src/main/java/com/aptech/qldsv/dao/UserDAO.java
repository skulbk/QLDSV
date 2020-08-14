/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.dao;

import com.aptech.qldsv.entity.User;
import com.aptech.qldsv.utils.HibernateUtils;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author skulb
 */
public class UserDAO {
    
    private SessionFactory factory = HibernateUtils.getSessionFactory();
    
    public List<User> getAllScoreType( ){
        Session session = factory.openSession();
        Transaction tx = null;
        List<User> lstUser = new ArrayList<>();
      
        try {
            tx = session.beginTransaction();
            lstUser = session.createQuery("FROM User").list(); 
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        } finally {
            session.close(); 
        }
        
       return lstUser;
    }

    public User findUserById(int id) {
        Session session = factory.openSession();
        User user = session.load(User.class, id);
        System.out.println(user);
        session.close();
        return user;
    }

    public void saveUser(User user) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            System.out.println("insert success!");
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void updatePassword(int id, String password) {
        Session session = factory.openSession();
        try {
            String sql = "UPDATE User u SET u.password = :newPassword WHERE u.id = :id";
            session.createQuery(sql).setParameter("newPassword", password).setParameter("id", id).executeUpdate();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void deleteUser(int id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            User user = session.load(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            System.out.println("delete success!");
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}
