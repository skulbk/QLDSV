/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.controller;

import com.aptech.qldsv.dao.StudentDAO;
import com.aptech.qldsv.entity.Student;
import java.util.List;

/**
 *
 * @author skulb
 */
public class StudentController {
    
    StudentDAO studentDAO = new StudentDAO();
    
    public List<Student> getAllStudent(){
        return studentDAO.getAllStudent();
    }
    
}
