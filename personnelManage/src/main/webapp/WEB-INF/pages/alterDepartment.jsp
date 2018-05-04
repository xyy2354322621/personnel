<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/22 0022
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
    <style type="text/css">
        .body{
            margin: 0 auto;
            width: 900px;
            background-image: url(img/body.png);
            background-size: 100% auto;
        }
        table{
            /*border: 2px solid gray;*/
            /*height: 300px;*/
            margin: 50px auto;
            padding: 10px;
        }
        input{
            margin: 5px;
        }
        .button{
            margin: 5px 3px;
            width: 75px;
        }
        .top{
            height: 150px;
            margin: 0 auto;
            width: 900px;
            background-image: url(img/top.jpg);
            background-size: 100% auto;
        }
        .bottom{
            height: 150px;
        }
    </style>

</head>
<body>
<div class="body">
    <div class="top"></div>
    <table>
        <tr><th>修改部门</th></tr>
        <tr><td>
            <form action="updateDepartment" method="post">
                部门名称：<input name="depart_name" type="text" value="${sessionScope.alterDepartment.depart_name}" required><br>
                部门地址：<input name="depart_location" type="text" value="${sessionScope.alterDepartment.depart_location}"><br>
                <input type="submit" value="修改" class="button">
                <input type="reset" value="重置" class="button">
                <a href="manageDepartment"><input type="button" value="返回" class="button"></a>

            </form>
        </td></tr>

    </table>
    <div class="bottom"></div>
</div>
</body>
</html>
