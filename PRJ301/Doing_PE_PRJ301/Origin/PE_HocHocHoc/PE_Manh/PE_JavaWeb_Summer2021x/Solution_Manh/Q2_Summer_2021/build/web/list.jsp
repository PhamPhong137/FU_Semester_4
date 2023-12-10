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
        
        <table >
            <tr style="text-align: center">
                <td><b>Entry Id</b></td>
                <td><b>Entry Title</b></td>
                <td><b>Go Detail</b></td>
            </tr>
            <c:forEach items="${entries}" var="e">
                <tr>
                    <td>${e.id}</td>
                    <td>${e.title}</td>
                    <td><a href="detail?id=${e.id}">Detail</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
