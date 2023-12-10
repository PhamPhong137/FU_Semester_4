
package entity;

import dao.ListDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Characters {
    private String cid;
    private String name;
    private int gender;
    private String date;
  //  private String skill;
    private List<Skill> skilll;
     public String getDateConvert() {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = dateFormat1.format(date);
        return date1; 
    }
    public Characters() {
    }

    public Characters(String cid, String name, int gender, String date) {
        this.cid = cid;
        this.name = name;
        this.gender = gender;
        this.date = date;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Skill> getSkilll() {
        ListDAO listDAO = new ListDAO();
        try {
            skilll =  listDAO.getSkill(cid);
        } catch (SQLException ex) {
        }
        return skilll;
    }


    
}
