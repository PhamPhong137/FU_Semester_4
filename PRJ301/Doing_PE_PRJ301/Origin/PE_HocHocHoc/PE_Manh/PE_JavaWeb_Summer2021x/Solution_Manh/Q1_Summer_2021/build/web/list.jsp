<%-- 
    Document   : list
    Created on : Mar 16, 2022, 6:00:06 PM
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
            Name <input type="text" name="name"><br>
            Sex <input type="radio" name="gender" value="male" checked="checked"> Male
            <input type="radio" name="gender" value="female"> Female<br>
            <input type="submit" value="Submit">
        </form>


        <c:choose>
            <c:when test="${employees == null}">
                <H2>There are no employees on the list yet</H2>
                </c:when>    
                <c:otherwise>
                <H2>List of employees</H2>
                    <c:forEach items="${employees}" var="e">
                        ${e.name}-
                    <c:choose>
                        <c:when test="${e.gender == true}">
                            Male
                        </c:when>    
                        <c:otherwise>
                            Female
                        </c:otherwise>
                    </c:choose>
                            <br>
                </c:forEach>
            </c:otherwise>
        </c:choose>

    </body>
</html>
