<%-- 
    Document   : create
    Created on : Mar 10, 2022, 10:59:57 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="add" method="POST">
            Session of ${user.getUser()} <br>
            Content: <input type="text" name="content"><br>
            <fmt:formatDate pattern="yyyy-MM-dd" value="<%=new java.util.Date()%>" var="nowDate" />
            Date:<input type="text" name="date" value="${nowDate}" pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" title="Format date yyyy-mm-dd" name="date"><br/>
            <input type="checkbox" name="isUrgent">isUrgent<br/>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
