<%-- 
    Document   : Search
    Created on : Oct 9, 2023, 3:39:46 AM
    Author     : PC-Phong
--%>

<%@page import="DAL.*"%>
<%@page import="Models.*"%>
<%@page import="java.util.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Search student by Gender</h1>
        <%  DAO d = (DAO)request.getAttribute("dao"); %>   
        <table>
            <%for(Student s : d.getStdg()){ %>
            <tr>
                <td><%= s.getId()%></td>
                <td><%= s.getName()%></td>
                <td><%= s.isGender()?"Male":"Female"%></td>
                <td><%=d.getDept().get(s.getDepartId()).getName()%></td>
                <td><%= s.getAge()+" tuổi "%></td>
                <td><%= s.getGpa()%></td>
                <td><%= s.getAdd()%></td>
                <td><%= s.getImg()%></td>
                <td><%= s.getDob()%></td>
            </tr>
            <%}%>
        </table>

        

    </body>
</html>
