<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : report
    Created on : Mar 27, 2021, 8:17:30 AM
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
        <table >
            <c:forEach var="o" items="${listE}">
                <tr>
                    <td>+${o.content}</td>

                </tr>
                <c:forEach var="o1" items="${o.list}">
                    <tr>
                        <td>
                            -${o1.content} <br>
                        </td>  
                    </tr>
                </c:forEach>
                <tr>
                    <td>
                        new record for event ${o.id}
                    </td>
                <form action="report" method="POST">
                    <td>
                        <input type="text" name="${o.id}" value="" />
                    </td>
                    <td>
                        <input type="submit" value="Submit" />
                    </td>
                </form>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
