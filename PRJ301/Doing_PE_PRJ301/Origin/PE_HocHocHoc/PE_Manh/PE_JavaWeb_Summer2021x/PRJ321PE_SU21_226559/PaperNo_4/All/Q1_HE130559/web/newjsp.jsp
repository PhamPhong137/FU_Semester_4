<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : newjsp
    Created on : Jul 17, 2021, 7:39:06 AM
    Author     : ADMIN
--%>

<%@page import="java.util.List"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form action="employees" method="POST">
            Name <input type="text" name="name" value="" /> <br>
            Sex  <input type="radio" name="gender" value="Male" checked /> Male
            <input type="radio" name="gender" value="Female" /> Female
            <br>
            <input type="submit" value="Submit" />
        </form>
        ${alert}
        <c:forEach var="o" items="${listS}">
            ${o.name}  
            -
            ${o.gender} <br>
        </c:forEach>
    </body>
</html>
