
<%@page import="model.Rect"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            //java code 
            ArrayList<Rect> rects = (ArrayList<Rect>) 
                    request.getAttribute("rects");
        %>


    </head>
    <body>
        <canvas id="myCanvas" width="500" height="500" style="border:1px solid #d3d3d3;">
            Your browser does not support the HTML5 canvas tag.</canvas>

        <script>
            var c = document.getElementById("myCanvas");
            var ctx = c.getContext("2d");
            
            <% for (Rect r : rects) {
            %>
            // Red rectangle
                ctx.beginPath();
                ctx.lineWidth = "2";
                ctx.strokeStyle = "rgb(<%=r.getR()%>,<%=r.getG()%>,<%=r.getB()%>)";
                ctx.rect(<%=r.getX()%>, <%=r.getY()%>, <%=r.getW()%>, <%=r.getH()%>);
                ctx.stroke();
            
            <%}%>
            function writeMessage(context, message) {
              
                context.clearRect(0, 0, 100, 20);
                context.font = '18pt Calibri';
                context.fillStyle = 'black';
                context.fillText(message, 10, 20);
            }
            function getMousePos(canvas, evt) {
                var rect = canvas.getBoundingClientRect();
                return {
                    x: evt.clientX - rect.left,
                    y: evt.clientY - rect.top
                };
            }
            c.addEventListener('mousemove', function(evt) {
                var mousePos = getMousePos(c, evt);
                var message = mousePos.x + ',' + mousePos.y;
                writeMessage(ctx, message);
            }, false);
        </script>
    </body>
</html>
