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
@WebServlet(name = "tinhServlet", urlPatterns = {"/tinh"})
public class tinhServlet extends HttpServlet {

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
            out.println("<title>Servlet tinhServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet tinhServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("tinh.jsp").forward(request, response);
        // processRequest(request, response);
//        //lay tu form
//        String money_raw = request.getParameter("money");
//        String change = request.getParameter("change");
//        // lay tu web.xml
//        String usds = getServletContext().getInitParameter("usd");
//        String yens = getServletContext().getInitParameter("yen");
//        double money, usd, yen;
//        PrintWriter out = response.getWriter();
//        try {
//            money = Double.parseDouble(money_raw);
//            usd = Double.parseDouble(usds);
//            yen = Double.parseDouble(yens);
//            double moneychange;
//            if (change.equals("0")) {
//                moneychange = money / usd;
//            } else {
//                moneychange = money / yen;
//            }
//            request.setAttribute("money", moneychange);
//            request.getRequestDispatcher("tinh.jsp").forward(request, response);
//            // out.println("Tien:"+moneychange);
//        } catch (Exception e) {
//            request.setAttribute("error", "Nhap so");
//            request.getRequestDispatcher("tinh.jsp").forward(request, response);
//            //out.println("Phai nhap so");
//        }

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
        // processRequest(request, response);

        // lay tu form
        String money_raw = request.getParameter("money");
        String change = request.getParameter("change");
       // String[] change = request.getParameterValues("change");
        // lay tu web.xml
        String usds = getServletContext().getInitParameter("usd");
        String yens = getServletContext().getInitParameter("yen");
        double money, usd, yen;
        //  PrintWriter out = response.getWriter();
        try {
            money = Double.parseDouble(money_raw);
            usd = Double.parseDouble(usds);
            yen = Double.parseDouble(yens);
              double moneychange;
//            String kq = "";
//            if (change == null) {
//                kq = "ban chua chon loai tien ";
//            } else if (change.length == 1) {
//                if (change[0].equals("0")) {
//                    kq = "Doi sang usd: " + money / usd;
//                } else {
//                    kq = "Doi sang yen: " + money / yen;
//                }
//            } else {
//                kq = "Doi sang usd: " + money / usd +"<br/>"+ "Doi sang yen: " + money / yen;
//            }
            if (change.equals("0")) {
                moneychange = money / usd;
            } else {
                moneychange = money / yen;
            }
            request.setAttribute("ketqua", moneychange);
            request.getRequestDispatcher("tinh.jsp").forward(request, response);
            // out.println("Tien:"+moneychange);
        } catch (Exception e) {
            request.setAttribute("error", "Nhap so");
            request.getRequestDispatcher("tinh.jsp").forward(request, response);
            //out.println("Phai nhap so");
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
