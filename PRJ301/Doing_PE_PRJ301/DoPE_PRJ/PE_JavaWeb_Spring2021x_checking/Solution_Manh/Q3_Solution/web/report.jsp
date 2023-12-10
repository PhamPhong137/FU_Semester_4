<%-- 
    Document   : report
    Created on : Mar 16, 2022, 4:34:46 PM
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
        <c:forEach items="${events}" var="e">
            +${e.getContent()}<br>
            <c:forEach items="${reports}" var="r">
                <c:if test="${e.id == r.eid}">
                    -${r.getContent()}<br>
                </c:if>

            </c:forEach>
            <form action="report" method="POST">
                new record for event ${e.id}:<input type="text" name="content"> 
                <input type="hidden" name="id" value="${e.id}" >
                <input type="submit" value="Submit">
                <br>
            </form>



        </c:forEach>


    </body>
</html>
