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
import model.Event;
import model.Record;

/**
 *
 * @author ADMIN
 */
public class DAO extends DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Event> getAllEvent() {
        List<Event> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Event";
        DAO dao = new DAO();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Event(rs.getInt(1), rs.getString(2), rs.getString(5), dao.getRecordByEventId(rs.getInt(1))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Record> getRecordByEventId(int eid) {
        List<Record> list = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Record WHERE eid = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, eid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Record(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void insertRecord(String content, int eid) {
        String sql = "INSERT INTO [dbo].[Record] ([content] ,[eid]) VALUES (? ,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, content);
            ps.setInt(2, eid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Event> list = dao.getAllEvent();
        for (Event o : list) {
            System.out.println(o);
        }
    }
}
