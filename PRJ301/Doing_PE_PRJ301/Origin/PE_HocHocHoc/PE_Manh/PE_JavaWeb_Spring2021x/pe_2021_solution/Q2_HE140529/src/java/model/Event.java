/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author ADMIN
 */
public class Event {

    private int id;
    private String content;
    private Date date;
    private boolean isEnable;
    private String createdby;

    public Event() {
    }

    public String getDateFormat() {
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        return df.format(date);
    }

    public Event(int id, String content, Date date, boolean isEnable, String createdby) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.isEnable = isEnable;
        this.createdby = createdby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isIsEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", content=" + content + ", date=" + date + ", isEnable=" + isEnable + ", createdby=" + createdby + '}';
    }

}
