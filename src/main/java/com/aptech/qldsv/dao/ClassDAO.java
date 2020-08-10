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
}
