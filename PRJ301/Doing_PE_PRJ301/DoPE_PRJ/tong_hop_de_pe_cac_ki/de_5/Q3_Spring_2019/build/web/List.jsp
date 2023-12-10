
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="StudentControl" method="post">
        <div align="center">
        Department
        <select name="department" onchange="this.form.submit()">
             <option value="0">---------All---------</option>
             <c:forEach begin="1" end="3" var="x">
                <option></option>
            </c:forEach>
        </select>
        </div>
        <br>
        <table align="center" border="1px solid">
            <tr>
                <th>
                    Name
                </th>
                <th>
                    Born
                </th>
                <th>
                    Gender
                </th>
                <th>
                    Department
                </th>
            </tr>
            <c:forEach items="${listAll}" var="x">
                <tr>
                    <td>${x.name}</td>
                    <td>${x.dob}</td>
                    <c:choose>
                        <c:when test="${x.gender eq 1}">
                        <td><img src="image/1.PNG"/></td>
                        </c:when>
                    <c:otherwise>
                         <td><img src="image/0.PNG"/></td>
                    </c:otherwise>
                    </c:choose>
                    <td>${x.departmentname}</td>
                </tr>
            </c:forEach>
        </table>
        </form>
    </body>
</html>
