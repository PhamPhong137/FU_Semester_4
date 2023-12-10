/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.*;
import Models.*;
import java.util.*;

/**
 *
 * @author PC-Phong
 */
public class DAO {

    private Connection con;
    private String status = "OK";
    private List<Student> std;
    private HashMap<String, Department> dept;
    private List<Student> stdg;
    private List<Student> stdd;
    private List<Student> stdgad;
    private List<Student> stdbt;
    public static DAO INSTANCE = new DAO();

    public DAO() {
        if (INSTANCE == null) {
            try {
                con = new DBContext().getConnection();
            } catch (Exception e) {
                status = "Error ar connection" + e.getMessage();
            }
        }
    }

    public void loadDB() {
        std = new Vector<>();
        String sql = "select * from Student";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                std.add(new Student(
                        rs.getString("Id"),
                        rs.getString(2), //Name
                        rs.getBoolean(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getFloat(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(9)
                ));
            }
        } catch (Exception e) {
            status = "Error ar read Student " + e.getMessage();
        }
        dept = new HashMap<>();
        sql = " select * from Department";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dept.put(rs.getString(1), new Department(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
        } catch (SQLException e) {
            status = "Error ar read Department " + e.getMessage();
        }
    }

    public List<Student> getStdbt() {
        return stdbt;
    }

    public void setStdbt(List<Student> stdbt) {
        this.stdbt = stdbt;
    }

    public List<Student> getStdgad() {
        return stdgad;
    }

    public void setStdgad(List<Student> stdgad) {
        this.stdgad = stdgad;
    }

    public List<Student> getStdd() {
        return stdd;
    }

    public void setStdd(List<Student> stdd) {
        this.stdd = stdd;
    }

    public List<Student> getStdg() {
        return stdg;
    }

    public void setStds(List<Student> stdg) {
        this.stdg = stdg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Student> getStd() {
        return std;
    }

    public void setStd(List<Student> std) {
        this.std = std;
    }

    public HashMap<String, Department> getDept() {
        return dept;
    }

    public void setDept(HashMap<String, Department> dept) {
        this.dept = dept;
    }

    public void Insert(String id, String name, boolean gender, String departId, int age, float gpa, String add, String img, String dob) {
        String sql = "Insert into Student values(?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(4, departId);
            ps.setString(7, add);
            ps.setString(8, img);
            ps.setString(9, dob);
            ps.setBoolean(3, gender);
            ps.setInt(5, age);
            ps.setFloat(6, gpa);
            ps.execute();
        } catch (SQLException e) {
            status = "Error ar insert student" + e.getMessage();
        }
    }

    public void Update(String id, String name, boolean gender, String departId, int age, float gpa, String add, String img, String dob) {
        String sql = "update student set name=?,gender=?, departId=?, age=?, gpa=?, [add]=?,img=?,dob=? where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(3, departId);
            ps.setString(6, add);
            ps.setString(7, img);
            ps.setString(8, dob);
            ps.setString(9, id);
            ps.setBoolean(2, gender);
            ps.setInt(4, age);
            ps.setFloat(5, gpa);
            ps.execute();

        } catch (SQLException e) {
            status = "Error at Update Student" + e.getMessage();
        }
    }

    public void Delete(String id) {
        String sql = "delete from Student where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } catch (Exception e) {
            status = "error at delete Student" + e.getMessage();
        }
    }

    public void SearchStudentByGender(String gender) {
        stdg = new Vector<>();
        String sql = "SELECT * FROM Student WHERE gender = ? OR gender = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, gender);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                stdg.add(new Student(
                        rs.getString("Id"),
                        rs.getString(2), // Name
                        rs.getBoolean(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getFloat(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(9)
                ));
            }
        } catch (Exception e) {
            status = "Error at search Student";
        }
    }

    public void SearchStudentByGenders(String[] genders) {
        stdg = new Vector<>();
        String sql = "SELECT * FROM Student WHERE gender = ? OR gender = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            if (genders.length > 1) {
                // chon ca 2 gioi tinh
                ps.setString(1, genders[0]);
                ps.setString(2, genders[1]);
            } else {
                // chon 1 gioi tinh
                ps.setString(1, genders[0]);
                ps.setString(2, genders[0]);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                stdg.add(new Student(
                        rs.getString("Id"),
                        rs.getString(2), // Name
                        rs.getBoolean(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getFloat(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(9)
                ));
            }

        } catch (Exception e) {
            status = "Error at search Student";
        }

    }

    public void SearchStudentByDepartment(String department) {
        stdd = new Vector<>();
        String sql = " select * from Student where DepartId = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, department);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                stdd.add(new Student(
                        rs.getString("Id"),
                        rs.getString(2), // Name
                        rs.getBoolean(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getFloat(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(9)
                ));
            }
        } catch (Exception e) {
            status = "error at search Student by Department";
        }
    }
    public void SearchStudentByDepartments(String sql) {
        stdd = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                stdd.add(new Student(
                        rs.getString("Id"),
                        rs.getString(2), // Name
                        rs.getBoolean(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getFloat(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(9)
                ));
            }
        } catch (Exception e) {
            status = "error at search Student by Department";
        }
    }

    public void SearchStudentByGandD(String sql) {
        stdgad = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                stdgad.add(new Student(
                        rs.getString("Id"),
                        rs.getString(2), // Name
                        rs.getBoolean(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getFloat(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(9)
                ));
            }
        } catch (Exception e) {
            status = "error at search Student by Gender and Department";
        }
    }

    public void SearchStudentByText(String sql) {
        stdbt = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                stdbt.add(new Student(
                        rs.getString("Id"),
                        rs.getString(2), // Name
                        rs.getBoolean(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getFloat(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(9)
                ));
            }
        } catch (Exception e) {
            status = "error at search Student by Gender and Department";
        }
    }

}
