<%-- 
    Document   : list
    Created on : Mar 17, 2022, 8:33:58 PM
    Author     : Le Hong Quan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${ROLL_NUMBER}</h1>
        <form action="getfirst" method="POST">
            Get First<input type="text" name="number" value="" /> letter(s)<br/>
            <input type="submit" value="Get" />
        </form>
        <h3>${msg}</h3>
    </body>
</html>
