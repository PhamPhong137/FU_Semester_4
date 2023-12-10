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
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Event(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getBoolean(4), rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Event> list = dao.getAllEvent();
        for (Event o : list) {
            System.out.println(o);
        }
    }
}
