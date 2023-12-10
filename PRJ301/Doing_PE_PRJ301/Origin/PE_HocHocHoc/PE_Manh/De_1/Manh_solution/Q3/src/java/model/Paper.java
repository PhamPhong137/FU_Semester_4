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
public class Paper {
    int pid;
    String title;
    Date publish;
    String[] aid = null;

    public Paper() {
    }

    public Paper( int pid, String title, Date publish, String[] aid) {

        this.pid = pid;
        this.title = title;
        this.publish = publish;
        this.aid = aid;
    }

    public String[] getAid() {
        return aid;
    }

    public void setAid(String[] aid) {
        this.aid = aid;
    }


    

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublish() {
        return publish;
    }

    public void setPublish(Date publish) {
        this.publish = publish;
    }
    
}