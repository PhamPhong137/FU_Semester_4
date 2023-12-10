/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.MessageDBcontext;
import dal.UserDBcontext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Message;
import model.User;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CreateController", urlPatterns = {"/create"})
public class CreateController extends BaseRequiredAuthenController {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDBcontext udb = new  UserDBcontext();
        ArrayList<User> users = udb.getAllUser();
        request.setAttribute("users", users);
        request.getRequestDispatcher("Create.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String to = request.getParameter("to");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        User a = (User)request.getSession().getAttribute("user");
        String from = a.getUserid();
        Message mess = new Message();
        mess.setTo(to);
        mess.setFrom(from);
        mess.setTitle(title);
        mess.setContent(content);
        MessageDBcontext mdb = new MessageDBcontext();
        mdb.insertMessage(mess);
        request.setAttribute("text", "Message send successful!");
        
        UserDBcontext udb = new  UserDBcontext();
        ArrayList<User> users = udb.getAllUser();
        request.setAttribute("users", users);
        
        request.getRequestDispatcher("Create.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
