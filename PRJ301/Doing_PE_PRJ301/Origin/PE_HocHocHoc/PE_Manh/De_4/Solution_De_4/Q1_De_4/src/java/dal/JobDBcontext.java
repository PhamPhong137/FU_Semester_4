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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Job;

/**
 *
 * @author Admin
 */
public class JobDBcontext extends DBContext {

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
    
    public static void main(String[] args) {
        JobDBcontext a =new JobDBcontext();
        ArrayList<Job> b = a.getAllJob();
        for (Job job : b) {
            System.out.println(job.getName());
        }
    }
}
