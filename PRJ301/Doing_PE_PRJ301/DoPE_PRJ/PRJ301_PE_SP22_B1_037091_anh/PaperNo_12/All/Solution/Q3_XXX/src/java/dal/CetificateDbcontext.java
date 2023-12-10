/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.cetificate;

/**
 *
 * @author Admin
 */
public class CetificateDbcontext extends DBContext{
    public ArrayList<cetificate> getAllCetificate(){
        ArrayList<cetificate> certs = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM [Certificate]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                cetificate a = new cetificate(rs.getInt(1),rs.getString(2));
                certs.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CetificateDbcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return certs;
    }
}
