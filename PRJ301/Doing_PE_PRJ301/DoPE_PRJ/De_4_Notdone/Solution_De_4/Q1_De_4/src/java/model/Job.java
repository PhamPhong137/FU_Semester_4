/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.text.DecimalFormat;

/**
 *
 * @author Admin
 */
public class Job {

    int id;
    String name;
    double salary;
    Date date;
    boolean activated;

    public Job() {
    }

    public Job(int id, String name, double salary, Date date, boolean activated) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.date = date;
        this.activated = activated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
//        DecimalFormat df = new DecimalFormat("#.####");
//        return df.format(salary);
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

}
