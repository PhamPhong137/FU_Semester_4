<%-- 
    Document   : tong_hop_html_jsp
    Created on : Mar 18, 2022, 5:48:32 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <!--table add-->
        <form action="add" method="post">
            <table >
                <tr>
                    <td>Job Name</td>
                    <td><input type="text"  name="name" value="${job.name}"> </td>

                </tr>
                <tr>
                    <td>Job Salary</td>
                    <td><input type="text" name="salary" value="${job.salary}"></td>

                </tr>
                <tr>
                    <td>Date Created</td>
                    <td><fmt:formatDate pattern="MM/dd/yyyy" value="<%=new java.util.Date()%>" var="nowDate" />
                <input type="text" name="date"  pattern="(0[1-9]|1[012])/(0[1-9]|1[0-9]|2[0-9]|3[01])/([0-9]{4})" title="Format date MM/dd/yyyy" value="${dated}">(MM/dd/yyyy)
                </td>
                </tr>

                <tr>
                    <td>Activated</td>
                    <td><input type="radio" name="active" value="yes"
                               ${job.activated?"checked=\"checked\"":""}       
                               > Yes
                        <input type="radio" name="active"  value="no"
                               ${!job.activated?"checked=\"checked\"":""} 
                               > No
                    </td>

                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save">
                        <input type="button" value="AllJob(s)" onclick="DoAllJob()">
                    </td>

                </tr>
            </table>
        </form>

        <!--table list-->  
        <table border = "1">
            <tr>
                <td>Job ID</td>
                <td>Job Name</td>
                <td>Job Salary</td>
                <td>Hire Date</td>
                <td>Activated(Yes/No)</td>
            </tr>
            <c:forEach items="${jobs}" var="j">
                <tr>
                    <td><a href="#">${j.id}</a></td>
                    <td><a href="#">${j.name}</a></td>
                    <td>${j.salary}000</td>
                    <td>${j.date}</td>

                    <td><c:choose>
                            <c:when test="${j.activated}">
                                Yes
                            </c:when>
                            <c:otherwise>
                                No
                            </c:otherwise>
                        </c:choose>
                    </td>

                </tr>
            </c:forEach>
        </table>


        <!--table Search-->
        <form action="search" method="POST"> 
            Authors:
            <select name="id">
                <c:forEach items="${author}" var="a">
                    <option ${(a.id == id)?"selected = \"selected\"":""}
                        value="${a.id}" >${a.name}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Search">
        </form>
        <c:choose>
            <c:when test="${papers!=null}">
                <table border = "1">
                    <tr>
                        <td>Paper Id</td>
                        <td>Title</td>
                        <td>Published Date</td>

                    </tr>
                    <c:forEach items="${papers}" var="p">
                        <tr>
                            <td>${p.pid}</td>
                            <td>${p.title}</td>
                            <td>${p.publish}</td>

                        </tr>
                    </c:forEach>
                </table>
            </c:when>

        </c:choose>

        <!--table create-->
        <form action="add" method="POST">
            Session of ${user.getUser()} <br>
            Content: <input type="text" name="content"><br>
            <fmt:formatDate pattern="yyyy-MM-dd" value="<%=new java.util.Date()%>" var="nowDate" />
            Date:<input type="text" name="date" value="${nowDate}" pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" title="Format date yyyy-mm-dd" name="date"><br/>
            <input type="checkbox" name="isUrgent">isUrgent<br/>
            <input type="submit" value="Save">
        </form>

        <!--form login-->
        <form action="login" method="POST">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="user"></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="pass"></td>
                </tr>

                <tr>
                    <td><input type="submit" value="Login"></td>
                    <td></td>
                </tr>
            </table>
        </form>
        <h2>${mess}</h2>

        <!--date theo form (yyyy-dd-MM)-->
    <fmt:formatDate pattern="yyyy-MM-dd" value="<%=new java.util.Date()%>" var="nowDate" />
    Date:<input type="text" name="date" value="${nowDate}" pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" title="Format date yyyy-mm-dd" name="date"><br/>

    <!-- Select option -->
    <select>
        <option>Danh sách 01</option>
        <option>Danh sách 02</option>
        <option>Danh sách 03</option>
        <option>Danh sách 04</option>
    </select>

    <select name = "did">
        <c:forEach items="${requestScope.depts}" var="d">
            <option ${()?"selected = \"selected\"":""}
                value="${d.id}">${d.name}</option>    
        </c:forEach>
    </select>

    //if else trong jstl
    <c:choose>
        <c:when test="${param.enter=='1'}">
            pizza. 
            <br />
        </c:when>    
        <c:otherwise>
            pizzas. 
            <br />
        </c:otherwise>
    </c:choose>

</body>
</html>
