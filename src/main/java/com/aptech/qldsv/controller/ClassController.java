/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.controller;

import com.aptech.qldsv.dao.ClassDAO;
import com.aptech.qldsv.entity.Classes;
import java.util.List;

/**
 *
 * @author skulb
 */
public class ClassController {
    
    ClassDAO classDAO = new ClassDAO();
    
    public List<Classes> getAllClass(){
        return classDAO.getAllClass();
    }
}
