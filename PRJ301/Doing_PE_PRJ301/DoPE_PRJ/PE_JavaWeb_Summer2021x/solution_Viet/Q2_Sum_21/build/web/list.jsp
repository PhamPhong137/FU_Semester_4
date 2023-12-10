<%-- 
    Document   : list
    Created on : Apr 27, 2022, 8:22:09 PM
    Author     : Admin
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
        <table>
            <tr>
                <td>Entry ID</td>
                <td>Entry Title</td>
                <td>Go Detail</td>
            </tr>
            <c:forEach items="${entries}" var="e">
                <tr>
                <td>${e.getId()}</td>
                <td>${e. getTitle()}</td>
                <td><a href="detail?ID=${e.getId()}">Detail</a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
