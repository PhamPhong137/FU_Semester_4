/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;

/**
 *
 * @author PC-Phong
 */
public class Student {
    //javabean
    private String id;
    private String name;
    private boolean gender;
    private String departId;
    private int age;
    private float gpa;
    private String add;
    private String img;
    private Date dob;
    public Student() {
    }

    public Student(String id, String name, boolean gender, String departId, int age, float gpa, String add, String img, Date dob) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.departId = departId;
        this.age = age;
        this.gpa = gpa;
        this.add = add;
        this.img = img;
        this.dob = dob;
    }

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
   
   
}
