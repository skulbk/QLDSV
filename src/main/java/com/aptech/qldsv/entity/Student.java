/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.qldsv.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author skulb
 */
@Entity
@Table(name = "student")
public class Student implements Serializable {
    
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "gender")
    private Boolean gender;
    @Column(name = "address")
    private String address;
    
    @ManyToOne
    @JoinColumn(name = "id_class", referencedColumnName="id")
    private Classes clazz;

    public Student() {
    }

    public Student(int id, String name, String birthday, Boolean gender, String address, Classes clazz) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.clazz = clazz;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Classes getClazz() {
        return clazz;
    }

    public void setClazz(Classes clazz) {
        this.clazz = clazz;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
    
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", birthday=" + birthday + ", gender=" + gender + ", address=" + address + ", clazz=" + clazz + '}';
    }
    
}
