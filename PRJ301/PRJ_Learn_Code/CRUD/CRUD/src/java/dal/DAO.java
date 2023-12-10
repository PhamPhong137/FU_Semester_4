/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Registration;

public class DAO {
    public static DAO INSTANCE = new DAO();
    public DAO() {
        if (INSTANCE == null) {
            try {
                con = new DBContext().getConnection();
            } catch (Exception e) {
//                status = "Error ar connection" + e.getMessage();
            }
        }
    }
    private Connection con;
    
    private List<Registration> users;

    public List<Registration> getUsers() {
        
        return users;
    }

    public void setUsers(List<Registration> users) {
        this.users = users;
    }
    
    public void loadDB() {
        users = new ArrayList<>();
        String sql = "SELECT * FROM Registration";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new Registration(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
        } catch (Exception e) {
        }
    }
}
