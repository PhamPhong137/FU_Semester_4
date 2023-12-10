<%-- 
    Document   : Login
    Created on : Nov 1, 2023, 5:20:34 PM
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
        ${mes}
        <c:if test="${sessionScope.acc==null}">
            <form action="login" method="post">
                Username: <input type="text" name="u"><br>
                Password: <input type="text" name="p"><br>
                <input type="submit" value="Login"><br>
            </form>
        </c:if>
    </body>
</html>
