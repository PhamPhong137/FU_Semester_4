<%-- 
    Document   : ListJobs
    Created on : Mar 18, 2022, 9:41:36 AM
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
        <table border = "1">
            <tr>
                <td>Job ID</td>
                <td>Job Name</td>
                <td>Job Salary</td>
                <td>Hire Date</td>
                <td>Activated(Yes/No)</td>
            </tr>
            <c:forEach items="${jobs}" var="j">
                <tr>
                    <td><a href="#">${j.id}</a></td>
                    <td><a href="#">${j.name}</a></td>
                    <td>${j.salary}000</td>
                    <td>${j.date}</td>
                    
                    <td><c:choose>
                        <c:when test="${j.activated}">
                            Yes
                        </c:when>
                        <c:otherwise>
                            No
                        </c:otherwise>
                    </c:choose>
                    </td>

                </tr>
            </c:forEach>
        </table>
    </body>
</html>
