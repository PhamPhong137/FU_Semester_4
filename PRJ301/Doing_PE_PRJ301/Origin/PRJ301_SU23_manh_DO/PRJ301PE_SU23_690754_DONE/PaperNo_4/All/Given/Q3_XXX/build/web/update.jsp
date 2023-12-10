<%-- 
    Document   : update
    Created on : Nov 4, 2023, 4:02:52 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        List of Students:
        <table border="1" style="margin-bottom: 50px">
            <tr>
                <td>Code</td>
                <td>Name</td>
                <td>Date of birth</td>
                <td>Gender</td>
                <td>Select</td>
            </tr>
            <c:forEach items="${listS}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.dob}</td>
                    <td>${(s.gender) ? "Male" : "Female"}</td>
                    <td><a href="update?sid=${s.id}">Select</a></td>
                </tr>
            </c:forEach>
        </table>

        Detail information:
        <form action="update" method="post">
            <table>
                <tr>
                    <td>Code:</td>
                    <td><input type="text" name="code" value="${student.id}"></td>
                    <td>Name:</td>
                    <td><input type="text" name="name" value="${student.name}"></td>
                </tr>
                <tr>
                    <td>Date of birth:</td>
                    <td><input type="text" name="dob" value="${student.dob}"></td>
                    <td>
                        Gender: 
                    </td> 
                    <td><input type="radio" name="gender" value="true" ${(student.gender) ? "checked" : ""}>Male
                        <input type="radio" name="gender" value="false" ${(student.gender) ? "" : "checked"}>Female
                    </td>
                </tr>
                <tr>
                    <td>Class:</td> 
                    <td>
                        <select name="classes"> 
                            <c:if test="${student == null}">
                                <option>All</option>
                            </c:if>
                            <c:forEach items="${listC}" var="lc">
                                <c:if test="${student.classID eq lc.id}">
                                    <option value="${lc.id}">${lc.name}</option>
                                </c:if>
                                <c:if test="${!(student.classID eq lc.id)}">
                                    <option value="${lc.id}">${lc.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </td>
                    <td><input type="submit" value="Update"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
