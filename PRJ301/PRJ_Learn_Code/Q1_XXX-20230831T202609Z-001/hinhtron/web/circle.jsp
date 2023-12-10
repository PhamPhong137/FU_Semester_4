<%-- 
    Document   : circle
    Created on : May 19, 2019, 8:26:33 PM
    Author     : sonnt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <canvas id="myCanvas" width="500" height="500" style="border:1px solid #d3d3d3;">
        Your browser does not support the HTML5 canvas tag.</canvas>
        <script>
            var color = ["red","green","blue","black","orange"];
            var c = document.getElementById("myCanvas");
            var ctx = c.getContext("2d");
            
            
            <c:forEach items="${requestScope.data}" var="r" varStatus="loop">
                
                ctx.font = "12px Comic Sans MS";
                ctx.fillStyle = color[${loop.index}%5];
                ctx.textAlign = "center";
                ctx.fillText("(" +${r.x} + "," +${r.y}+") radius:" +${r.r}, ${r.x}, ${r.y});     
    
    
                ctx.strokeStyle  = color[${loop.index}%5];
                ctx.beginPath();
                ctx.arc(${r.x}, ${r.y}, ${r.r}, 0, 2 * Math.PI);
                ctx.stroke();
                
                
            </c:forEach>
        </script> 
    </body>
</html>
