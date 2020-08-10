/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author skulb
 */
@Entity
@Table(name = "class")
public class Classes {
    
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    public Classes() {
    }

    public Classes(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Classes{" + "id=" + id + ", name=" + name + '}';
    }
    
}
