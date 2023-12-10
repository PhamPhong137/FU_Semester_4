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
import model.Skill;

/**
 *
 * @author Admin
 */
public class SkillDbcontext extends DBContext{
    public ArrayList<Skill> getAllSkill(){
        ArrayList<Skill> Skills = new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM [Skill]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Skill a = new Skill(rs.getInt(1),rs.getString(2));
                Skills.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SkillDbcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Skills;
    }
}
