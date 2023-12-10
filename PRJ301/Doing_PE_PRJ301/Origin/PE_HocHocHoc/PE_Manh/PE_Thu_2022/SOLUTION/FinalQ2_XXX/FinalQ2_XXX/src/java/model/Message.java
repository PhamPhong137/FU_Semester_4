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
public class Message {
    private int massId;
    private String title;
    private String time;
    private String from;
    private String to;
    private String content;
    private boolean isRead;

    public Message() {
    }

    public Message(int massId, String title, String time, String from, String to, String content, boolean isRead) {
        this.massId = massId;
        this.title = title;
        this.time = time;
        this.from = from;
        this.to = to;
        this.content = content;
        this.isRead = isRead;
    }

    public int getMassId() {
        return massId;
    }

    public void setMassId(int massId) {
        this.massId = massId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }
    
    
}
