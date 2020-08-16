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
    
    public void addSubject(Classes clazz){
        try {
            classDAO.saveClass(clazz);
        } catch (Exception e) {
            System.err.println("Failed:"+e.getMessage());
        }
    }
    
    public void updateSubject(Classes clazz){
        try {
            classDAO.updateClass(clazz);
        } catch (Exception e) {
            System.err.println("Failed:"+e.getMessage());
        }
    }
    
    public boolean deleteSubject(int id){
        try {
            classDAO.deleteClass(id);
            return true;
        } catch (Exception e) {
            System.err.println("Failed:"+e.getMessage());
            return false;
        }
    }
}
