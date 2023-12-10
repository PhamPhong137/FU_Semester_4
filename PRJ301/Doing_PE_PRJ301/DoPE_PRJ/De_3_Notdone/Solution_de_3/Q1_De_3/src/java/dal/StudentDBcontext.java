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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author Admin
 */
public class StudentDBcontext extends DBContext {

    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> Students = new ArrayList<>();
        try {

            String sql = "select * from Student";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student a = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5));
                Students.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Students;
    }

    public ArrayList<Student> getAllStudentByMaior(String major) {
        ArrayList<Student> Students = new ArrayList<>();
        try {

            String sql = "select * from Student Where Major = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, major);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student a = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5));
                Students.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Students;
    }

    public void insertJob(Student job) {

        try {
            String sql = "INSERT INTO [Student]\n"
                    + "           ([RollNo]\n"
                    + "           ,[Major]\n"
                    + "           ,[FullName]\n"
                    + "           ,[City]\n"
                    + "           ,[Male])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, job.getRollNo());
            stm.setString(2, job.getMajor());
            stm.setString(3, job.getFullName());
            stm.setString(4, job.getCity());
            stm.setBoolean(5, job.isGender());

            stm.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(StudentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        StudentDBcontext a = new StudentDBcontext();
        ArrayList<Student> b = a.getAllStudentByMaior("teacher");
        for (Student student : b) {
            System.out.println(student.city);
        }
    }
}
