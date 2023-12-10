<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : list
    Created on : Mar 27, 2021, 7:40:16 AM
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
        <table border="1" style="border-collapse: collapse;">
            <thead>
                <tr>
                    <th>Event ID</th>
                    <th>Content</th>
                    <th>Occur</th>
                    <th>is Enable</th>
                    <th>Owner</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="o" items="${listE}">
                    <tr>
                        <td>${o.id}</td>
                        <td>${o.content}</td>
                        <td>${o.getDateFormat()}</td>
                        <td>
                            <input type="checkbox" name="" ${o.isEnable?"checked":""} value="ON" />
                        </td>
                        <td>
                            ${o.createdby}
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </body>
</html>
