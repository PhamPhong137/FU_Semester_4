<%-- 
    Document   : search
    Created on : Apr 24, 2022, 3:28:51 PM
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
        <form action="search" method="POST">
            Authors:
            <select name = "aid">
                <c:forEach items="${authors}" var="a">
                    <option ${(a.getId() == aid)?"selected = \"selected\"":""}
                        value="${a.getId()}">${a.getName()}</option>    
                </c:forEach>
            </select>
            <input type="submit" value="Search">
        </form>
        <c:if test="${papers != null}">
            <table border = "1">
                <tr>
                    <td>Paper ID</td>
                    <td>Title</td>
                    <td>Published Date</td>
                </tr>
                <c:forEach items="${papers}" var="p">
                    <tr>
                        <td>${p.getPid()}</td>
                        <td>${p.getTitle()}</td>
                        <td>${p.getPublish()}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

    </body>
</html>
