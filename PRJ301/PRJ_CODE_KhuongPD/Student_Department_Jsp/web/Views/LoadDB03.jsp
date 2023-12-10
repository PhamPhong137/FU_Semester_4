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
        
        <form action="LoadDB02" method="post">
            <select name="nrpp">
                <c:forEach items="${nrppArr}" var="nr">
                    <option value="${nr}" ${nr==page.nrpp?"selected":""} >${nr}</option>
                </c:forEach>
            </select>

          
            <input type="text" name="index" value="${page.index}" hidden >
            <input type="text" name="totalPage" value="${page.totalPage}" hidden >

            <c:if test="${page.index!=0}">
                <input type="submit" name="btnHome" value="Home">
                <input type="submit" name="btnPre" value="Pre">
            </c:if>

            <c:forEach var="i" begin='${page.pageStart}' end='${page.pageEnd}'>
                <input type="submit" name="btn${i}" value="${i+1}">
            </c:forEach>

            <c:if test="${page.index<page.totalPage-1}">
                <input type="submit" name="btnNext" value="Next">
                <input type="submit" name="btnEnd" value="End">

            </c:if>
        </form>
    </body>
</html>
