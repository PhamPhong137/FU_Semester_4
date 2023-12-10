<%-- 
    Document   : Search
    Created on : Nov 4, 2023, 10:22:51 PM
    Author     : PC-Phong
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
        <form action="search" method="post">
            Account: 
            <select name="op">
                <c:forEach items="${acc}" var="a">
                    <option value="${a.user}">${a.displayname}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Search">
        </form>
        <c:if test="${listEm!=null}">
            <table border="1" >
                <tr>
                    <td>Employee Id</td>
                    <td>Name</td>
                    <td>Dob</td>
                    <td>Gender</td>
                </tr>
                <c:forEach items="${listEm}" var="e">
                    <tr>
                        <td>${e.empid}</td>
                        <td>${e.empname}</td>
                        <td>${e.empdob}</td>
                        <td>${e.empgender?"Male":"Female"}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>


    </body>
</html>
