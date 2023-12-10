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
import model.Paper;

/**
 *
 * @author Admin
 */
public class PaperDBcontext extends DBContext {

    public ArrayList<Paper> getAllPaperById(int id) {
        ArrayList<Paper> papers = new ArrayList<>();
        try {
            
            String sql = "SELECT p.paperid,p.title,p.publisheddate,a.authorid FROM Author a\n"
                    + "INNER JOIN \n"
                    + "Author_Paper ap ON a.authorid = ap.authorid\n"
                    + "INNER JOIN \n"
                    + " Paper p ON p.paperid = ap.paperid \n"
                    + " WHERE a.authorid = ?";
            PreparedStatement stm =  connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Paper a = new Paper(rs.getInt(1), rs.getString(2), rs.getDate(3),rs.getInt(4));
                papers.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaperDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return papers;
    }
//    public static void main(String[] args) {
//        PaperDBcontext a = new PaperDBcontext();
//         ArrayList<Paper> papers = a.getAllPaperById(1000);
//         for (Paper paper : papers) {
//             System.out.println(paper.getTitle());
//        }
//    }
}
