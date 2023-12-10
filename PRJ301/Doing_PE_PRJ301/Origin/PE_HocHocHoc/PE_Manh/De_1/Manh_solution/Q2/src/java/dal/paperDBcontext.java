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
import model.Paper;

/**
 *
 * @author Admin
 */
public class paperDBcontext extends DBContext {

    public ArrayList<Paper> getAllPaperByAid(int aid) {
        ArrayList<Paper> Papers = new ArrayList<>();
        try {

            String sql = "SELECT a.authorid,p.paperid,p.title,p.publisheddate FROM Author a\n"
                    + "INNER JOIN\n"
                    + "Author_Paper ap ON a.authorid = ap.authorid\n"
                    + "INNER JOIN \n"
                    + "Paper p ON ap.paperid = p.paperid\n"
                    + "WHERE a.authorid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, aid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Paper a = new Paper();
                a.setAid(rs.getInt(1));
                a.setPid(rs.getInt(2));
                a.setTitle(rs.getString(3));
                a.setPublish(rs.getDate(4));
                Papers.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Papers;
    }
    public static void main(String[] args) {
        ArrayList<Paper> a = new paperDBcontext().getAllPaperByAid(1000);
        for (Paper paper : a) {
            System.out.println(paper.getTitle());
        }
    }
}
