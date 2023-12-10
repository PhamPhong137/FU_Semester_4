<%-- 
    Document   : list
    Created on : Mar 15, 2022, 11:00:58 PM
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
                <td>Event Id</td>
                <td>Content</td>
                <td>Occur</td>
                <td>Is Enable</td>
                <td>Owner</td>

            </tr>
            <c:forEach items="${events}" var="c">
                <tr>
                    <td style="text-align: right">${c.getId()}</td>
                    <td>${c.getContent()}</td>
                    <td>${c.getDate()}</td>
                    <td>
                        <c:choose>
                            <c:when test="${c.isIsEnabled() == true}">
                                <input type="checkbox" checked="checked" onclick="return false">
                            </c:when>    
                            <c:otherwise>
                                <input type="checkbox" checked="" onclick="return false">
                            </c:otherwise>
                        </c:choose>
                    </td>

                    <td>${c.getCreated_by()}</td>

                </tr>
            </c:forEach>

        </table>
    </body>
</html>
