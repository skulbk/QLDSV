/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.dto;

/**
 *
 * @author skulb
 */
public class StudentScoreDTO {
    
    private int subjectID;
    private String subjectName;
    private String score1;
    private String score2;
    private String score3;

    public StudentScoreDTO() {
    }

    public StudentScoreDTO(int subjectID, String subjectName, String score1, String score2, String score3) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }
    
    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getScore1() {
        return score1;
    }

    public void setScore1(String score1) {
        this.score1 = score1;
    }

    public String getScore2() {
        return score2;
    }

    public void setScore2(String score2) {
        this.score2 = score2;
    }

    public String getScore3() {
        return score3;
    }

    public void setScore3(String score3) {
        this.score3 = score3;
    }

    @Override
    public String toString() {
        return "StudentScoreDTO{" + "subjectID=" + subjectID + ", subjectName=" + subjectName + ", score1=" + score1 + ", score2=" + score2 + ", score3=" + score3 + '}';
    }
    
}
