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
    
    public List<SchoolYear> getAll() {
        try {
            List<SchoolYear> list = new ArrayList<>();
            //mo ket noi
            String sql = "select * from SchoolYear";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SchoolYear schoolYear = new SchoolYear(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4));
                list.add(schoolYear);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }

}
