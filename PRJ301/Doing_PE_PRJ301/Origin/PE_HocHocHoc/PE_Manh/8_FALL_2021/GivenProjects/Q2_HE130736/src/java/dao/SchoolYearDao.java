/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.DBContext;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.SchoolYear;

/**
 *
 * @author Le Hong Quan
 */
public class SchoolYearDao extends DBContext {
    
    public void save(String title, Date startDate, Date endDate) {
        try {
            //mo ket noi
            String sql = "INSERT INTO [dbo].[SchoolYear]\n"
                    + "           ([title]\n"
                    + "           ,[startdate]\n"
                    + "           ,[enddate])\n"
                    + "     VALUES\n"
                    + "           (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ps.setDate(2, startDate);
            ps.setDate(3, endDate);
            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
