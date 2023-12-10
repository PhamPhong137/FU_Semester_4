<%-- 
    Document   : home
    Created on : Aug 31, 2023, 12:55:45 AM
    Author     : PC-Phong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <div id="menu_tab">
          <%--<%@include file="menu.jsp" %>--%>
          <jsp:include page="menu.jsp"/>
        </div>
        <div class="clr"></div>
        <div>
            <%@include file="index.html" %>
        </div>
        <div>
            
        </div><div class="clr"></div>
        <div class="footer">
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
