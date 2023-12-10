/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author Admin
 */
public class UserDBcontext extends DBContext{
    
    public User getUserById(String user , String pass){
        try {
            String sql = "SELECT * FROM Users where username = ? and [password] = ?";
            Connection conn = getConnection(); 
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User a = new User(rs.getString(1), rs.getString(2));
                return a;
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
