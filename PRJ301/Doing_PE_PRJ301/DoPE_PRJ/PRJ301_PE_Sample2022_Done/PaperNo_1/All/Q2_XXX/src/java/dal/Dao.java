/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import jakarta.servlet.jsp.jstl.sql.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Student;

/**
 *
 * @author PC-Phong
 */
public class Dao extends DBContext {

    public List<Student> searchStudent(String search) {
        List<Student> list = new ArrayList<>();
        try {
            String sql = "select * from student where [name] like ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + search + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getBoolean(3),
                        rs.getDate(4)
                ));
            }
        } catch (SQLException e) {
        }
        return list;
    }

}
