<%-- 
    Document   : rect
    Created on : May 19, 2019, 6:33:17 PM
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
                ctx.textAlign = "left";
                ctx.fillText("(x:" +${r.x} + ",y:" +${r.y}+",w:" + ${r.w} + ",h:" +${r.h} + ")", ${r.x + 5}, ${r.y + 15});  
                ctx.beginPath();
                ctx.strokeStyle = color[${loop.index}%5];
                ctx.rect(${r.x}, ${r.y}, ${r.w}, ${r.h});
                ctx.stroke();
            </c:forEach>
            
        </script> 
    </body>
</html>
