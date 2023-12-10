<%-- 
    Document   : newjsp
    Created on : Jul 17, 2021, 7:57:20 AM
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
            Username: <input type="text" name="Username" value="" /> <br>
            Password <input type="password" name="Password" value="" /> <br>
            <input type="submit" value="Login" />
        </form>
        ${mess}
    </body>
</html>
