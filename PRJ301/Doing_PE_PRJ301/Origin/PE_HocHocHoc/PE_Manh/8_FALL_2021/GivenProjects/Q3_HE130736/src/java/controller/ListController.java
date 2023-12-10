/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SchoolYearDao;
import dao.StudentDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SchoolYear;
import model.Student;

/**
 *
 * @author Le Hong Quan
 */
public class ListController extends HttpServlet {

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
        List<SchoolYear> listSchoolYears = new SchoolYearDao().getAll();
        List<Student> listStudents = new StudentDAO().getAll();
        request.setAttribute("listSchoolYears", listSchoolYears);
        request.setAttribute("listStudents", listStudents);
        request.getRequestDispatcher("list.jsp").forward(request, response);
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
        int schoolYearId = Integer.parseInt(request.getParameter("schoolYear"));
         List<SchoolYear> listSchoolYears = new SchoolYearDao().getAll();
        List<Student> listStudents = new StudentDAO().getAllBySchoolYearId(schoolYearId);
        request.setAttribute("listSchoolYears", listSchoolYears);
        request.setAttribute("listStudents", listStudents);
        request.setAttribute("schoolYearId", schoolYearId);
        request.getRequestDispatcher("list.jsp").forward(request, response);

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
