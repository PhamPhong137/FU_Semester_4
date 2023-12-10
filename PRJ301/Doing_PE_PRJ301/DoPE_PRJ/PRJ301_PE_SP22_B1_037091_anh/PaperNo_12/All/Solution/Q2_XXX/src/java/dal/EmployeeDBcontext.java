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
import model.Account;
import model.employee;

/**
 *
 * @author Admin
 */
public class EmployeeDBcontext extends DBContext{
    public ArrayList<employee> getAllEmployeeByUsername(String username){
        ArrayList<employee> employees = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM Employee where createdby = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);//ddaay laf câu lệnh truyền thông tin vào dấu ?
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                employee a = new employee();
                a.setEmpid(rs.getInt(1));
                a.setEmpname(rs.getString(2));
                a.setEmpdob(rs.getDate(3));
                a.setEmpgender(rs.getBoolean(4));
                a.setCreateby(rs.getString(5));
                employees.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }
    
    public static void main(String[] args) {
        EmployeeDBcontext a = new EmployeeDBcontext();
        ArrayList<employee> b = a.getAllEmployeeByUsername("mra");
        for (employee object : b) {
            System.out.println(object.getEmpdob());
        }
    }
}
