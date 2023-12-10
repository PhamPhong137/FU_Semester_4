/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Author;
import model.Paper;

/**
 *
 * @author Admin
 */
public class paperDBcontext extends DBContext {

    

     public void insertPaper(int id, String title, Date date) {
        String sql = "INSERT INTO [Paper]\n"
                + "           ([paperid]\n"
                + "           ,[title]\n"
                + "           ,[publisheddate])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, title);
            stm.setDate(3, date);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertAuthor_Paper(int pid, int aid) {
        String sql = "INSERT INTO [Author_Paper]\n"
                + "           ([paperid]\n"
                + "           ,[authorid])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            stm.setInt(2,aid);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
