/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.controller;

import com.aptech.qldsv.dao.UserDAO;
import com.aptech.qldsv.entity.User;
import java.util.List;

/**
 *
 * @author skulb
 */
public class UserController {
    UserDAO userDAO = new UserDAO();
    
    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }
}
