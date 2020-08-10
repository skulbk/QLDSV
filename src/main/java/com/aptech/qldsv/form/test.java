/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.form;

import com.aptech.qldsv.dao.ClassDAO;
import com.aptech.qldsv.dao.ScoreDAO;
import com.aptech.qldsv.dao.ScoreTypeDAO;
import com.aptech.qldsv.dao.StudentDAO;
import com.aptech.qldsv.dao.SubjectDAO;
import com.aptech.qldsv.dao.UserDAO;
import com.aptech.qldsv.entity.Classes;
import com.aptech.qldsv.entity.Score;
import com.aptech.qldsv.entity.ScoreType;
import com.aptech.qldsv.entity.Student;
import com.aptech.qldsv.entity.Subject;
import com.aptech.qldsv.entity.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class test {
    public static void main(String[] args) {
        
        SubjectDAO subDAO = new SubjectDAO();
        List<Subject> subs = new ArrayList<>();
        subs = subDAO.getAllSubject();
        System.out.println("======== Subject: "+subs);
        
        ClassDAO classDAO = new ClassDAO();
        List<Classes> lstClass = new ArrayList<>();
        lstClass = classDAO.getAllClass();
        System.out.println("======== Classes: "+lstClass);
        
        StudentDAO studentDAO = new StudentDAO();
        List<Student> lstStudent = new ArrayList<>();
        lstStudent = studentDAO.getAllStudent();
        System.out.println("======== Student: "+lstStudent);
        
        UserDAO userDAO = new UserDAO();
        List<User> lstUser = new ArrayList<>();
        lstUser = userDAO.getAllScoreType();
        System.out.println("======== User: "+lstUser);
        
        ScoreTypeDAO typeDAO = new ScoreTypeDAO();
        List<ScoreType> lstType = new ArrayList<>();
        lstType = typeDAO.getAllScoreType();
        System.out.println("======== ScoreType: "+lstType);
        
        ScoreDAO scoreDAO = new ScoreDAO();
        List<Score> lstScore = new ArrayList<>();
        lstScore = scoreDAO.getAllScore();
        System.out.println("======== Score: "+lstScore);
    }
}
