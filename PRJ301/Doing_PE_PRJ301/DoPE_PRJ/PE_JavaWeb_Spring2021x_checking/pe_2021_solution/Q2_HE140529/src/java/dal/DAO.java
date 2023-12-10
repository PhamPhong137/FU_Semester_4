/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Event;

/**
 *
 * @author ADMIN
 */
public class DAO extends DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Event> getAllEvent(String aid) {
        List<Event> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Event WHERE created_by = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, aid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Event(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getBoolean(4), rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Account checkLogin(String user, String pass) {
        String sql = "SELECT * FROM dbo.Account WHERE accountid = ? AND password = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        Account a = dao.checkLogin("mra", "mraa");
        System.out.println(a);
    }
}
