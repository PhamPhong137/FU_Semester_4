<%-- 
    Document   : Login
    Created on : Oct 4, 2023, 4:35:05 PM
    Author     : PC-Phong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        ${error}
        <form action="Login" method="post">
            <input type="text" name="user" value="abc"><br/>
            <input type="password" name="pass" value="123"><br/>
            <input type="number" name="roll" value="0" min="0" max="10"><br/>
            <input type="submit" name="Login" value="Login"><br/>



        </form>
    </body>
</html>
