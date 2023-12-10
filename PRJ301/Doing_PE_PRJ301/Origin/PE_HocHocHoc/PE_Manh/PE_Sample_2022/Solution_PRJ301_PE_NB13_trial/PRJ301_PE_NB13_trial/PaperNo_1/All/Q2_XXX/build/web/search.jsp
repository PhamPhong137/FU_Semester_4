<%-- 
    Document   : search
    Created on : Jun 26, 2023, 10:55:42 AM
    Author     : Khanh Manh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="search" method="POST">
            Name <input type="text" name="name" value="${search}"> 
            <input type="submit" value="Search">
        </form>
        <c:if test="${students.size() >0 }">
            <table border = "1">
            <tr>
                <td>sid</td>
                <td>name</td>
                <td>gender</td>
                <td>dob</td>
            </tr>
            <c:forEach items="${students}" var="s">
                <tr>
                    
                    <td>${s.getSid()}</td>
                    <td>${s.getName()}</td>
                    <td>${s.isGender()}</td>
                    <td>${s.getDob()}</td>

                </tr>
            </c:forEach>
        </table>
        </c:if>
    </body>
</html>
