<%-- 
    Document   : Create
    Created on : Mar 9, 2022, 11:20:24 PM
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
        <form action="create" method="POST">
            <table>
                <tr>
                    <td>To</td>
                    <td>
                        <select name = "to">
                            <c:forEach items="${users}" var="u">
                                <option
                                    value="${u.getUserid()}">${u.getUserid()}</option>    
                            </c:forEach>
                        </select>
                    </td>

                </tr>

                <tr>
                    <td>title</td>
                    <td><input type="text" name="title" value="My new message"></td>

                </tr>
                <tr>
                    <td>Content</td>
                    <td><textarea name="content" >I do not know what to write </textarea></td>

                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save"></td>
                </tr>
            </table>
        </form>
        <h2>${text}</h2>
    </body>
</html>
