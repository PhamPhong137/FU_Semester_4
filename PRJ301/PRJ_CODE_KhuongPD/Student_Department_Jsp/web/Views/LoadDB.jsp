<%-- 
    Document   : LoadDB
    Created on : Sep 20, 2023, 5:09:54 PM
    Author     : PC-Phong
--%>
<%@page import="DAL.*"%>
<%@page import="Models.*"%>
<%@page import="java.util.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <%  DAO d = (DAO)request.getAttribute("dao"); %>

        <%
        String stUpdate = "";
        Object o1 = request.getAttribute("update");
        stUpdate = (o1 != null) ? (o1 + "") : "";
        Student stU = null;
        for (Student st : d.getStd()) {
             if (st.getId().equals(stUpdate)) {
                 stU = st;
            }
        }                          
        %>

        <table>
            <%for(Student s : d.getStd()){ %>
            <tr>
                <td><%= s.getId()%></td>
                <td><%= s.getName()%></td>
                <td> <input type="checkbox" name="gender" value="M" 
                            <%= s.isGender()?"checked":""%>> Male/Female  </td>
                
                <td><%=d.getDept().get(s.getDepartId()).getName()%>   </td>
                <td><%= s.getAge()%></td>
                <td><%= s.getGpa()%></td>
                <td><%= s.getAdd()%></td>
                <td><%= s.getImg()%></td>
                <td><%= s.getDob()%></td>
                <td><a href = 'LoadDB?type=0&id=<%= s.getId()%>'>Update</a></td>
                <td><a href = 'LoadDB?type=1&id=<%= s.getId()%>'>Delete</a></td>
            </tr>
            <%}%>
        </table>
        <hr/>
        <form action="LoadDB" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id" value=<%= (stU == null ? "" : stU.getId())%>></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" value=' <%=(stU == null ? "" : stU.getName())%>' ></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                        <input type="radio" name="gender" value="M" <%=((stU == null || stU.isGender()) ? "checked" : "") %> >Male
                        <input type="radio" name="gender" value="F" <%=((stU != null && !stU.isGender()) ? "checked" : "") %>>Female
                    </td>
                </tr>
                <tr>
                    <td>Department</td>
                    <td><select name="departId">
                            <% for (Map.Entry<String, Department> en : d.getDept().entrySet()) {
                    String key = en.getKey();
                    Department value = en.getValue(); %>
                            <option value="<%=key%>" <%=(stU == null ? "" : stU.getDepartId().equals(key) ? "selected" : "")%> ><%= value.getName()%>  </option>
                            <%}%>
                        </select> 
                    </td>
                </tr>
                <tr>
                    <td>Age</td>
                    <td><input type="text" name="age" value=<%=(stU == null ? "" : stU.getAge()) %> ></td>
                </tr>
                <tr>
                    <td>GPA</td>
                    <td><input type="text" name="gpa" value=<%=(stU == null ? "" : stU.getGpa()) %>></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><textarea name="add"><%=(stU == null ? "" : stU.getAdd())%></textarea> </td>
                </tr>
                <tr>
                    <td>Image</td>
                    <td><input type="text" name="img" value=<%=(stU == null ? "" : stU.getImg()) %>></td>
                </tr>
                <tr>
                    <td>Date of birth</td>
                    <td><input type="date" name="dob" value=<%=(stU == null ? "2000-01-01" : (stU.getDob() == null ? "2005-01-01" : stU.getDob())) %>></td>
                </tr>

            </table>
            <input type="submit" name="btnInsert" value="Insert">
            <input type="submit" name="btnUpdate" value="Update">
           

        </form>
    </body>
</html>
