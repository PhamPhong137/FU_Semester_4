/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Message;
import model.User;

/**
 *
 * @author Admin
 */
public class MessageDBcontext extends DBContext {

    public ArrayList<Message> getAllMessage() {
        ArrayList<Message> Messages = new ArrayList<>();
        try {
            String sql = "Select * from MessageTBL";
            Connection conn = getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Message a = new Message(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7));
                Messages.add(a);
            }
        } catch (Exception ex) {
            Logger.getLogger(MessageDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Messages;
    }

    public static void main(String[] args) {
        MessageDBcontext a = new MessageDBcontext();
        ArrayList<Message> list = a.getAllMessage();
        for (Message user : list) {
            System.out.println(user.getTitle());
        }

    }

    public Message getMessageByID(String id) {
        try {
            String sql = "SELECT * FROM MessageTBL Where messageid = ?";
            Connection conn = getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Message a = new Message(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7));
                return a;
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertMessage(Message mess) {

        try {
            String sql = "INSERT INTO [dbo].[MessageTBL]\n"
                    + "           ([messagetitle]\n"
                    + "           ,[messagetime]\n"
                    + "           ,[from]\n"
                    + "           ,[to]\n"
                    + "           ,[messagecontent]\n"
                    + "           ,[isread])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,GETDATE()\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,0)";
            Connection conn = getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, mess.getTitle());
            stm.setString(2, mess.getFrom());
            stm.setString(3, mess.getTo());
            stm.setString(4, mess.getContent());
            stm.executeUpdate();
            
        } catch (Exception ex) {
            Logger.getLogger(UserDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

