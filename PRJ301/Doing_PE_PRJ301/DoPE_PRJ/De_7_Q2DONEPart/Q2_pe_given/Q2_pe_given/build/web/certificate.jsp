<%-- 
    Document   : certificate
    Created on : Nov 4, 2023, 9:15:08 PM
    Author     : Fpt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="certificate" method="post"><table border="1">
                <thead>
                    <tr>
                        <th> </th>
                            <c:forEach items="${ce}" var="ce">
                            <th>${ce.name}</th>
                            </c:forEach>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${em}" var="em">
                        <tr>
                            <td>${em.name}</td>
                            <c:forEach items="${ce}" var="ces">
                                <td><input type="checkbox" name="checkbox" value="${em.id} ${ces.id}" 
                                           <c:forEach items="${emce}" var="emce">
                                               <c:if test="${emce.eid == em.id && emce.cid == ces.id}">
                                                   checked=""
                                               </c:if>
                                           </c:forEach>  ></td>
                                </c:forEach>    
                        </tr>




                    </c:forEach>

                </tbody>
            </table>
            <button>Save</button>
        </form>
    </body>
</html>
