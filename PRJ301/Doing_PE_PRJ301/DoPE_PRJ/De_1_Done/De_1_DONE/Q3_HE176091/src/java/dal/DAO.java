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

    public void insertPaper(String id, String title, String publisheddate) {
        String sql = "INSERT INTO Paper VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, title);
            ps.setString(3, publisheddate);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void insertAuthorPaper(String paperID, String authorID) {
        String sql = "INSERT INTO Author_Paper VALUES(?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, paperID);
            ps.setString(2, authorID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        System.out.println();
    }
}
