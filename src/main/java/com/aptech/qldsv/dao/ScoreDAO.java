/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.dao;

import com.aptech.qldsv.entity.Score;
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
public class ScoreDAO {
    
    private SessionFactory factory = HibernateUtils.getSessionFactory();

    public List<Score> getAllScore(){
        Session session = factory.openSession();
        Transaction tx = null;
        List<Score> lstScore = new ArrayList<>();
      
        try {
            tx = session.beginTransaction();
            lstScore = session.createQuery("FROM Score").list(); 
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
        } finally {
            session.close(); 
        }
        
       return lstScore;
    }
    
    public List<Score> getByStudent(int id) {
        Session session = factory.openSession();
        try {
            List<Score> list = session.createQuery("FROM Score WHERE id_student = :id")
                    .setParameter("id",id).list();
            for (Score score : list) {
                System.out.println(score);
            }
            return list;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    
}
