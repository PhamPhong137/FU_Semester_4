<%-- 
    Document   : add
    Created on : Mar 18, 2022, 10:29:47 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <script>
            function DoCancel() {
                window.location.href = "add";
            }

        </script>
    </head>
    <body>
        <form action="add" method="post">
            <table >
                <tr>
                    <td>Roll no</td>
                    <td><input type="text"  name="id" > </td>

                </tr>
                <tr>
                    <td>Major</td>
                    <td>
                        <select name = "major">
                            <option>Others</option>    
                            <c:forEach items="${students}" var="s">
                                <option  value="${s.getMajor()}">${s.getMajor()}</option>    
                            </c:forEach>
                        </select>   

                    </td>

                </tr>
                <tr>
                    <td>Full name</td>
                    <td><input type="text"  name="name" > </td>
                </tr>

                <tr>
                    <td>City</td>
                    <td><input type="text"  name="city" > </td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td><input type="radio" name="gender" value="male" checked="checked"> Male
                        <input type="radio" name="gender"  value="female"> Female
                    </td>
                </tr>


            </table>
            <input type="submit" value="Save">
            <input type="button" value="Cancel" onclick="DoCancel()">


        </form>
    </body>
</html>
