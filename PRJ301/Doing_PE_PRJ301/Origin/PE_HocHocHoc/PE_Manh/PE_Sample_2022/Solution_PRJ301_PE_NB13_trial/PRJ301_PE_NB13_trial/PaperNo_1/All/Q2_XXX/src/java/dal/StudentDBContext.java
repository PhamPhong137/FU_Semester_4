/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author Khanh Manh
 */
public class StudentDBContext extends DBContext{
    

    public ArrayList<Student> getAllJobSearch(String search) {
        ArrayList<Student> Students = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM Student where [name] like '%"+search+"%'";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Student a = new Student(rs.getInt(1),rs.getString(2),rs.getBoolean(3),rs.getDate(4));
                Students.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Students;
    }
    public static void main(String[] args) {
        System.out.println(new StudentDBContext().getAllJobSearch(""));
    }
}
