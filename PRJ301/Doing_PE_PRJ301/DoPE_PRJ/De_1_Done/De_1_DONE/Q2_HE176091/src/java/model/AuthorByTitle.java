/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class AuthorByTitle {

    private String id;
    private String title;
    private String publisheddate;

    public AuthorByTitle() {
    }

    public AuthorByTitle(String id, String title, String publisheddate) {
        this.id = id;
        this.title = title;
        this.publisheddate = publisheddate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisheddate() {
        return publisheddate;
    }

    public void setPublisheddate(String publisheddate) {
        this.publisheddate = publisheddate;
    }

    @Override
    public String toString() {
        return "AuthorByTitle{" + "id=" + id + ", title=" + title + ", publisheddate=" + publisheddate + '}';
    }

}
