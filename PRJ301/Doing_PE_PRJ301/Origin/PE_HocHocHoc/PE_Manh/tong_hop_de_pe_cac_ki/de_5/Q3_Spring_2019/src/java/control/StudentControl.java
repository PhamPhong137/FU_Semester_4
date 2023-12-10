/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.StudentDAO;
import entity.StudentDe;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "StudentControl", urlPatterns = {"/StudentControl"})
public class StudentControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
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
         try {
            StudentDAO studentDAO = new StudentDAO();
            List<StudentDe> list = studentDAO.getDepartmentName();
            request.setAttribute("department", list);
            List<StudentDe> listAll = studentDAO.getAll();
            request.setAttribute("listAll", listAll);
            request.getRequestDispatcher("List.jsp").forward(request, response);
            
        } catch (Exception e) {
        }
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
        try {
            StudentDAO studentDAO = new StudentDAO();
            List<StudentDe> list = studentDAO.getDepartmentName();
            request.setAttribute("department", list);
            int did = Integer.parseInt(request.getParameter("departmentName"));
            List<StudentDe> listAll;
            if(did == 0){
               listAll = studentDAO.getAll();
            }else{
               listAll = studentDAO.getAllByDid(did);
            }
            request.setAttribute("listAll", listAll);
            request.getRequestDispatcher("List.jsp").forward(request, response);
        } catch (Exception e) {
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
