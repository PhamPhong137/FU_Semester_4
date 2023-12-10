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
import model.Entries;

/**
 *
 * @author Admin
 */
public class EntriesDBcontext extends DBContext{
    public ArrayList<Entries> getAllEntries(){
        ArrayList<Entries> entries = new ArrayList<>();
        try {
            
            String sql = "SELECT  * FROM Entries";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Entries a = new Entries(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                        rs.getDate(5),rs.getDate(6));
                entries.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntriesDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entries;
    }
    public Entries getEntriesById(int id){
        
        try {
            
            String sql = "SELECT  * FROM Entries where EntryID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {                
                Entries a = new Entries(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                        rs.getDate(5),rs.getDate(6));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntriesDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) {
        EntriesDBcontext a = new EntriesDBcontext();
        ArrayList<Entries> entries = a.getAllEntries();
        Entries b = a.getEntriesById(2);
        System.out.println(b.getDateModified());
//        for (Entries entry : entries) {
//            System.out.println(entry.getTitle());
//        }
    }
}
