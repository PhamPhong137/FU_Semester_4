<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Show
    Created on : Mar 17, 2021, 6:38:25 PM
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
        <form action="certificate">
            <table border="1">
                <tr>
                    <th></th>
                        <c:forEach begin="1" end="4" var="o">
                        <th>JAVA OOP</th>
                        </c:forEach>
                </tr>
                <c:forEach var="o" begin="1" end="4">
                    <tr>
                        <td>mr X</td>
                        <td>
                            <input type="checkbox" checked>
                        </td>
                        <td>
                            <input type="checkbox" checked>
                        </td>
                        <td>
                            <input type="checkbox" checked>
                        </td>
                        <td>
                            <input type="checkbox" checked>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" value="Save" />
        </form>
    </body>
</html>
