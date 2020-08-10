/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.dao;

import com.aptech.qldsv.entity.ScoreType;
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
public class ScoreTypeDAO {
    
    private SessionFactory factory = HibernateUtils.getSessionFactory();
    
    public List<ScoreType> getAllScoreType( ){
        Session session = factory.openSession();
        Transaction tx = null;
        List<ScoreType> lstType = new ArrayList<>();
      
        try {
            tx = session.beginTransaction();
            lstType = session.createQuery("FROM ScoreType").list(); 
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        } finally {
            session.close(); 
        }
        
       return lstType;
    }
}
