/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Paper {
    int aid;
    int pid;
    String title;
    Date publish;

    public Paper() {
    }

    public Paper(int pid, String title, Date publish,int aid) {
        this.aid = aid;
        this.pid = pid;
        this.title = title;
        this.publish = publish;
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
