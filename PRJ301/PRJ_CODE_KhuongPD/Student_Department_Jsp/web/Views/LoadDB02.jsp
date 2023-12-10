<%-- 
    Document   : LoadDB02
    Created on : Oct 11, 2023, 4:05:28 PM
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
        <table>
            <c:forEach items="${dao.std}" var="s" begin="${page.begin}" 
                       end ="${page.end-1}">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.gender}</td>
                    <td>${dao.dept[s.departId].name}</td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${page.index!=0}">
            <span class="btn"><a href="LoadDB01?index=${0}">Home</a></span>
            <span class="btn"><a href="LoadDB01?index=${page.index-1}">Pre</a></span>
        </c:if>
            
        <c:forEach var="i" begin='${page.pageStart}' end='${page.pageEnd}'>
            <span class="btn"><a href="LoadDB01?index=${i}">${i+1}</a></span>
        </c:forEach>
            
        <c:if test="${page.index<page.totalPage-1}">
            <span class="btn"><a href="LoadDB01?index=${page.index+1}">Next</a></span>
            <span class="btn"><a href="LoadDB01?index=${page.totalPage-1}">End</a></span>
        </c:if>
    </body>
</html>
