<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/5/2 0002
  Time: 19:42
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
            width: 70px;
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
        textarea{
            height: 70px;
            width: 230px;
        }
        p{
            width: 230px;
            text-align: center;
        }
    </style>

</head>
<body>
<div class="body">
    <div class="top"></div>
    <table>
        <tr><th>修改复议</th></tr>
        <tr><td>
            <form action="updateReconsiderSalary" method="post">
                复议金额<input type="text" name="money" value="${sessionScope.alterReconsiderSalary.money}" pattern="^-?\d{1,7}\.?\d{1,2}" required><br>
                <p>复议说明</p>
                <textarea name="reason" required>${sessionScope.alterReconsiderSalary.reason}</textarea><br>
                <input type="submit" value="确定" class="button">
                <input type="reset" value="重置" class="button">
                <a href="browseMyReconsiders"><input type="button" value="返回" class="button"></a>

            </form>
        </td></tr>

    </table>
    <div class="bottom"></div>
</div>

</body>
</html>
