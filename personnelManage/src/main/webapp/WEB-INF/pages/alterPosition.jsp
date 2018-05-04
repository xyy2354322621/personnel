<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/22 0022
  Time: 22:08
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
        <tr><th>修改职位</th></tr>
        <tr><td>
            <form action="updatePosition" method="get">
                职位名称：<input name="pos_name" type="text" value="${sessionScope.alterPosition.pos_name}" required><br>
                基本薪资：<input name="salary" type="text" value="${sessionScope.alterPosition.basic_salary}" pattern="^[1-9]\d{0,6}$" required><br>
                <input type="submit" value="修改" class="button">
                <input type="reset" value="重置" class="button">
                <a href="managePosition"><input type="button" value="返回" class="button"></a>

            </form>
        </td></tr>

    </table>
    <div class="bottom"></div>
</div>
</body>

</html>
