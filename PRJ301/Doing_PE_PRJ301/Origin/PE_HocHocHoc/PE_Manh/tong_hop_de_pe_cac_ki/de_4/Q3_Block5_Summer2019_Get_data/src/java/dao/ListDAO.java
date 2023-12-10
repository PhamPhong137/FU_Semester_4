/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Characters;
import entity.Skill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<Characters> getAllCharacter() throws SQLException {
        List<Characters> list = new ArrayList<>();
        try {
            String query = "select * from characters";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Characters c = new Characters(rs.getString("cid"),
                        rs.getString("name"),
                        rs.getInt("gender"),
                        rs.getString("created_date"));
                list.add(c);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
            ps.close();
            rs.close();
        }
        return null;
    }

    public List<Skill> getSkill(String cid) throws SQLException {
        List<Skill> list = new ArrayList<>();
        try {
            String query = "select s.name\n"
                    + "from Characters c join Character_Skill cs \n"
                    + "on c.cid = cs.cid  join Skills s on cs.sid = s.sid and c.cid = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                Skill skill = new Skill(rs.getString("name"));
                list.add(skill);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
            ps.close();
            rs.close();
        }
        return null;
    }
}
