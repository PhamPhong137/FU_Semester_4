<%-- 
    Document   : home
    Created on : Aug 30, 2023, 12:05:39 AM
    Author     : PC-Phong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Example fot JSP</h1>
        <h2 style="color: chocolate">
            <% 
                String name="TEO";
                 out.println("hello"+name);
                 double r=2;
                 DecimalFormat f = new DecimalFormat("##.##");
                 // chu thich cua java tren 1 dong
            %>
            <!--chu thich của html-->
        </h2>
        <!--        <h2 style="color: blue ">
                    Dien tich : <%=  f.format(Math.PI*r*r) %>
                </h2>        -->

        <h1>Bai 1</h1>
        <form >
            enter radius : <input type="text" name="r" /><br/>
            <input  type="submit" value="Submit" />
        </form>   
        <% 
        if(request.getParameter("r")!=null){
        String r_raw = request.getParameter("r");
        double ra;
        try{
             ra=Double.parseDouble(r_raw);
             double s=ra*ra*Math.PI;
            
         %>
         <h2>Dien tich la:<%= f.format(s)%></h2>
         <%
            }catch(Exception e){
            System.out.print(e);
            }
        }
        %>
    </body>
</html>
