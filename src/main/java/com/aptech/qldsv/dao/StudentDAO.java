/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.dao;

import com.aptech.qldsv.entity.Student;
import com.aptech.qldsv.utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.w3c.dom.ls.LSOutput;

/**
 * @author skulb
 */
public class StudentDAO {

    private SessionFactory factory = HibernateUtils.getSessionFactory();

    public List<Student> getAllStudent() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Student> lstStudent = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            lstStudent = session.createQuery("FROM Student").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
        return lstStudent;
    }

    public Student findStudentById(int id) {
        Session session = factory.openSession();
        Student student = session.load(Student.class, id);
        System.out.println(student);
        session.close();
        return student;
    }

    public void saveStudent(Student student) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            System.out.println("insert success!");
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteStudent(int id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Student student = session.load(Student.class, id);
            session.delete(student);
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

    public List<Student> searchByName(String name) {
        Session session = factory.openSession();
        try {
            List<Student> list = session.createQuery("SELECT '*' FROM Student WHERE name LIKE :name")
                    .setParameter("name", "%" + name + "%").list();
            for (Student student : list) {
                System.out.println(student);
            }
            return list;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.flush();
            session.close();
        }
    }
    
    public void updateStudent(Student student){
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Student s = session.get(Student.class, student.getId());
            s.setName(student.getName());
            s.setGender(student.getGender());
            s.setBirthday(student.getBirthday());
            s.setAddress(student.getAddress());
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
    
    public List<Student> getStudentByClass(int id){
        Session session = factory.openSession();
        Transaction tx = null;
        List<Student> lstStudent = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            lstStudent = session.createQuery("FROM Student WHERE id_class = :id").setParameter("id", id).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
        return lstStudent;
    }
}
