/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.controller;

import com.aptech.qldsv.dao.ScoreTypeDAO;
import com.aptech.qldsv.entity.ScoreType;
import java.util.List;

/**
 *
 * @author skulb
 */
public class ScoreTypeController {
    
    ScoreTypeDAO scoreTypeDAO = new ScoreTypeDAO();
    
    public List<ScoreType> getAllType(){
        return scoreTypeDAO.getAllScoreType();
    }
}
