/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author skulb
 */
@Embeddable
public class ScoreId implements Serializable{
    
    @Column(name = "id_student")
    String studentId;
    @Column(name = "id_subject")
    Integer subjectId;
    @Column(name = "id_type")
    Integer typeId;

    public ScoreId() {
    }

    public ScoreId(String studentId, Integer subjectId, Integer typeId) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.typeId = typeId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "ScoreId{" + "studentId=" + studentId + ", subjectId=" + subjectId + ", typeId=" + typeId + '}';
    }
    
}
