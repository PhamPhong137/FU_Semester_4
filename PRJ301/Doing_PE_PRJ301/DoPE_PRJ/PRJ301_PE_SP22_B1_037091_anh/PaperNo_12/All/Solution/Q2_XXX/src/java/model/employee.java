/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class employee {
    int empid;
    String empname;
    Date empdob;
    boolean empgender;
    String createby;

    public employee() {
    }

    public employee(int empid, String empname, Date empdob, boolean empgender, String createby) {
        this.empid = empid;
        this.empname = empname;
        this.empdob = empdob;
        this.empgender = empgender;
        this.createby = createby;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Date getEmpdob() {
        return empdob;
    }

    public void setEmpdob(Date empdob) {
        this.empdob = empdob;
    }

    public boolean isEmpgender() {
        return empgender;
    }

    public void setEmpgender(boolean empgender) {
        this.empgender = empgender;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }
    
    
}
