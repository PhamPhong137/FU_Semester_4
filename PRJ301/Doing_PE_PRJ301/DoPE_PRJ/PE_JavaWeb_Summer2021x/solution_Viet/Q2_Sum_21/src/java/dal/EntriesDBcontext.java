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
import model.Entries;

/**
 *
 * @author Admin
 */
public class EntriesDBcontext extends DBContext {

    public ArrayList<Entries> getAllEntries() {
        ArrayList<Entries> Entriess = new ArrayList<>();
        try {

            String sql = "SELECT * FROM [Entries]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Entries a = new Entries(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getDate(6));
                Entriess.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntriesDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Entriess;
    }

     public Entries getEntriesByID(int id) {
        try {

            String sql = "SELECT * FROM Entries WHERE EntryID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
               Entries a = new Entries(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getDate(6));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntriesDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        EntriesDBcontext a = new EntriesDBcontext();
        ArrayList<Entries> b = a.getAllEntries();
        for (Entries entries : b) {
            System.out.println(entries.getEntryContext());
        }
    }
}
