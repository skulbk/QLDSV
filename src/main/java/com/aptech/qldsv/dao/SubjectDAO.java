/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.dao;

import com.aptech.qldsv.entity.Subject;
import com.aptech.qldsv.utils.HibernateUtils;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class SubjectDAO {
    
    private SessionFactory factory = HibernateUtils.getSessionFactory();
    
    public List<Subject> getAllStudent( ){
        Session session = factory.openSession();
        Transaction tx = null;
        List<Subject> subjects = new ArrayList<>();
      
        try {
            tx = session.beginTransaction();
            subjects = session.createQuery("FROM Subject").list(); 
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        } finally {
            session.close(); 
        }
        
       return subjects;
    }
}
