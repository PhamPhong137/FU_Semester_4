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
import model.Account;

/**
 *
 * @author Admin
 */
public class AccountDBcontext extends DBContext{
    public ArrayList<Account> getAllAccount(){
        ArrayList<Account> Accounts = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM [Account]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Account a = new Account();
                a.setUsername(rs.getString(1));
                a.setPassword(rs.getString(2));
                a.setDisplayname(rs.getString(3));
                Accounts.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Accounts;
    }
    
    public static void main(String[] args) {
        AccountDBcontext a = new AccountDBcontext();
        ArrayList<Account> b = a.getAllAccount();
        for (Account account : b) {
            System.out.println(account.getDisplayname());
        }
    }
}
