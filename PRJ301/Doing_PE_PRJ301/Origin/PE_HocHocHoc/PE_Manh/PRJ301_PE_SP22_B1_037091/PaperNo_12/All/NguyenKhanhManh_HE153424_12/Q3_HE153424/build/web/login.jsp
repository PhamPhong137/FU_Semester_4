<%-- 
    Document   : login
    Created on : Mar 10, 2022, 10:44:09 PM
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
        <form action="login" method="POST">

            Username:
            <input type="text" name="user"><br>

            Password: 
            <input type="password" name="pass"><br>



            <input type="submit" value="login">


            </table>
        </form>
        <h2>${mess}</h2>
    </body>
</html>
