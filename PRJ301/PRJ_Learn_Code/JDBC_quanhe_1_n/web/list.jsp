<%-- 
    Document   : list
    Created on : Sep 13, 2023, 1:03:54 AM
    Author     : PC-Phong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #wrapper{
                font-family: arial;
                margin-left: 30px;
                width: 90%
            }
            .clr{
                clear:both;
            }
            /* Phan Menu*/
            #menu_tab{
                width: 100%;
            }
            ul.menu{
                float: left;
                background: url(images/background_menu.jpg) repeat-x;
                display: block;
                list-style-type: none;
                font-weight: bold;
                height: 55px;
                padding: 12px;
                width: 100%;
            }
            ul.menu li{
                display: inline;
                font-size: 14px;
                padding-top: 15px;
                text-align: center;
                line-height: 30px;
                color:#E2D9BC;
            }
            ul.menu li a{
                margin: 10px;
                padding-left:0px;
                text-decoration:none;
                text-align:center;
                color:#E2D9BC;
                position:relative;
            }
            ul.menu li a img{
                float:left;
                margin-left:10px;
            }
            ul.menu li a:hover{
                color:#F90;
            }
            ul.menu li a:active{
                color:#FF0;
            }
            ul.menu li a:focus {
                color:#96F;
            }
            #content{
                margin-left: 20px;
            }
            table{
                border-collapse: collapse;
            }
            td{
                text-align: center ;
            }

        </style>
    </head>
    <body>
        <div id="wrapper">
            <div id="menu_tab">
                <ul class="menu">
                    <li><a href="products?cid=${0}">ALL</a></li>
                        <c:forEach items="${requestScope.data}" var="c" >                      
                        <li><a href="products?cid=${c.id}">${c.name}</a></li>
                        </c:forEach>
                </ul>

            </div>
            <div class="clr"></div>
            <div id="content">
                <c:set var="list" value="${requestScope.products}"/>
                <c:if test="${((list==null)||(list.size()==0))}">
                    <h3>No product</h3>
                </c:if>
                <c:if test="${((list!=null)&&(list.size()>0))}">
            
                    <table border="1px">
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Image</th>
                            <th>Category name</th>
                        </tr>
                        <c:forEach items="${list}" var="p">
                            <tr>
                                <td>${p.id}</td>
                                <td>${p.name}</td>
                                <td>${p.price}</td>
                                <td><img src="${p.image}" width="80px" height="80px" alt="alt"/></td>
                                <td>${p.category.name}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </div>
        </div>
    </body>
</html>
