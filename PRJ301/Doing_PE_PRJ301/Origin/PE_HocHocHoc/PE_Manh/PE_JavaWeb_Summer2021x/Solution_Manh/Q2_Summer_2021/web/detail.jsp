<%-- 
    Document   : detial
    Created on : Mar 16, 2022, 7:17:42 PM
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
        <b>Entry's info</b> <br>
        EntryID: ${entries.getId()}<br>
        EntryTitle: ${entries.getTitle()}<br>
        EntryContent: ${entries.getEntryContext()}<br>
        Date modified: ${entries.getDateModified()}<br><br>
       <b>Comments of the entry</b>
        <table >
            <tr style="text-align: center">
                <td><b>Comment ID</b></td>
                <td><b>Comment Content</b></td>
                <td></td>
            </tr>
            
            <c:forEach items="${comments}" var="c">
                <tr>
                    <td>${c.getId()}</td>
                    <td>${c.getComment()}</td>
                    <td><a href="delete?id=${c.getId()}">delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
