/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;
import models.*;

/**
 *
 * @author Fpt
 */
public class DAO extends DBContext {
    public List<Employee_Certificate> findEmployeeCertificate(){
        List<Employee_Certificate> emce = new Vector<>();
        try {
            String sql = "select * from Employee_Certificate";
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                emce.add(new Employee_Certificate(
                        rs.getInt(1),
                        rs.getInt(2)
                ));
            }
        } catch (Exception e) {
        }
        return emce;
    }
    
    public List<Certificate> findCertificate(){
        List<Certificate> ce = new Vector<>();
        try {
            String sql = "select * from Certificate";
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ce.add(new Certificate(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
        } catch (Exception e) {
        }
        return ce;
    }
    
    public void insertEmployeeCertificate(String eid, String cid){
        try {
            String sql = "insert into Employee_Certificate(eid, cid) values (?,?)";
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(eid));
            ps.setInt(2, Integer.parseInt(cid));
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void deleteEmployeeCertificate(){
        try {
            String sql = "delete from Employee_Certificate";
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
    public List<Employee> findEmployee(){
        List<Employee> em = new Vector<>();
        try {
            String sql = "select * from Employee";
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                em.add(new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
        } catch (Exception e) {
        }
        return em;
    }
    
    public static void main(String[] args) {
        DAO dao = new DAO();
        List<Certificate> ce = dao.findCertificate();
        for (Certificate certificate : ce) {
            System.out.println(certificate.getName());
        }
    }
}