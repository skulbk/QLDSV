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
 * @author Administrator
 */
public class SubjectDAO {

    private SessionFactory factory = HibernateUtils.getSessionFactory();

    public List<Subject> getAllSubject() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Subject> lstSubjects = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            lstSubjects = session.createQuery("FROM Subject").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }

        return lstSubjects;
    }

    public void saveSubject(Subject subject) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(subject);
            session.getTransaction().commit();
            System.out.println("Subject created!");
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void updateSubjectName(int id, String name) {
        Session session = factory.openSession();
        try {
            String sql = "UPDATE Subject u SET u.name = : newName WHERE u.id = :id";
            session.createQuery(sql).setParameter("newName", name).setParameter("id", id).executeUpdate();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void deleteSubject(int id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Subject subject = session.load(Subject.class, id);
            session.delete(subject);
            session.getTransaction().commit();
            System.out.println("delete success!");
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
        } finally {
            session.flush();
            session.close();
        }
    }

    public Subject findSubjectById(int id) {
        Session session = factory.openSession();
        Subject subject = session.load(Subject.class, id);
        System.out.println(subject);
        session.close();
        return subject;
    }
    
    public void saveSubject(Subject subject) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(subject);
            session.getTransaction().commit();
            System.out.println("insert success!");
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void updateSubject(Subject subject){
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Subject s = session.get(Subject.class, subject.getId());
            s.setName(subject.getName());
            session.saveOrUpdate(s);
            session.getTransaction().commit();
            System.out.println("update success!");
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void deleteSubject(int id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Subject subject = session.load(Subject.class, id);
            session.delete(subject);
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
