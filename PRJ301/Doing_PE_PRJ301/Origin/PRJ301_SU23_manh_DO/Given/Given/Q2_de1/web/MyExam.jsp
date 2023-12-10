<%-- 
    Document   : MyExam
    Created on : Nov 4, 2023, 9:50:30 PM
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
        ${error}
        <form action="sum" method="post">
            <table>
                <tr>
                    <td>Enter an integer n:</td>
                    <td><input type="text" name="n" value="${n}"></td>
                </tr>
                <tr>
                    <td>Result:</td>
                    <td><input type="text" value="${sum}" ></td>
                </tr>
                <tr>
                    <td><input type="submit" value="SUM"></td>
                    <td></td>
                </tr>           
            </table>
            
        </form>
    </body>
</html>
