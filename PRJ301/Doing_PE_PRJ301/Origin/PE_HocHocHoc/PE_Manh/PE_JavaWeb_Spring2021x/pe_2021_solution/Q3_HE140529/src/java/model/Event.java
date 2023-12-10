/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Event {

    private int id;
    private String content;
    private String createdby;
    List<Record> list;

    public Event() {
    }

    public Event(int id, String content, String createdby, List<Record> list) {
        this.id = id;
        this.content = content;
        this.createdby = createdby;
        this.list = list;
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

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public List<Record> getList() {
        return list;
    }

    public void setList(List<Record> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", content=" + content + ", createdby=" + createdby + ", list=" + list + '}';
    }

}
