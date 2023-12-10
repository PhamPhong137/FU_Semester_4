<%-- 
    Document   : list
    Created on : Mar 17, 2022, 9:39:49 PM
    Author     : Le Hong Quan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table{
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <form action="list" method="POST">
            <select name="schoolYear">
                <c:forEach items="${listSchoolYears}" var="S">
                    <option value="${S.id}" ${schoolYearId == S.id? "selected": ""}>${S.title}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Filter" />
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>FullName</th>
                    <th>Sex</th>
                    <th>DOB</th>
                    <th>Email</th>
                    <th>SchoolYear</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listStudents}" var="S">
                    <tr>
                        <td>${S.id}</td>
                        <td>${S.fullname}</td>
                        <td>${S.sex}</td>
                        <td>${S.dob}</td>
                        <td>${S.email}</td>
                        <td>${S.schoolYear.title}</td>
                        <td><a href="delete?sid=${S.id}">delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
