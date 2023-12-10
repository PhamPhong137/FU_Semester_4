<%-- 
    Document   : SearchbyDepartment
    Created on : Oct 11, 2023, 7:49:36 AM
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Search student by Text</h1>
        <%  DAO d = (DAO)request.getAttribute("dao"); %>       
        <table>
            <%for(Student s : d.getStdbt()){ %>
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
