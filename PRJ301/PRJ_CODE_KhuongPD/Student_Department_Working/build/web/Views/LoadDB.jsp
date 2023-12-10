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
                    <!--.........................EX 1A....................-->
                    <!-- <td>
                        <input type="radio" name="gender" value="M" <%=((stU == null || stU.isGender()) ? "checked" : "") %> >Male
                        <input type="radio" name="gender" value="F" <%=((stU != null && !stU.isGender()) ? "checked" : "") %>>Female
                         </td>-->
                    <!--  <td>
                         <input type="checkbox" name="gender" value="M" <%=((stU == null || stU.isGender()) ? "checked" : "") %> >Male
                          <input type="checkbox" name="gender" value="F" <%=((stU != null && !stU.isGender()) ? "checked" : "") %>>Female
                          </td>-->
                    <td>
                        <select name="gender">
                            <option value="M" <%=((stU == null || stU.isGender()) ? "selected" : "") %>>Male</option>
                            <option value="F" <%=((stU != null && !stU.isGender()) ? "selected" : "") %>>Female</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Department</td>
                    <td>
                        <select name="departId">
                            <% for (Map.Entry<String, Department> en : d.getDept().entrySet()) {
                            String key = en.getKey();
                            Department value = en.getValue(); %>         
                            <option value="<%=key%>" <%=(stU == null ? "" : stU.getDepartId().equals(key) ? "selected" : "")%>> <%= value.getName()%>  </option>
                            <%}%>
                        </select> 
                        <!--.........................EX 1B................-->
                        <!--change select option - > radio  -->        
                        <!--
                        <% for (Map.Entry<String, Department> en : d.getDept().entrySet()) {
                String key = en.getKey();
                Department value = en.getValue(); %>
                        <input type="radio" name="departId" value="<%=key%>" <%=(stU == null ? "" : stU.getDepartId().equals(key) ? "checked" : "")%> /><%=value.getName()%>
                        <%}%>
                        -->
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
            <input type="submit" name="btnInUp" value="InUp">
        </form>


        <form action="SearchbyG" method="post">

            <h2>Search Student with gender</h2>
            <!--            <input type="radio" name="gender1" value="1" checked />Male
                        <input type="radio" name="gender1" value="0" />Female-->

            <!--            <select name="gender1">
                            <option value="1"selected>Male </option>
                            <option value="0">Female </option>
                        </select>-->

            <input type="checkbox" name="gender1" value="1" checked />Male
            <input type="checkbox" name="gender1" value="0" />Female

            <br/><input type="submit" name="SelectStudentgender" value="Search"/>

        </form>

        <form action="SearchbyD" method="post">
            <h2>Search Student with department</h2>
            <!--select_option-->
            <!--            <select name="departId1">
            <% for (Map.Entry<String, Department> en : d.getDept().entrySet()) {
                String key = en.getKey();
                Department value = en.getValue(); %>
            <option value="<%=key%>" <%=(stU == null ? "" : stU.getDepartId().equals(key) ? "selected" : "")%>><%= value.getName()%>  </option>
            <%}%>
        </select>-->

            <!--radio-->
            <!--
            <% for (Map.Entry<String, Department> en : d.getDept().entrySet()) {
               String key = en.getKey();
               Department value = en.getValue(); %>
            <input type="radio" name="departId1" value="<%=key%>" <%=(stU == null ? "" : stU.getDepartId().equals(key) ? "checked" : "")%> /><%=value.getName()%>
            <%}%>
            -->

            <!--checkbox-->

            <% for (Map.Entry<String, Department> en : d.getDept().entrySet()) {
               String key = en.getKey();
               Department value = en.getValue(); %>
            <input type="checkbox" name="departId2" value="<%=key%>" <%=(stU == null ? "" : stU.getDepartId().equals(key) ? "checked" : "")%> /><%=value.getName()%>
            <%}%>
            <br/><input type="submit"  value="Search"/>
        </form>

        <form action="SearchbyGandD"method="post">
            <h2>Search Student with gender and department</h2>
            <span>Choose gender:</span>
            <!-- radio -->
            <!--            <input type="radio" name="gender3b" value="1" checked />Male
                        <input type="radio" name="gender3b" value="0" />Female-->
            <!--Select option-->
            <!--            <select name="gender3b">
                            <option value="1"selected>Male </option>
                            <option value="0">Female </option>
                        </select>-->

            <input type="checkbox" name="gender3b" value="1" checked />Male
            <input type="checkbox" name="gender3b" value="0" />Female

            <br><br>
            <% for (Map.Entry<String, Department> en : d.getDept().entrySet()) {
                           String key = en.getKey();
                           Department value = en.getValue(); %>
            <input type="checkbox" name="departId3b" value="<%=key%>" <%=(stU == null ? "" : stU.getDepartId().equals(key) ? "checked" : "")%> /><%=value.getName()%>
            <%}%>
            <br/><input type="submit"  value="Search"/>
        </form>

        <form action="Search" method="post">
            <h2>Search by text(select_option)</h2>
            <input type="text" name="search" placeholder="Search">
            <br> 
            <select name="atribute4">
                <option>Choose atribute</option>
                <option>Id</option>
                <option>Name</option>
                <option>Gender</option>
                <option>DepartId</option>
                <option>Age</option>
                <option>Gpa</option>
                <option>Add</option>
                <option>img</option>
                <option>Dob</option>
            </select>
            <br>
            <br/><input type="submit"  value="Search"/>

        </form>
        <form action="Search" method="post">
            <h2>Search by text(checkbox)</h2>
            <input type="text" name="search" placeholder="Search">
            <br> 
            <form>
                <input type="checkbox" id="id" name="attribute4b" value="Id"> 
                <label for="id">Id</label><br>

                <input type="checkbox" id="name" name="attribute4b" value="Name">
                <label for="name">Name</label><br>  

                <input type="checkbox" id="gender" name="attribute4b" value="Gender">
                <label for="gender">Gender</label><br>

                <input type="checkbox" id="department" name="attribute4b" value="DepartId">
                <label for="department">Department</label><br>

                <input type="checkbox" id="age" name="attribute4b" value="Age">
                <label for="age">Age</label><br>  
                
                <input type="checkbox" id="Gpa" name="attribute4b" value="GPA">
                <label for="address">GPA</label><br>

                <input type="checkbox" id="address" name="attribute4b" value="add">
                <label for="address">Address</label><br>

                <input type="checkbox" id="img" name="attribute4b" value="img">
                <label for="img">Image</label><br>
                
                <input type="checkbox" id="dob" name="attribute4b" value="dob">
                <label for="dob">Date of Birth</label><br>
     
                <input type="submit"  value="Search"/>
            </form>
            <br>
            <br/>
        </form>



    </body>
</html>
