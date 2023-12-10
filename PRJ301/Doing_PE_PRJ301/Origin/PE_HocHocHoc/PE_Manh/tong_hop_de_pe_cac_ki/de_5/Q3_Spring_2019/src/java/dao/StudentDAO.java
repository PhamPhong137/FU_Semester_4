/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.StudentDe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<StudentDe> getAllByDid(int did) throws SQLException {
        List<StudentDe> list = new ArrayList<>();
        String query = "select s.sname, s.sdob,s.sgender, s.did, d.dname\n"
                + "from students s, departments d\n"
                + "where s.did = d.did and s.did = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, did);
            rs = ps.executeQuery();
            while (rs.next()) {
                StudentDe sd = new StudentDe(
                        rs.getString("sname"),
                        rs.getString("sdob"),
                        rs.getInt("sgender"),
                        rs.getString("dname")
                );
                list.add(sd);
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

    public List<StudentDe> getAll() throws SQLException {
        List<StudentDe> list = new ArrayList<>();
        String query = "select s.sname, s.sdob,s.sgender, s.did, d.dname\n"
                    + "from students s, departments d\n"
                    + "where s.did = d.did";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                StudentDe sd = new StudentDe(
                        rs.getString("sname"),
                        rs.getString("sdob"),
                        rs.getInt("sgender"),
                        rs.getString("dname")
                );
                list.add(sd);
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

    public List<StudentDe> getDepartmentName() throws SQLException {
        List<StudentDe> list = new ArrayList<>();
        String query = "select * from departments";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                StudentDe sd = new StudentDe(rs.getInt("did"),
                        rs.getString("dname"));
                list.add(sd);
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
