<%-- 
    Document   : tinh
    Created on : Sep 2, 2023, 7:51:07 PM
    Author     : PC-Phong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script type="text/javascript">
        function choice(change) {
            document.getElementById("d").value = change;
           // document.getElementById("f1").submit();
        }
    </script>
    <body>
        <h1>Đổi tiền</h1>
        <h3>${requestScope.error}</h3>
        <form id="f1" action="tinh" method="post">
            Nhập tiền việt: <input type="text" name="money"><br/>
            <!--            <input type="checkbox" name="change" checked value="0"/>Sang USD
                        <input type="checkbox" name="change" value="1"/>Sang Yen
                        <br/> <input type="submit" value="Doi tien"/>-->
            <input type="hidden"id="d"name="change"value=""/>
            <input type="submit" onclick="choice('0')" value="Doi sang USD"/>
            <input type="submit" onclick="choice('1')" value="Doi sang Yen"/>

        </form>
        <h3>${requestScope.ketqua}</h3>
    </body>
</html>
