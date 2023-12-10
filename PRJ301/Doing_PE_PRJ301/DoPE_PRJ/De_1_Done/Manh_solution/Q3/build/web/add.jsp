<%-- 
    Document   : add
    Created on : Apr 24, 2022, 4:06:12 PM
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
        <form action="add" method="post">
            <table >
                <tr>
                    <td>Paper Id</td>
                    <td><input type="text"  name="id" value="${paper.pid}"> </td>

                </tr>
                <tr>
                    <td>Title:</td>
                    <td><input type="text" name="title" value="${paper.title}"></td>

                </tr>
                <tr>
                    <td>Date</td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="<%=new java.util.Date()%>" var="nowDate" />
                <input type="text" name="date"  pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" title="Format date yyyy-mm-dd" value="${paper.publish}">(yyyy-MM-dd)
                </td>

                </tr>
                <c:forEach items="${authors}" var="a">
                    <tr>
                        <td></td>
                        <td><input 
                                <c:forEach items="${paper.getAid()}" var="p"> 
                                    ${(a.id == Integer.parseInt(p))?"checked = \"checked\"":""}
                                </c:forEach>
                                type="checkbox" name="autId" value="${a.id}"                
                                >${a.name}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save"></td>

                </tr>
            </table>
        </form>
    </body>
</html>
