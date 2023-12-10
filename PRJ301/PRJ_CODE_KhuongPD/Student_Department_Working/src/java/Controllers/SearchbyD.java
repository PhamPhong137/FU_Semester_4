/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.DAO;
import Models.Student;
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
@WebServlet(name = "SearchbyD", urlPatterns = {"/SearchbyD"})
public class SearchbyD extends HttpServlet {

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
            out.println("<title>Servlet SearchbyD</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Search student by Department</h1>");
            String s1 = "<table>";
            for (Student s : DAO.INSTANCE.getStdd()) {
                s1 += "<tr>\n"
                        + "                <td><%= s.getId()%></td>\n"
                        + "                <td><%= s.getName()%></td>\n"
                        + "                <td><%= s.isGender()?\"Male\":\"Female\"%></td>\n"
                        + "                <td><%=d.getDept().get(s.getDepartId()).getName()%></td>\n"
                        + "                <td><%= s.getAge()+\" tuổi \"%></td>\n"
                        + "                <td><%= s.getGpa()%></td>\n"
                        + "                <td><%= s.getAdd()%></td>\n"
                        + "                <td><%= s.getImg()%></td>\n"
                        + "                <td><%= s.getDob()%></td>\n"
                        + "            </tr>";
            }
            s1 += "</table>";
            out.println(s1);
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

        Object departId = request.getParameter("departId1");

        String departIds[] = request.getParameterValues("departId2");
        //radio, select_option
        // DAO.INSTANCE.SearchStudentByDepartment(departId + "");

        //checkbox
        String sql = "";
        String s = "";
        if (departIds == null) {
            request.setAttribute("error", "Please choose checkbox");
            request.getRequestDispatcher("Views/SearchbyDepartment.jsp").forward(request, response);
        }
        for (int i = 0; i < departIds.length; i++) {
            s += " departID = '" + departIds[i] + "' or ";
        }

        s = s.substring(0, s.length() - 3);
        sql += "select * from Student where" + s;
        PrintWriter out = response.getWriter();
        out.print(sql);
        DAO.INSTANCE.SearchStudentByDepartments(sql);

        request.setAttribute("dao", DAO.INSTANCE);
        request.getRequestDispatcher("Views/SearchbyDepartment.jsp").forward(request, response);
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
