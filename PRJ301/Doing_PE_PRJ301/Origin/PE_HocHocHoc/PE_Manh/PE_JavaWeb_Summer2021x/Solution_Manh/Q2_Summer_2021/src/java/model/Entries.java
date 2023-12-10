/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.sun.xml.fastinfoset.tools.StAX2SAXReader;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Entries {
    private int id;
    private int cid;
    private String title;
    private String entryContext;
    private Date DateCreated;
    private Date DateModified;

    public Entries() {
    }

    public Entries(int id, int cid, String title, String entryContext, Date DateCreated, Date DateModified) {
        this.id = id;
        this.cid = cid;
        this.title = title;
        this.entryContext = entryContext;
        this.DateCreated = DateCreated;
        this.DateModified = DateModified;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEntryContext() {
        return entryContext;
    }

    public void setEntryContext(String entryContext) {
        this.entryContext = entryContext;
    }

    public Date getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(Date DateCreated) {
        this.DateCreated = DateCreated;
    }

    public Date getDateModified() {
        return DateModified;
    }

    public void setDateModified(Date DateModified) {
        this.DateModified = DateModified;
    }
    
}
