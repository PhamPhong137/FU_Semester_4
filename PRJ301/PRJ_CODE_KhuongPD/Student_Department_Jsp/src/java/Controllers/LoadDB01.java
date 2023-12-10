/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.DAO;
import Models.Paging;
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
public class LoadDB01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO.INSTANCE.loadDB();
        request.setAttribute("dao", DAO.INSTANCE);
        int nrpp = 1; // update later
        int index = -1;
        try {
            index = Integer.parseInt(request.getParameter("index"));
        } catch (Exception e) {
        }
        Paging p = new Paging(nrpp, index, DAO.INSTANCE.getStd().size());
        p.calc();
        request.setAttribute("page", p);
        request.getRequestDispatcher("Views/LoadDB02.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
