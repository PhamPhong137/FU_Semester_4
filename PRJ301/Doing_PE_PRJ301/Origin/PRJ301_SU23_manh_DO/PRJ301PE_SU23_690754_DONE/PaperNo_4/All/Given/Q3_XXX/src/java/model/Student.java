/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Student {

    private String id;
    private String name;
    private String dob;
    private boolean gender;
    private String classID;

    public Student() {
    }

    public Student(String id, String name, String dob, boolean gender, String classID) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.classID = classID;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", classID=" + classID + '}';
    }

}
