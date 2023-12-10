/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Author;
import model.AuthorByTitle;
import model.Paper;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    public List<Paper> getAllPapers() {
        List<Paper> p = new ArrayList<>();
        String sql = "select * from Paper";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.add(new Paper(rs.getString(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException e) {
        }

        return p;
    }

    public List<Author> getAllAuthor() {
        List<Author> a = new ArrayList<>();
        String sql = "SELECT *\n"
                + "FROM [PRJ321_FALL20_B5].[dbo].[Author]";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a.add(new Author(rs.getString(1), rs.getString(2)));
            }

        } catch (SQLException e) {
        }

        return a;
    }

    public List<AuthorByTitle> searchAuthorByTitile(String name) {
        List<AuthorByTitle> a = new ArrayList<>();
        String sql = "select p.paperid, p.title, p.publisheddate \n"
                + "from Author a, Author_Paper ap, Paper p\n"
                + "where (a.authorid = ap.authorid) and (p.paperid = ap.paperid)\n"
                + "and a.authorname like ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a.add(new AuthorByTitle(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return a;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        System.out.println(dao.searchAuthorByTitile("mr A"));
    }
}
