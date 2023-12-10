/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.*;

/**
 *
 * @author PC-Phong
 */
public class Dao extends DBContext {

    public List<Account> getAllAcc() {
        List<Account> list = new ArrayList<>();
        try {
            String sql = "select * from account";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Comment> getAllComment() {
        List<Comment> list = new ArrayList<>();
        try {
            String sql = "select * from comment";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Comment(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                ));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Thread0> getAllThread0() {
        List<Thread0> list = new ArrayList<>();
        try {
            String sql = "select * from thread";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Thread0(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public void Insert(String c, String userid, int tid) {
        String sql = "Insert into Comment values(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, c);
            ps.setString(2, userid);
            ps.setInt(3, tid);
            ps.execute();
        } catch (Exception e) {

        }
    }

}
