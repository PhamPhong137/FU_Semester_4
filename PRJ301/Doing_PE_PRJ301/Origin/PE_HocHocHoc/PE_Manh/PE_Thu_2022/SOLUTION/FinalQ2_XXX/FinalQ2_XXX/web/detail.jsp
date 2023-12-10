<%-- 
    Document   : detail
    Created on : Mar 9, 2022, 11:13:29 PM
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
        <table border = "1">
            <tr>
                <td>From:</td>
                <td>${message.getFrom()}</td>               
            </tr>
            <tr>
                <td>Title</td>
                <td>${message.getTitle()}</td>               
            </tr>
            <tr>
                <td>Created Time:</td>
                <td>${message.getTime().substring(0,19)}</td>               
            </tr>
            <tr>
                <td>Content</td>
                <td>${message.getContent()}</td>               
            </tr>
        </table>
    </body>
</html>
