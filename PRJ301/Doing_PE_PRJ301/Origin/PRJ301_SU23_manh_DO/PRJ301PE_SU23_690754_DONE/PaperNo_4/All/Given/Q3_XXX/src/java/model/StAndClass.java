/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class StAndClass {

    private String id;
    private String name;
    private String dob;
    private boolean gender;
    private String className;

    public StAndClass() {
    }

    public StAndClass(String id, String name, String dob, boolean gender, String className) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.className = className;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "StAndClass{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", className=" + className + '}';
    }

}
