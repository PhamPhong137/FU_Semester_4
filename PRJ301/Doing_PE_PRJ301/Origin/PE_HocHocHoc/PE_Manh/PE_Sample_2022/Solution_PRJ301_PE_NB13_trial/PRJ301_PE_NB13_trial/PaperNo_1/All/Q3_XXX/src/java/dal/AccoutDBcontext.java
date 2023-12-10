/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Khanh Manh
 */
public class AccoutDBcontext extends DBContext{
    public Account getAccountByID(String id, String pass) {
        try {

            String sql = "SELECT * FROM Account WHERE userid = ? and [password] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, pass);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account account = new Account(rs.getString(1),rs.getString(2),rs.getString(3));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccoutDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(new AccoutDBcontext().getAccountByID("mra", "123"));
    }
}
