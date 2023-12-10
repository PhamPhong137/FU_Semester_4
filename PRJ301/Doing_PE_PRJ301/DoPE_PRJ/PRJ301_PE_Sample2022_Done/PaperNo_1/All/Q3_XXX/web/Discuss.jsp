<%-- 
    Document   : Discuss
    Created on : Nov 2, 2023, 1:18:45 AM
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
        <c:if test="${sessionScope.acc==null}">
            <h1>Access denied</h1>
        </c:if>
        <c:if test="${sessionScope.acc!=null}">
            <c:forEach items="${thr}" var="th">
                <p>Thread: ${th.name}</p>
                <c:forEach items="${com}" var="c">
                    <c:if test="${th.id==c.tid}">
                        <p>${c.uid}: ${c.title}</p>
                    </c:if>
                </c:forEach>

                <form action="discuss" method="post">
                    <input type="text" name="o" value="${sessionScope.acc.id}" hidden>
                    <input type="text" name="tid" value="${th.id}" hidden>

                    <input type="text" name="comment">
                    <input type="submit" value="Save" name="th${th.id}">
                </form>
            </c:forEach>
        </c:if>






    </body>
</html>
