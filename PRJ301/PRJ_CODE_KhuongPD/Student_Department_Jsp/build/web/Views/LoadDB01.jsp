
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <c:forEach items="${dao.std}" var="st">
                <c:if test="${st.id.equals(update)}">
                    <c:set var="stU" value="${st}"></c:set>
                </c:if>

                <tr>
                    <td>${st.id}</td>
                    <td>${st.name}</td>
                    <td>${st.gender?"Male":"Female"}</td>
                    <td>${dao.dept[st.departId].name}</td>
                    <td>${st.age}</td>
                    <td>${st.gpa}</td>
                    <td>${st.add}</td>
                    <td>${st.img}</td>
                    <td>${st.dob}</td>
                    <td><a href='LoadDB?type=0&id=${st.id}'>Update</a></td>
                    <td><a href='LoadDB?type=1&id=${st.id}'>Delete</a></td>

                </tr>
            </c:forEach>
        </table>
        <form action="LoadDB" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id" value="${stU.id}"></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" value="${stU.name}"></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                        <input type="radio" name="gender" value="M" 
                               ${stU==null||stU.gender?"checked":""}>Male
                        <input type="radio" name="gender" value="F"
                               ${stU!=null && !stU.gender?"checked":""}>Female
                    </td>
                </tr>
                <tr>
                    <td>Department</td>
                    <td><select name="departId">                        
                            <c:forEach items="${dao.dept}" var="de" >
                                <option value='${de.key}'
                                      ${de.key.equals(stU.departId)?"selected":""}  >${de.value.name}</option>                               
                            </c:forEach>                      
                        </select> </td>
                </tr>
                <tr>
                    <td>Age</td>
                    <td><input type="text" name="age" value="${stU.age}"></td>
                </tr>
                <tr>
                    <td>GPA</td>
                    <td><input type="text" name="gpa" value="${stU.gpa}"></td>
                </tr>
                <tr>
                    <td>ADD</td>
                    <td><textarea name="add"> ${stU.add}</textarea> </td>
                </tr>
                <tr>
                    <td>Image</td>
                    <td><input type="text" name="img" value="${stU.img}"></td>
                </tr>
                <tr>
                    <td>Date of birth</td>
                    <td><input type="date" name="dob" value="${stU.dob}"></td>
                </tr>

            </table>
            <input type="submit" name="btnInsert" value="Insert">
            <input type="submit" name="btnUpdate" value="Update">

        </form>

    </body>
</html>
