<%-- 
    Document   : add
    Created on : Nov 4, 2023, 1:19:25 AM
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
        <form action="add" method="post">
            <table>
                <tr>
                    <td>Paper ID:</td>
                    <td><input type="text" name="paperid"></td>
                </tr>
                <tr>
                    <td>Title:</td>
                    <td><input type="text" name="title"></td>
                </tr>
                <tr>
                    <td>Date:</td>
                    <td><input type="text" name="date">(yyyy-MM-dd)</td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <c:forEach items="${listA}" var="a">
                            <input type="checkbox" name="author" value="${a.id}">${a.name}<br/>
                        </c:forEach>
                    <input type="submit" value="Save">
                    </td>
                </tr>

            </table>
        </form>
    </body>
</html>
