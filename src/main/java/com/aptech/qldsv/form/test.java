/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.form;

import com.aptech.qldsv.dao.ScoreDAO;
import com.aptech.qldsv.dao.ScoreTypeDAO;
import com.aptech.qldsv.dao.SubjectDAO;
import com.aptech.qldsv.dto.StudentScoreDTO;
import com.aptech.qldsv.entity.Score;
import com.aptech.qldsv.entity.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class test {
    
    private static ScoreDAO scoreDAO = new ScoreDAO();
    private static ScoreTypeDAO typeDAO =  new ScoreTypeDAO();
    private static SubjectDAO subDAO = new SubjectDAO();
    private static Map<Integer, String> map = new HashMap<>();
    
    public static void main(String[] args) {
        
        getScoreByStudent(4);
        
    }
    
    public static void getScoreByStudent(int id){
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
        System.out.println(list);
    }
}
