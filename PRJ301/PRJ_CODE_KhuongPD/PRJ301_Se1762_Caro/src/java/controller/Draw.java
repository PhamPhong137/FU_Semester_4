/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

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
public class Draw extends HttpServlet {

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
            out.println("<title>Servlet Draw</title>");
            out.println("<link rel ='stylesheet' href='css/mycss.css'/> ");
            out.println("<script src='js/myjs.js' type='text/javascript'> </script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Play caro " + "</h1>");
            int n = Integer.parseInt(request.getParameter("size"));
            out.println("<input onclick='reset("+n+")' type=\"submit\" value=\"RESET GAME\" >");           
            String s = "<table>";
            for (int i = 0; i < n; i++) {
                s += "<tr>";
                for (int j = 0; j < n; j++) {
//                    if ((i + j) % 2 == 0) {
//                        s += "<td style='background-color:pink'>";
//                    } else {
//                        s += "<td style='background-color:yellow'>";
//                    }
//                   s+= "<td style='background-color:"+(((i+j)%2==0)?"pink":"blue")+ "'>";
//
                    s += "<td id= 'btn" + (i * n + j) + "' onclick='myfun(" + i + "," + j + "," + n + ")'  >";
                    s += "</td>";
                }
                s += "</tr>";
            }
            s += "</table>";
            out.println(s);
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
        processRequest(request, response);
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
