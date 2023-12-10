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
import model.Author;

/**
 *
 * @author Admin
 */
public class AuthorDBContext extends DBContext{
    public ArrayList<Author> getAllAuthor(){
        ArrayList<Author> Authors = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM [Author]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Author a = new Author();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                Authors.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Authors;
    }
    
    public static void main(String[] args) {
        ArrayList<Author> a = new AuthorDBContext().getAllAuthor();
        for (Author author : a) {
            System.out.println(author.getId());
        }
    }
}
