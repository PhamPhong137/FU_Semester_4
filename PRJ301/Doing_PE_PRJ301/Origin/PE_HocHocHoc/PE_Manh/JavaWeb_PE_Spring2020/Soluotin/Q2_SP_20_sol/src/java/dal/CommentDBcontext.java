/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Comment;

/**
 *
 * @author Admin
 */
public class CommentDBcontext extends DBContext {

    public ArrayList<Comment> getAllMessage( String user) {
        ArrayList<Comment> Comments = new ArrayList<>();
        try {
            String sql = "Select * from Comments where username = ?";
            Connection conn = getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, user);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Comment a = new Comment(rs.getInt(1),rs.getString(2),rs.getString(3),
                                        rs.getDate(4),rs.getBoolean(5));
                Comments.add(a);
            }
        } catch (Exception ex) {
            Logger.getLogger(CommentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Comments;
    }
    
    
    public void insert(Comment comment) {
        try {
            String sql = "INSERT INTO [dbo].[Comments]\n"
                    + "           ([username]\n"
                    + "           ,[content]\n"
                    + "           ,[created_date]\n"
                    + "           ,[urgen])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            Connection conn = getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, comment.getName());
            stm.setString(2, comment.getContent());
            stm.setDate(3, comment.getDate());
            stm.setBoolean(4, comment.isUrgent());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CommentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
