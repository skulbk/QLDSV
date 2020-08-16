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
    
    public void addClass(Classes clazz){
        try {
            classDAO.saveClass(clazz);
        } catch (Exception e) {
            System.err.println("Failed:"+e.getMessage());
        }
    }
    
    public void updateClass(Classes clazz){
        try {
            classDAO.updateClass(clazz);
        } catch (Exception e) {
            System.err.println("Failed:"+e.getMessage());
        }
    }
    
    public boolean deleteClass(int id){
        try {
            classDAO.deleteClass(id);
            return true;
        } catch (Exception e) {
            System.err.println("Failed:"+e.getMessage());
            return false;
        }
    }
    
    public Classes getClassById(int id){
        return classDAO.getClassById(id);
    }
}
