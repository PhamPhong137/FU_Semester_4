/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author Admin
 */
public class UserDBcontext extends DBContext{
    
    public ArrayList<User> getAllUser(){
        ArrayList<User> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM UserTBL";
            Connection conn = getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {                
                User a = new User(rs.getString("userid"), rs.getString("password"));
                users.add(a);
            }   
        } catch (Exception ex) {
            Logger.getLogger(UserDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    public User getUserByID(String user,String pass){
        try {
            String sql = "SELECT * FROM UserTBL Where userid = ? and password = ?";
            Connection conn = getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {                
                User a = new User(rs.getString("userid"), rs.getString("password"));
                return a;
            }   
        } catch (Exception ex) {
            Logger.getLogger(UserDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
//    public static void main(String[] args) {
//        UserDBcontext a = new UserDBcontext();
////        ArrayList<User> list = a.getAllUser();
////        for (User user : list) {
////            System.out.println(user.getUserid());
////        }
//        User b = a.getUserByID("mra", "123");
//        System.out.println(b.getUserid());
//        
//    }
}
