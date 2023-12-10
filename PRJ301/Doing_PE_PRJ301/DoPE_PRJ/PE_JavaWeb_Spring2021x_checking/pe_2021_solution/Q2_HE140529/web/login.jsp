<%-- 
    Document   : login
    Created on : Mar 27, 2021, 7:49:21 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            Username: <input type="text" name="user" value="" /><br>
            Password <input type="password" name="pass" value="" /><br>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
