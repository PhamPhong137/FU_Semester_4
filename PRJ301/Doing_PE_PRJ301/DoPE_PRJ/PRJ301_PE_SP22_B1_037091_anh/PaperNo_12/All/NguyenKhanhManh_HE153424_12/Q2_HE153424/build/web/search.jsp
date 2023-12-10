<%-- 
    Document   : serach
    Created on : Mar 19, 2022, 2:00:17 PM
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
            Acount: 
            <select name = "displayname">
                <c:forEach items="${accounts}" var="a">
                    <option ${(a.getDisplayname() eq displayName)?"selected = \"selected\"":""}
                        value="${a.getDisplayname()}">${a.getDisplayname()}</option>    
                </c:forEach>
            </select>
            <input type="submit" value="Search">
        </form>
        <c:choose>
            <c:when test="${employees != null}">
                <table border = "1">
                    <tr>
                        <td>Employee Id</td>
                        <td>Name</td>
                        <td>DOB</td>
                        <td>Gender</td>
                    </tr>
                    <c:forEach items="${employees}" var="e">
                        <tr>
                            <td>${e.getId()}</td>
                            <td>${e.getName()}</td>
                            <td>${e.getDate()}</td>

                            <td><c:choose>
                                    <c:when test="${e.isGender()}">
                                        Male
                                    </c:when>
                                    <c:otherwise>
                                        Female
                                    </c:otherwise>
                                </c:choose>
                            </td>

                        </tr>
                    </c:forEach>
                </table>
            </c:when>
        </c:choose>

    </body>
</html>
