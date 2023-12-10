<%-- 
    Document   : list
    Created on : Mar 10, 2022, 11:37:20 PM
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
        Session of ${user.getUser()} <br>
        <table border = "1">
            <tr>
                <td>Id</td>
                <td>Content</td>
                <td>Created Date</td>
                <td>Is Urgent</td>
            </tr>
            <c:forEach items="${comments}" var="c">
                <tr>
                    <td>${c.getId()}</td>
                    <td>${c.getContent()}</td>
                    <td>${c.getDate()}</td>
                    <td>${c.isUrgent()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
