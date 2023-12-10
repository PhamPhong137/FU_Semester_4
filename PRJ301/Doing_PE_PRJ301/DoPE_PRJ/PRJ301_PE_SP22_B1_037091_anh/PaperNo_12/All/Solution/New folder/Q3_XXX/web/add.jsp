<%-- 
    Document   : add
    Created on : Apr 26, 2022, 4:15:02 PM
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
        <form action="add" method="POST">
            ID: <input type="text" name="id"><br>
            Name: <input type="text" name="name"><br>
            Dob: <input type="date" name="date"><br>
            Gender:
            <input type="radio" name="gender" value="male" checked> Male
            <input type="radio" name="gender" value="female"> Female <br>
 
            <c:forEach items="${Skills}" var="c">
                <input type="checkbox" name="cer" value="${c.getCid()}">
                ${c.getCname()} with 
                <input type="text" name="date"><br>
            </c:forEach>
                <input type="submit" value="Save">
        </form>
    </body>
</html>
