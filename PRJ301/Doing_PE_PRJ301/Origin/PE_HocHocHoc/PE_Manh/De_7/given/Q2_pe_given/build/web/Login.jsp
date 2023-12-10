<%-- 
    Document   : Login
    Created on : Mar 17, 2021, 6:30:31 PM
    Author     : trinh
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
            <table>
                <tbody>
                    <tr>
                        <td>Username</td>
                        <td>
                            <input type="text" name="user" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>
                            <input type="text" name="pass" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Login" />
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
