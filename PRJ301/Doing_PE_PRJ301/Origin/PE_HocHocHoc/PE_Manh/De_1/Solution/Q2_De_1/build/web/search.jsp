<%-- 
    Document   : search
    Created on : Mar 17, 2022, 9:58:45 PM
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
            <select name="id">
                <c:forEach items="${author}" var="a">
                    <option ${(a.id == id)?"selected = \"selected\"":""}
                        value="${a.id}" >${a.name}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Search">
        </form>
        <c:choose>
            <c:when test="${papers!=null}">
                <table border = "1">
                    <tr>
                        <td>Paper Id</td>
                        <td>Title</td>
                        <td>Published Date</td>
      
                    </tr>
                    <c:forEach items="${papers}" var="p">
                        <tr>
                            <td>${p.pid}</td>
                            <td>${p.title}</td>
                            <td>${p.publish}</td>
                            
                        </tr>
                    </c:forEach>
                </table>
            </c:when>

        </c:choose>

    </body>
</html>
