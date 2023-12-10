<%-- 
    Document   : index
    Created on : Mar 18, 2022, 9:21:57 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function doCreate(){
                window.location.href = "add";
            }
            
        </script>
    </head>
    <body>
        <form action="search" method="post">
            Select student's major
            <select name="major">
                <option  value="all">All</option>
                <c:forEach items="${studentss}" var="s">
                <option 
                    <c:forEach items="${studentsss}" var="ss">
                        ${(s.getMajor() eq ss.getMajor())?"selected = \"selected\"":""}
                    </c:forEach>
                    value="${s.getMajor()}">${s.getMajor()}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Search">
        </form>
        <table border = "1">
            <tr>
                <td>RollNo</td>
                <td>Major</td>
                <td>FullName</td>
                <td>City</td>
                <td>Gender</td>
            </tr>
            <c:forEach items="${students}" var="s">
                <tr>
                    <td>${s.getRollNo()}</td>
                    <td>${s.getMajor()}</td>
                    <td>${s.getFullName()}</td>
                    <td>${s.getCity()}</td>

                    <td><c:choose>
                            <c:when test="${s.isGender()}">
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
        <input type="button" onclick="doCreate()" value="Add new">
    </body>
</html>
