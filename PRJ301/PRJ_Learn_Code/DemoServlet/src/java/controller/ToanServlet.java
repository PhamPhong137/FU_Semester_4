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

/**
 *
 * @author PC-Phong
 */
@WebServlet(name = "ToanServlet", urlPatterns = {"/toan"})
public class ToanServlet extends HttpServlet {

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
            out.println("<title>Servlet ToanServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ToanServlet at " + request.getContextPath() + "</h1>");
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
        //  processRequest(request, response);
        request.getRequestDispatcher("toanhoc.html").forward(request, response);
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
        //   processRequest(request, response);
        String num1_raw = request.getParameter("num1");
        String num2_raw = request.getParameter("num2");
        String op = request.getParameter("op");
        double n1, n2;
        PrintWriter out = response.getWriter();
        try {
            if (op == null && num1_raw.isEmpty() && num2_raw.isEmpty()) {
                out.println("<h1>" + "please fill all" + "</h1>");
            } else if (op == null) {
                out.println("please choose option");
            } else if (num1_raw.isEmpty() && !num2_raw.isEmpty()) {
                out.println("please enter number 1");
            } else if (num2_raw.isEmpty() && !num1_raw.isEmpty()) {
                out.println("please enter number 2");
            } else if (num2_raw.isEmpty() && num1_raw.isEmpty()) {
                out.println("please enter number 1 and 2");
            } else {
                n1 = Double.parseDouble(num1_raw);
                n2 = Double.parseDouble(num2_raw);
                out.println(tinh(n1, n2, op));
            }

        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    private String tinh(double a, double b, String op) {
        String ms = "";
        switch (op) {
            case "+":
                ms = "Tong: " + (a + b);
                break;
            case "-":
                ms = "<h1>" + "Tru: " + (a - b) + "</h1>";
                break;
            case "*":
                ms = "Nhan: " + (a * b);
                break;
            case "/":
                if (b == 0) {
                    ms = "khong chia cho 0";
                } else {
                    ms = "Chia: " + (a / b);
                }
                break;
            default:
                throw new AssertionError();
        }
        return ms;
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
