/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author PC-Phong
 */
public class Student {
    private int sid;
    private String name;
    private boolean gender;
    private Date dob;

    public Student() {
    }

    public Student(int sid, String name, boolean gender, Date dob) {
        this.sid = sid;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getSid() {
        return sid;
    }

    public String getName() {
        return name;
    }

    public boolean isGender() {
        return gender;
    }

    public Date getDob() {
        return dob;
    }
    
    
}
