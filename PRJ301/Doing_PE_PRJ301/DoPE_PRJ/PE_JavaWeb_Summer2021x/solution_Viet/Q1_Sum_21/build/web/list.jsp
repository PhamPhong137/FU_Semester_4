<%-- 
    Document   : list
    Created on : Apr 27, 2022, 7:44:23 PM
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
        <form action="employees" method="POST">
            Name:
            <input type="text" name="name"><br>
            Sex
            <input type="radio" name="gender" value="male" checked="checked"> Male
            <input type="radio" name="gender" value="female"> Female
            <br>
            <input type="submit" value="Submit">
        </form>

        <c:choose>
            <c:when test="${employees == null}">
                There are ......
            </c:when>    
            <c:otherwise>
                List of employees<br>
                <c:forEach items="${employees}" var="e">
                    ${e.getName()} - ${e.getGender()}<br>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </body>
</html>
