/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Student {
    public String RollNo;
    public String Major;
    public String FullName;
    public String city;
    public boolean gender;

    public Student() {
    }

    public Student(String RollNo, String Major, String FullName, String city, boolean gender) {
        this.RollNo = RollNo;
        this.Major = Major;
        this.FullName = FullName;
        this.city = city;
        this.gender = gender;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String RollNo) {
        this.RollNo = RollNo;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String Major) {
        this.Major = Major;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
    
}
