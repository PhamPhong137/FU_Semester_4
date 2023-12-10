<%-- 
    Document   : Search
    Created on : Oct 2, 2023, 1:43:44 PM
    Author     : PC-Phong
--%>
<%@page import="DAL.*"%>
<%@page import="Models.*"%>
<%@page import="java.util.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${sql}<br/>
        <form action="LoadDB" method="post">
            <input type="text" name="search"/>
            <br>
            <c:forEach items="${requestScope.dao}" var="de">
                <input type="checkbox"  name="chk${de.key}"value="${de.key}"> ${de.value} <br/>
            </c:forEach>
                <input type="submit" value="Search"/>


        </form>
    </body>
</html>
