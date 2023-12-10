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
import model.Employee;

/**
 *
 * @author Admin
 */
public class EmployeeDBcontext extends DBContext {



    public ArrayList<Employee> getAllEmployeetByDisplayName(String Dis) {
        ArrayList<Employee> Employees = new ArrayList<>();

        try {

            String sql = "SELECT  * FROM Account a\n"
                    + "INNER JOIN Employee e ON a.username = e.createdby\n"
                    + "WHERE a.displayname = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, Dis);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Employee a = new Employee(rs.getInt(4), rs.getString(5), rs.getDate(6), rs.getBoolean(7));
                Employees.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Employees;
    }
    

}
