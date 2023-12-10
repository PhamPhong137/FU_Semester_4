/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAL.*;
import Models.*;
import java.util.Map;

/**
 *
 * @author PC-Phong
 */
public class LoadDB extends HttpServlet {

    DAO d;

    public void init() {
        d = new DAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoadDB</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadDB at " + request.getContextPath() + "</h1>");
            d.loadDB();
            String stUpdate = "";
            Object o1 = request.getAttribute("update");
            stUpdate = (o1 != null) ? (o1 + "") : "";
            Student stU = null;
            for (Student st : d.getStd()) {
                if (st.getId().equals(stUpdate)) {
                    stU = st;
                }
            }

            String s = "<table>";
            for (Student st : d.getStd()) {
                s += "<tr>";
                s += "<td>" + st.getId() + "</td>";
                s += "<td>" + st.getName() + "</td>";
                s += "<td>" + (st.isGender() ? "Male" : "Female") + "</td>";
                s += "<td><input type='checkbox'" + (st.isGender() ? "checked" : "") + ">Male/Female</td>";

                s += "<td>";
                s += "<input type='radio' name='gender" + st.getId() + "' " + (st.isGender() ? "checked" : "") + "> Male";
                s += "<input type='radio' name='gender" + st.getId() + "' " + (st.isGender() ? "" : "checked") + "> Female";
                s += "</td>";

                s += "<td>" + st.getDepartId() + "</td>";
                s += "<td>" + d.getDept().get(st.getDepartId()).getName() + "</td>";

                s += "<td>" + st.getAge() + "</td>";
                s += "<td>" + st.getAdd() + "</td>";
                s += "<td>" + st.getImg() + "</td>";
                s += "<td>" + st.getDob() + "</td>";
                s += "<td><a href = 'LoadDB?type=0&id=" + st.getId() + "'>Update</a></td>";
                s += "<td><a href = 'LoadDB?type=1&id=" + st.getId() + "'>Delete</a></td>";
                s += "</tr>";
                s += "</tr>";
            }
            s += "</table>";
            out.println(s);
            String form = "";
            form += "<form action=\"LoadDB\" method=\"post\">\n"
                    + "            <table>\n"
                    + "                <tr>\n"
                    + "                    <td>ID</td>\n"
                    + "                    <td><input type=\"text\" name=\"id\" value='" + (stU == null ? "" : stU.getId()) + "'></td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>Name</td>\n"
                    + "                    <td><input type=\"text\" name=\"name\" value='" + (stU == null ? "" : stU.getName()) + "'></td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>Gender</td>\n"
                    + "                    <td>\n"
                    + "                        <input type=\"radio\" name=\"gender\" value=\"M\" " + ((stU == null || stU.isGender()) ? "checked" : "") + ">Male\n"
                    + "                        <input type=\"radio\" name=\"gender\" value=\"F\"" + ((stU != null && !stU.isGender()) ? "checked" : "") + ">Female\n"
                    + "                    </td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>Department</td>\n"
                    + "                    <td><select name=\"departId\">";
            for (Map.Entry<String, Department> en : d.getDept().entrySet()) {
                String key = en.getKey();
                Department value = en.getValue();
                form += "<option value ='" + key + "'" + (stU == null ? "" : stU.getDepartId().equals(key) ? "selected" : "") + ">";
                form += value.getName();
                form += "</option>";
            }

            form += "</select> </td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>Age</td>\n"
                    + "                    <td><input type=\"text\" name=\"age\" value='" + (stU == null ? "" : stU.getAge()) + "'></td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>GPA</td>\n"
                    + "                    <td><input type=\"text\" name=\"gpa\" value='" + (stU == null ? "" : stU.getGpa()) + "'></td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>Id</td>\n"
                    + "                    <td><textarea name='add'>" + (stU == null ? "" : stU.getAdd()) + "</textarea> </td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>Image</td>\n"
                    + "                    <td><input type=\"text\" name=\"img\" value='" + (stU == null ? "" : stU.getImg()) + "'></td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>Date of birth</td>\n"
                    + "                    <td><input type=\"date\" name=\"dob\" value='" + (stU == null ? "2000-01-01" : (stU.getDob() == null ? "2005-01-01" : stU.getDob())) + "'></td>\n"
                    + "                </tr>"
                    + "\n"
                    + "            </table>\n"
                    + "            <input type=\"submit\" name=\"btnInsert\" value=\"Insert\">\n"
                    + "            <input type=\"submit\" name=\"btnUpdate\" value=\"Update\">\n"
                    + "        </form>";
            out.println(form);
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object obj = request.getParameter("type");
        Object o2 = request.getParameter("id");
        if (obj != null) {
            if ((obj + "").equals("0")) {
                if (o2 != null) {
                    request.setAttribute("update", o2 + "");
                } else {
                    request.removeAttribute("update");
                }
            }
            //update
        }
        if ((obj + "").equals("1")) {
            if (o2 != null) {
                d.Delete(o2 + "");
            }
            //delete

        }
        d.loadDB();
        request.setAttribute("dao", d);
        request.getRequestDispatcher("Views/LoadDB.jsp").forward(request, response);
        
       // processRequest(request, response);
       
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object o1 = request.getParameter("btnInsert");
        Object o2 = request.getParameter("btnUpdate");

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String departId = request.getParameter("departId");
        String add = request.getParameter("add");
        String img = request.getParameter("img");
        Object obj = request.getParameter("gender");
      //  boolean gender = obj != null && ((obj + "")).equals("M");
        boolean gender = obj != null;
        int age = Integer.parseInt(request.getParameter("age"));
        float gpa = Float.parseFloat(request.getParameter("gpa"));
        String dob = request.getParameter("dob");

        boolean checkUpdate = false;
        for (Student st : d.getStd()) {
            if (st.getId().equals(id)) {
                checkUpdate = true;
                break;
            }
        }
        if (o1 != null && !checkUpdate) {
            d.Insert(id, name, gender, departId, age, gpa, add, img, dob);
        }
        if (o2 != null && checkUpdate) {
            d.Update(id, name, gender, departId, age, gpa, add, img, dob);
        }
        doGet(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
