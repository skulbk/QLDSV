/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.dao;

import com.aptech.qldsv.entity.User;
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
public class UserDAO {
    
    private SessionFactory factory = HibernateUtils.getSessionFactory();
    
    public List<User> getAllUsers( ){
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
}
