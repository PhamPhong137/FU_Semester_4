<%-- 
    Document   : add
    Created on : Mar 17, 2022, 8:48:39 PM
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
        <form action="add" method="POST">
            <table>
                <tr>
                    <td>Title</td>
                    <td><input type="text" name="title" value="" /></td>
                </tr>
                <tr>
                    <td>Startdate (yyyy/MM/dd)</td>
                    <td><input type="text" name="startDate" value="" /></td>
                </tr>
                <tr>
                    <td>Enddate (yyyy/MM/dd)</td>
                    <td><input type="text" name="endDate" value="" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit" /></td>
                </tr>
            </table>

        </form>
    </body>
</html>
