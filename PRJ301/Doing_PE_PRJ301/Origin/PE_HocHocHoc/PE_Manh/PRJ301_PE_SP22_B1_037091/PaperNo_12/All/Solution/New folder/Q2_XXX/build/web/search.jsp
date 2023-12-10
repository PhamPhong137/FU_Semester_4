<%-- 
    Document   : search
    Created on : Apr 26, 2022, 3:07:29 PM
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
            Account: 
            <select name = "account">
                <c:forEach items="${Accouts}" var="a">
                    <option ${(user.equals(a.getUsername()))?"selected = \"selected\"":""}
                        value="${a.getUsername()}">${a.getDisplayname()}</option>    
                </c:forEach>

            </select>
            <input type="submit" value="Search">
        </form>
        <c:if test="${employees != null}">
            <table border = "1">
                <tr>
                    <td>Member Id</td>
                    <td>Name</td>
                    <td>Dob</td>
                    <td>Gold Member</td>
                </tr>
                <c:forEach items="${employees}" var="e">
                    <tr>
                        <td>${e.getEmpid()}</td>
                        <td>${e.getEmpname()}</td>
                        <td>${e.getEmpdob()}</td>
                        <td>
                            <c:choose>
                                <c:when test="${e.isEmpgender() == true}">
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
        </c:if>


    </body>
</html>
