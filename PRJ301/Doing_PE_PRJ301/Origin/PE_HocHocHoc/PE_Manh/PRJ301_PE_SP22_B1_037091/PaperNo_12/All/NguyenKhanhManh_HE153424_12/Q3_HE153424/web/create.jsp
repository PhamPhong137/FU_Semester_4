<%-- 
    Document   : create
    Created on : Mar 10, 2022, 10:59:57 PM
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
            Id: <input type="text" name="id"><br>
            Name: <input type="text" name="name"><br>
            Dob: <input type="date" name="date"><br>
            Gender:
            <input type="radio" name="gender" value="male"> Male
            <input type="radio" name="gender" value="female"> Female <br>
            Certificates:<br>
            <c:forEach items="${Cetificates}" var="c">
                <input type="checkbox" name="cer" value="${c.getCid()}">
                ${c.getCname()} at 
                <input type="Date" name="date"><br>
            </c:forEach>
                <input type="submit" value="Save">
        </form>
    </body>
</html>
