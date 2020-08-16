/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.dao;

import com.aptech.qldsv.entity.Classes;
import com.aptech.qldsv.utils.HibernateUtils;
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
public class ClassDAO {
    
    private SessionFactory factory = HibernateUtils.getSessionFactory();
    
    public List<Classes> getAllClass( ){
        Session session = factory.openSession();
        Transaction tx = null;
        List<Classes> lstClass = new ArrayList<>();
      
        try {
            tx = session.beginTransaction();
            lstClass = session.createQuery("FROM Classes").list(); 
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        } finally {
            session.close(); 
        }
        
       return lstClass;
    }
    
    public void saveClass(Classes clazz) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(clazz);
            session.getTransaction().commit();
            System.out.println("insert success!");
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void updateClass(Classes clazz){
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Classes c = session.get(Classes.class, clazz.getId());
            c.setName(clazz.getName());
            session.saveOrUpdate(c);
            session.getTransaction().commit();
            System.out.println("update success!");
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void deleteClass(int id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Classes clazz = session.load(Classes.class, id);
            session.delete(clazz);
            session.getTransaction().commit();
            System.out.println("delete success!");
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
