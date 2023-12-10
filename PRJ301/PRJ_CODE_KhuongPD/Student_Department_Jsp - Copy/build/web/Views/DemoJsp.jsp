<%-- 
    Document   : DemoJsp
    Created on : Sep 20, 2023, 4:31:22 PM
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
        <h1>Hello World!</h1>
        <h1>1 + 1 = <%= (1+1)  %></h1>

        <% int x= 10;
        int y =41;
        int z= x+y;
//        out.println("<h1> x + y = "+z+"</h1>" );  
        %>

        <h1> x + y = <%= z %></h1>
        <%  
            String s = check(x+y)?"sochan":"sole" ;
        %>
        <h2>Ket qua tong x + y la <%= s %></h2>
        <%!
            private boolean check(int x){ 
                return x%2==0;}
        %>
    </body>
</html>
