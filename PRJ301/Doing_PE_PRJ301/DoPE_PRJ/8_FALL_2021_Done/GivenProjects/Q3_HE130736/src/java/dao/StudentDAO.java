/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.SchoolYear;
import model.Student;

/**
 *
 * @author Le Hong Quan
 */
public class StudentDAO extends DBContext {

    public List<Student> getAll() {
        try {
            List<Student> list = new ArrayList<>();
            //mo ket noi
            String sql = "select Student.*,SchoolYear.id as school_year_id, SchoolYear.title from Student inner join  Student_Class \n"
                    + "on Student.id = Student_Class.studentid\n"
                    + "inner join Class on Student_Class.classid = Class.id\n"
                    + "inner join SchoolYear on SchoolYear.id = Class.schoolyear";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SchoolYear schoolYear = new SchoolYear();
                schoolYear.setId(rs.getInt(6));
                schoolYear.setTitle(rs.getString(7));
                Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), schoolYear);
                list.add(student);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public List<Student> getAllBySchoolYearId(int schoolYearId) {
        try {
            List<Student> list = new ArrayList<>();
            //mo ket noi
            String sql = "select Student.*,SchoolYear.id as school_year_id, SchoolYear.title from Student inner join  Student_Class \n"
                    + "on Student.id = Student_Class.studentid\n"
                    + "inner join Class on Student_Class.classid = Class.id\n"
                    + "inner join SchoolYear on SchoolYear.id = Class.schoolyear where SchoolYear.id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, schoolYearId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SchoolYear schoolYear = new SchoolYear();
                schoolYear.setId(rs.getInt(6));
                schoolYear.setTitle(rs.getString(7));
                Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), schoolYear);
                list.add(student);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

    public void delete(int sid) {
        try {
            //mo ket noi
            String sql = "DELETE FROM [dbo].[Student]\n"
                    + "      WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, sid);
            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void deleteStudentClass(int sid) {
        try {
            //mo ket noi
            String sql = "DELETE FROM [dbo].[Student_Class]\n"
                    + "      WHERE studentid=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, sid);
            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}
