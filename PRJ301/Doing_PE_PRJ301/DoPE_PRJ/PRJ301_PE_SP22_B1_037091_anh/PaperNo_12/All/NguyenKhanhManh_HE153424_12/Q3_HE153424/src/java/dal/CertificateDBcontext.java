/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cetificate;

/**
 *
 * @author Admin
 */
public class CertificateDBcontext extends DBContext{
    public ArrayList<Cetificate> getAllCetificate(){
        ArrayList<Cetificate> Cetificates = new ArrayList<>();
        try {
            
            String sql = "SELECT  * FROM [Certificate]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Cetificate a = new Cetificate(rs.getInt(1), rs.getString(2));
                Cetificates.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CertificateDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Cetificates;
    }
}
