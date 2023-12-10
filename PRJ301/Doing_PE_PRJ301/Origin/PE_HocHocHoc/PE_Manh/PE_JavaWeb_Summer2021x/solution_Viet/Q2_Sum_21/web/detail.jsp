<%-- 
    Document   : detail
    Created on : Apr 27, 2022, 8:40:13 PM
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
        <h2><b>Entry's info</b></h2>
        <h2>EntryID:${entries.getId()}</h2>
        <h2>EntryTitle:${entries.getTitle()}</h2>
        <h2>EntryContent:${entries.getEntryContext()}</h2>
        <h2>Date modified:${entries.getDateModified()}</h2>
        <h2><b>Comments of the entry</b></h2>
        <table>
            <tr>
                <td><b>Comment ID</b></td>
                <td><b>Comment Content</b></td>
                <td></td>
            </tr>
            
            <c:forEach items="${comments}" var="c">
                <tr>
                <td>${c.getId()}</td>
                <td>${c.getComment()}</td>
                <td><a href="delete?ID=${c.getId()}">delete</a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
