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
import model.Classes;
import model.Student;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    public List<Student> getAllStudent() {
        List<Student> s = new ArrayList<>();
        String sql = "SELECT *\n"
                + "FROM Students";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s.add(new Student(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3).substring(0, rs.getString(3).length() - 10),
                        rs.getBoolean(4),
                        rs.getString(5))
                );
            }
        } catch (SQLException e) {
        }
        return s;
    }

    public List<Classes> getAllClass() {
        List<Classes> c = new ArrayList<>();
        String sql = "SELECT *\n"
                + "FROM Classes";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.add(new Classes(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3))
                );
            }
        } catch (SQLException e) {
        }
        return c;
    }

    public void updateStudent(String id, String name, String dob, boolean gender, String classID) {
        String sql = "UPDATE [dbo].[Students]\n"
                + "   SET [StudentName] = ?\n"
                + "      ,[BirthDate] = ?\n"
                + "      ,[Gender] = ?\n"
                + "      ,[ClassID] = ?\n"
                + " WHERE [StudentID] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, dob);
            ps.setBoolean(3, gender);
            ps.setString(4, classID);
            ps.setString(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public Student getStudentById(String id) {
        String sql = "SELECT [StudentID]\n"
                + "      ,[StudentName]\n"
                + "      ,[BirthDate]\n"
                + "      ,[Gender]\n"
                + "      ,[ClassID]\n"
                + "  FROM [dbo].[Students]\n"
                + "  where [StudentID] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Student(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3).substring(0, rs.getString(3).length() - 10),
                        rs.getBoolean(4),
                        rs.getString(5));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }

    public void updateClasses(String name, String classes) {
       
    }

    public Classes getClassById(String id) {
        String sql = "SELECT [ClassID]\n"
                + "      ,[ClassName]\n"
                + "      ,[StartDate]\n"
                + "  FROM [dbo].[Classes]"
                + "  where [ClassID] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Classes(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3).substring(0, rs.getString(3).length() - 10));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }
    
    
}
