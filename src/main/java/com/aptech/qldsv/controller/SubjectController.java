/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.controller;

import com.aptech.qldsv.dao.SubjectDAO;
import com.aptech.qldsv.entity.Subject;
import java.util.List;

/**
 *
 * @author skulb
 */
public class SubjectController {
    
    SubjectDAO subjectDAO = new SubjectDAO();
    
    public List<Subject> getAllSubject(){
        return subjectDAO.getAllSubject();
    }
}
