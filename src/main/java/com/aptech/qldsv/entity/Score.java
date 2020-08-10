/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author skulb
 */
@Entity
@Table(name = "score")
public class Score implements Serializable {
    
    @EmbeddedId
    private ScoreId id;
    @Column(name = "score")
    private String score;
    
    public Score() {
    }

    public Score(ScoreId id, String score) {
        this.id = id;
        this.score = score;
    }

    public ScoreId getId() {
        return id;
    }

    public void setId(ScoreId id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" + "id=" + id + ", score=" + score + '}';
    }
    
}
