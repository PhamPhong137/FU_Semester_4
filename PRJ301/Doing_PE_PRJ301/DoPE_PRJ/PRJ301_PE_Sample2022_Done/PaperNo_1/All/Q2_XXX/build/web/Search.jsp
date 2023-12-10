
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="search" method="post">
            Name <input type="text" name="name"> 
            <input type="submit" value="Search">
        </form>
        <c:if test="${list!=null}">
            <table border="1">
                <tr>
                    <td>sid</td>
                    <td>name</td>
                    <td>gender</td>
                    <td>dob</td>
                </tr>
                <c:forEach items="${list}" var="list">
                    <tr>
                        <td>${list.sid}</td>
                        <td>${list.name}</td>
                        <td>${list.gender?"1":"0"}</td>
                        <td>${list.dob}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
