<%-- 
    Document   : list
    Created on : Aug 30, 2023, 11:00:32 PM
    Author     : PC-Phong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Student" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of students</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>DOB</th>
                <th>GENDER</th>
            </tr>
            <% 
            List<Student> list = (List<Student>) request.getAttribute("data");
            for(Student i:list){
            %>
            <tr>
                <td><%= i.getId() %></td>
                <td><%= i.getName()%></td>
                <td><%= i.getDob()%></td>
                <td>
                    <img <%=(i.isGender()?"src=images/male.png":"src=images/female.png") %> width="30px" height="30px" alt="alt"/>
                </td>
            </tr>
 
            <%
                }
            %>

        </table>


    </body>
</html>
