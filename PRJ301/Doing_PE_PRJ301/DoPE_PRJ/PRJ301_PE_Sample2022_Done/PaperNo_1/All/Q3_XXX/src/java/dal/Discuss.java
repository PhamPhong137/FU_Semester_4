/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author PC-Phong
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import models.*;

public class Discuss extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao d = new Dao();
        PrintWriter out = response.getWriter();
        List<Account> listAcc = d.getAllAcc();
        List<Comment> com = d.getAllComment();
        List<Thread0> thr = d.getAllThread0();
        for (int i = 0; i < com.size(); i++) {
            com.get(i).setUid(com.get(i).getUid().substring(0, 1).toUpperCase()+com.get(i).getUid().substring(1, 2).toLowerCase()+" "+com.get(i).getUid().substring(2, 3).toUpperCase());
        }
        request.setAttribute("listAcc", listAcc);
        request.setAttribute("com", com);
        request.setAttribute("thr", thr);

        request.getRequestDispatcher("Discuss.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Dao d = new Dao();
        int tid = -1;
        String userid = request.getParameter("o");
        String comment = request.getParameter("comment");
        for (Thread0 thr : d.getAllThread0()) {
            if (request.getParameter("th" + thr.getId()) != null) {
                tid = thr.getId();
            }
        }

        d.Insert(comment, userid, tid);
         doGet(request, response);
    }

}
