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
import model.Author;

/**
 *
 * @author Admin
 */
public class AuthorDBcontext extends DBContext{
    public ArrayList<Author> getAllAuthor(){
        ArrayList<Author> Authors = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM Author";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Author a = new Author(rs.getInt(1), rs.getString(2),null);
                Authors.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Authors;
    }
    
}
