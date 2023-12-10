<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : list
    Created on : Mar 27, 2021, 8:03:08 AM
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
        accountid: ${sessionScope.account.user}
        <table border="1" style="border-collapse: collapse;">
            <thead>
                <tr>
                    <th>id</th>
                    <th>content</th>
                    <th>date</th>
                    <th>created_by</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="o" items="${listE}">
                <tr>
                    <td>${o.id}</td>
                    <td>${o.content}</td>
                    <td>${o.getDateFormat()}</td>
                    <td>${o.createdby}</td>
                </tr>
            </c:forEach>

        </tbody>
    </table>

</body>
</html>
