/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Fpt
 */
public class Employee_Certificate {
    private int eid;
    private int cid;

    public Employee_Certificate() {
    }

    public Employee_Certificate(int eid, int cid) {
        this.eid = eid;
        this.cid = cid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
    
}
