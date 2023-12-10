<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : List
    Created on : Mar 17, 2021, 6:30:46 PM
    Author     : trinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Mra</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>DOB</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="o" begin="1" end="5">
                    <tr>
                        <td>1001</td>
                        <td>MRX</td>
                        <td>2000-01-01</td>
                        <td>Male</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </body>
</html>
