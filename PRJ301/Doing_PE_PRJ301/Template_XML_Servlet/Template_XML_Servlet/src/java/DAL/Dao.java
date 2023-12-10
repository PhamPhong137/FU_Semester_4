/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC-Phong
 */
public class Dao extends DBContext {

    public List<Student> searchStudent(String search) {
        List<Student> list = new ArrayList<>();
        try {
            String sql = "select * from student where [name] like ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + search + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getBoolean(3),
                        rs.getDate(4)
                ));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public void Insert(String id, String name, boolean gender, String departId, int age, float gpa, String add, String img, String dob) {
        String sql = "Insert into Student values(?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(4, departId);
            ps.setString(7, add);
            ps.setString(8, img);
            ps.setString(9, dob);
            ps.setBoolean(3, gender);
            ps.setInt(5, age);
            ps.setFloat(6, gpa);
            ps.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void Update(String id, String name, boolean gender, String departId, int age, float gpa, String add, String img, String dob) {
        String sql = "update student set name=?,gender=?, departId=?, age=?, gpa=?, [add]=?,img=?,dob=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(3, departId);
            ps.setString(6, add);
            ps.setString(7, img);
            ps.setString(8, dob);
            ps.setString(9, id);
            ps.setBoolean(2, gender);
            ps.setInt(4, age);
            ps.setFloat(5, gpa);
            ps.execute();

        } catch (Exception e) {

        }
    }

    public void Delete(String id) {
        String sql = "delete from Student where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } catch (Exception e) {
        }
    }

//    public Account getAccByUsername(String username,String password) {
//        Account account = null;
//        String sql = "SELECT * FROM Account_he176151 WHERE username = ? and password = ?";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, username);
//            ps.setString(2, password);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                account = new Account(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getString(7),
//                        rs.getInt(8)
//                );
//            }
//        } catch (SQLException e) {
//            status = "Error at get Acc";
//        }
//        return account;
//    }
    
    
// public List<Account> getAllAcc() {
//        List<Account> list = new ArrayList<>();
//        try {
//            String sql = "select * from account";
//            PreparedStatement st = connection.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                list.add(new Account(
//                        rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3)
//                ));
//            }
//        } catch (SQLException e) {
//        }
//        return list;
//    }
    
    
    
    
    // Cach lam quan he 1-n
//     public Room getRoomById(int id) {
//        Room r = null;
//        String sql = "SELECT * FROM room_he176151 WHERE id = ?";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                r = new Room(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getInt(3)
//                );
//            }
//            return r;
//        } catch (SQLException e) {
//            status = "Error at getRoomById " + e.getMessage();
//        }
//        return null;
//    }
//     
//      public List<Seat> loadSeat(int film_id, String startHour) {
//        List<Seat> listSeat = new ArrayList<>();
//        String sql = "SELECT DISTINCT s.id, s.seat_number, s.type, s.price, s.roomid "
//                + "FROM film_he176151 AS f "
//                + "INNER JOIN ticket_film_he176151 AS tf ON f.id = tf.filmid "
//                + "INNER JOIN room_he176151 AS r ON tf.roomid = r.id "
//                + "INNER JOIN seat_he176151 AS s ON r.id = s.roomid "
//                + "INNER JOIN event_he176151 AS e ON tf.eventid = e.id "
//                + "WHERE f.id = ? AND e.startHour = ?";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, film_id);
//            ps.setString(2, startHour);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                listSeat.add(new Seat(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getInt(4),
//                        RoomDAO.INSTANCE.getRoomById(rs.getInt(5))
//                ));
//            }
//        } catch (SQLException e) {
//            System.err.println("Error at loadSeat: " + e.getMessage());
//        }
//        return listSeat;
//    }
    
    
    
    
    
    
    
    
}
