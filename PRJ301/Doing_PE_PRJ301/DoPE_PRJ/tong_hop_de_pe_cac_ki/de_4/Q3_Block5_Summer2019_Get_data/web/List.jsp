<%-- 
    Document   : List
    Created on : 30-Aug-2019, 23:00:50
    Author     : Hoan toan hanh phuc 
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="c" class="dao.ListDAO" scope="request"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table align="center" border="1px solid">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Created Date</th>
                <th>Skills</th>
            </tr>
            <c:forEach items="${list}" var="x">
                <tr>
                    <td>${x.cid}</td>
                    <td>${x.name}</td>
                    <td>${x.gender}</td>
                    <td>${x.date}</td>
                    <td>
                        <c:forEach items="${x.skilll}" var="y">
                        <ul>${y.skills}</ul>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
