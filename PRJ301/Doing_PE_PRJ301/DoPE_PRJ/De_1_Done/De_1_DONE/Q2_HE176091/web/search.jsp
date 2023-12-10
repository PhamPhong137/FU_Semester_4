<%-- 
    Document   : search
    Created on : Nov 4, 2023, 12:40:18 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="search" method="post">
            Arthor: 
            <select name="author">
                <c:forEach items="${listA}" var="a">
                    <option ${(author eq a.name) ? "selected" : ""}>${a.name}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Search">
        </form>

        <table border="1">
            <tr>
                <td>Paper ID</td>
                <td>Titile</td>
                <td>Published Date</td>
            </tr>
            <c:forEach items="${list}" var="l">
                <tr>
                    <td>${l.id}</td>
                    <td>${l.title}</td>
                    <td>${l.publisheddate}</td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
