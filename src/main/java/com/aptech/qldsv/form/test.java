/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.form;

import com.aptech.qldsv.dao.SubjectDAO;
import com.aptech.qldsv.entity.Subject;
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
        subs = subDAO.getAllStudent();
        System.out.println(subs);
    }
}
