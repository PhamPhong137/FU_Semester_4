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
import model.Account;
import model.Employee;

/**
 *
 * @author PC-Phong
 */
public class DAO extends DBContext {

    public List<Account> loadAccount() {
        List<Account> acc = new ArrayList<>();
        String sql = "SELECT * FROM account";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                acc.add(new Account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error at loadDB: " + e.getMessage());
        }

        return acc;
    }

    public List<Employee> searchEmployee(String search) {
        List<Employee> list = new ArrayList<>();
        try {
            String sql = "select * from Employee where createdby like ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, search);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getBoolean(4),
                        rs.getString(5)
                ));
            }
        } catch (SQLException e) {
        }
        return list;
    }

}
