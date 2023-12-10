/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.DAO;
import Models.Menu;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PC-Phong
 */
public class MyMenu extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel ='stylesheet' href = 'css/style.css'/>");
            out.println("<title>Servlet MyMenu</title>");
            out.println("</head>");
            out.println("<body>");
            DAO.INSTANCE.loadMenu();
            out.println("<header><nav>");
            out.print(makeMenu(0));
            out.println("</nav></header>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String makeMenu(int pid) {
        int count = 0;
        for (Menu m : DAO.INSTANCE.getMenu()) {
            if (m.getPid() == pid) {
                count++;
            }
        }
        if (count == 0) {
            return "";
        }
        String s = "<ul>";
        for (Menu m : DAO.INSTANCE.getMenu()) {
            if (m.getPid() == pid) {
                s += "<li title='" + m.getTitle() + "'>";

                if (m.getLink() != null) {
                    s += "<a href='" + m.getLink() + "'>" + m.getName() + "</a>";
                } else {
                    s += m.getName();
                    s += makeMenu(m.getId());
                    s += "</li>";
                }
            }
        }
        s += "</ul>";
        return s;
    }

}
