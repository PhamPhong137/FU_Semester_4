<%-- 
    Document   : list
    Created on : Sep 3, 2023, 1:43:35 AM
    Author     : PC-Phong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function doDelete(id) {
                if (confirm("Are you sure to delete category with id " + id)) {
                    window.location = "delete?id=" + id;
                }
            }
        </script>
    </head>
    <center>
        <h1>List of categories</h1> 
        <h3><a href="add.jsp" >ADD new</a></h3>
        <table border="1px" width="40%">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Describe</th>
                <th>ACTION</th>
            </tr>
            <c:forEach items="${requestScope.data}" var="c">
                <c:set var="id" value="${c.id}"/>
                <tr>
                    <td>${id}</td>
                    <td>${c.name}</td>
                    <td>${c.describe}</td>
                    <td>
                        <a href="update?id=${id}">Update</a> &nbsp;&nbsp;&nbsp;
                        <a href="#" onclick="doDelete('${id}')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </center>
</html>
