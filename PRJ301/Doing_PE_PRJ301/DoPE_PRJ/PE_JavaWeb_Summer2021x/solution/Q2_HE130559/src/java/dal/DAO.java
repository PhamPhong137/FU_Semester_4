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
import java.util.List;
import model.*;

/**
 *
 * @author ADMIN
 */
public class DAO extends DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account checkLogin(String username, String password) {
        String sql = "SELECT * FROM dbo.Account WHERE username = ?  AND password = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Entries> getAllEntries() {
        List<Entries> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Entries";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Entries(rs.getInt("EntryID"), rs.getString("Title"), rs.getString("EntryContent"), rs.getDate("DateModified")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Entries getEntriesById(String id) {
        String sql = "SELECT * FROM dbo.Entries WHERE EntryID = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Entries(rs.getInt("EntryID"), rs.getString("Title"), rs.getString("EntryContent"), rs.getDate("DateModified"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Entries> list = dao.getAllEntries();
        for (Entries o : list) {
            System.out.println(o);
        }
    }
}
