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

/**
 *
 * @author Admin
 */
public class Tong_hop_DBcontext extends DBContext{
    
    //insert 
    public void insertJob(Job job) {

        try {
            String sql = "INSERT INTO [Jobs]\n"
                    + "           ([Name]\n"
                    + "           ,[Salary]\n"
                    + "           ,[Datecreated]\n"
                    + "           ,[Activated])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, job.getName());
            stm.setDouble(2,job.getSalary());
            stm.setDate(3,job.getDate());
            stm.setBoolean(4, job.isActivated());
            stm.executeUpdate();
            
        } catch (Exception ex) {
            Logger.getLogger(JobDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    //getAll
    public ArrayList<Job> getAllJob(){
        ArrayList<Job> Jobs = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM [Jobs]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Job a = new Job(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getDate(4),rs.getBoolean(5));
                Jobs.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Jobs;
    }
    
    //get Account By Id
    public Account getAccountByID(String id, String pass) {
        try {

            String sql = "SELECT * FROM Account WHERE accountid = ? and [password] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, pass);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account account = new Account(rs.getString("accountid"),rs.getString("password"));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //get All obj by account
    public ArrayList<Event> getAllEventByIDAccount(String id){
        ArrayList<Event> Events = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM [Event] where created_by = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Event a = new Event(rs.getInt("id"), rs.getString("content"), rs.getDate("date"), rs.getBoolean("isEnable"), rs.getString("created_by"));
                Events.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Events;
    }
    
    
    //Delete
    public void delete(int id) {

        try {

            String sql = "DELETE FROM [Comments]\n"
                    + "      WHERE CommentID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //update
    public void updateAccount(Account account) {

        try {
            String sql = "UPDATE [Account]\n"
                    + "   SET [active] = ?\n"
                    + " WHERE uId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setBoolean(1, account.isActive());
            stm.setInt(2, account.getUid());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void main(String[] args) {
        JobDBcontext a =new JobDBcontext();
        ArrayList<Job> b = a.getAllJob();
        for (Job job : b) {
            System.out.println(job.getName());
        }
    }
}
