<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : newjsp1
    Created on : Jul 17, 2021, 8:10:26 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="0">
            <thead>
                <tr>
                    <th>Entry ID</th>
                    <th>Entry Title</th>
                    <th>Go Detail</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="o" items="${listE}">
                    <tr>
                        <td>${o.getEntryID()}</td>
                        <td>${o.title}</td>
                        <td>
                            <a href="detail?ID=${o.getEntryID()}">Detail</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
