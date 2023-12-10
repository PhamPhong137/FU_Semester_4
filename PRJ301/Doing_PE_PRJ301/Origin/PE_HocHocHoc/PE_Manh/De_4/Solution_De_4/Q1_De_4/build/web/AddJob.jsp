<%-- 
    Document   : AddJob
    Created on : Mar 18, 2022, 9:42:19 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>

            
            function DoAllJob() {
                window.location.href = "list";
            }
        </script>
    </head>
    <body>
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
    </body>
</html>
