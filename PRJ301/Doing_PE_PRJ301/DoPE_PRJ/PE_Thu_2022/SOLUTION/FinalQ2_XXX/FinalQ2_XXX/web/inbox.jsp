<%-- 
    Document   : inbox
    Created on : Mar 9, 2022, 9:24:48 PM
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
        <a href="create">Create Message</a>
        <table border = "1">
            <thead>
                <tr>
                    <td>Title</td>
                    <td>From</td>
                    <td>At</td>
                    <td>Seen</td>
                </tr>
            </thead>

            <tbody>

                <c:forEach items="${messages}" var="m">
                    <tr>    
                        <td> <a href="message?id=${m.getMassId()}" >${m.getTitle()}</a> </td>
                        <td>${m.getFrom()}</td>
                        <td>${m.getTime().substring(0, 19)}</td>
                        <c:choose>
                            <c:when test="${m.isIsRead()}">
                                <td><img src="eye.png"></td>
                            </c:when>    
                            <c:otherwise>
                            <td></td>
                            </c:otherwise>
                        </c:choose>
                       
                    </tr>
                </c:forEach>

            </tbody>


        </table>
    </body>
</html>
