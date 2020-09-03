/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.controller;

import com.aptech.qldsv.dao.ScoreDAO;
import com.aptech.qldsv.dao.ScoreTypeDAO;
import com.aptech.qldsv.dao.SubjectDAO;
import com.aptech.qldsv.dto.StudentScoreDTO;
import com.aptech.qldsv.entity.Score;
import com.aptech.qldsv.entity.ScoreId;
import com.aptech.qldsv.entity.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author skulb
 */
public class ScoreController {
    
    private ScoreDAO scoreDAO = new ScoreDAO();
    private ScoreTypeDAO typeDAO =  new ScoreTypeDAO();
    private SubjectDAO subDAO = new SubjectDAO();
    private Map<Integer, String> map = new HashMap<>();
    
    public List<StudentScoreDTO> getScoreByStudent(int id){
        List<Score> lstScore = scoreDAO.getByStudent(id);
        List<StudentScoreDTO> list = new ArrayList<>();
        for(Score score : lstScore){
            StudentScoreDTO s = new StudentScoreDTO();
            Subject sub = subDAO.getSubjectById(score.getId().getSubjectId());
            if(map.containsKey(sub.getId())){
                for(StudentScoreDTO ss : list){
                    if(score.getId().getSubjectId()==ss.getSubjectID()){
                        if(score.getId().getTypeId()==1){
                            ss.setScore1(score.getScore());
                        }
                        if(score.getId().getTypeId()==2){
                            ss.setScore2(score.getScore());
                        }
                        if(score.getId().getTypeId()==3){
                            ss.setScore3(score.getScore());
                        }
                    }
                }
            } else {
                map.put(sub.getId(), sub.getName());
                s.setSubjectID(sub.getId());
                s.setSubjectName(sub.getName());
                if(score.getId().getTypeId()==1){
                    s.setScore1(score.getScore());
                }
                if(score.getId().getTypeId()==2){
                    s.setScore2(score.getScore());
                }
                if(score.getId().getTypeId()==3){
                    s.setScore3(score.getScore());
                }
                list.add(s);
            }
        }
        map.clear();
        return list;
    }
    
    public List<Score> getScoreByStudent2(int id){
        return scoreDAO.getByStudent(id);
    }
    
    public boolean addScore(Score score){
        boolean result = false;
        try {
            if(scoreDAO.saveScore(score)){
                result = true;
            }
        } catch (Exception e) {
            System.err.println("Failed:"+e.getMessage());
            result = false;
        }
        return result;
    }
    
    public boolean updateScore(Score score){
        try {
            scoreDAO.updateScore(score);
            return true;
        } catch (Exception e) {
            System.err.println("Failed:"+e.getMessage());
            return false;
        }
    }
    
    public boolean deleteScore(ScoreId id){
        try {
            scoreDAO.deleteScore(id);
            return true;
        } catch (Exception e) {
            System.err.println("Failed:"+e.getMessage());
            return false;
        }
    }
}
