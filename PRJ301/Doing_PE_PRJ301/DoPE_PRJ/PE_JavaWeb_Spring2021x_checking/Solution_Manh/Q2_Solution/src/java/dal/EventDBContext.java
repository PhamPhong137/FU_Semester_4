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

/**
 *
 * @author Admin
 */
public class EventDBContext  extends DBContext{
    public ArrayList<Event> getAllEventByIDAccount(String id){
        ArrayList<Event> Events = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM [Event] where created_by = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Event a = new Event(rs.getInt("id"), rs.getString("content"), rs.getDate("date"), rs.getBoolean("isEnable"), rs.getString("created_by"));
                Events.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Events;
    }
}
