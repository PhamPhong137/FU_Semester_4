/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;

/**
 *
 * @author PC-Phong
 */
@WebServlet(name = "TinhServlet1", urlPatterns = {"/tinh1"})
public class TinhServlet1 extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TinhServlet1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("        <form action=\"tinh1\" method=\"post\" >\n"
                    + "            enter radius : <input type=\"text\" name=\"r\" /><br/>\n"
                    + "            <input  type=\"submit\" value=\"Submit\" />\n"
                    + "        </form> ");
            if (request.getAttribute("dt") != null) {
                String s = (String) request.getAttribute("dt");
                out.println("<h2>Dien tich:" + s + "</h2>");
            }

            out.println();
//            out.println("<h1>Servlet TinhServlet1 at " + request.getContextPath () + "</h1>");
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //  processRequest(request, response);
        String r_raw = request.getParameter("r");
        double r;
        try {
            r = Double.parseDouble(r_raw);
            double s = r * r * Math.PI;
            DecimalFormat f = new DecimalFormat("##.##");
            String ss = f.format(s);
            request.setAttribute("dt", ss);
            processRequest(request, response);
      //      request.getRequestDispatcher("tinh1").forward(request, response);
        } catch (NumberFormatException e) {
            System.out.print(e);
        }
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
