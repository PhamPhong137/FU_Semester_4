<%-- 
    Document   : JSPL_test
    Created on : Oct 2, 2023, 11:14:57 AM
    Author     : PC-Phong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <h1>25_SE1762_Pham Hong Phong_HE176151</h1>

    <c:url value="/myServlet">
        <c:param name="param1" value="value1" />
        <c:param name="param2" value="value2" />
    </c:url>
    <a href="<c:url value="/myServlet">
           <c:param name="param1" value="value1" />
           <c:param name="param2" value="value2" />
       </c:url>">Click here</a>

</html>
