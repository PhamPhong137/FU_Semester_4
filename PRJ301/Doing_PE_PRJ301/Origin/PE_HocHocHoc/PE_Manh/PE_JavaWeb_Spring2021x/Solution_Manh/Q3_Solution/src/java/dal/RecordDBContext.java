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
import model.Event;
import model.Record;

/**
 *
 * @author Admin
 */
public class RecordDBContext extends DBContext {

    public ArrayList<Record> getAllRecord() {
        ArrayList<Record> Records = new ArrayList<>();
        try {

            String sql = "SELECT * FROM Record ";
            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Record a = new Record(rs.getInt("id"), rs.getString("content"), rs.getInt("eid"));
                Records.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Records;
    }

    public void InsertRecord(String content, int eid) {
        try {

            String sql = "INSERT INTO [dbo].[Record]\n"
                    + "           ([content]\n"
                    + "           ,[eid])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, content);
            stm.setInt(2, eid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EventDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
