<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/25 0025
  Time: 15:15
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
            margin: 10px auto;
            padding: 10px;
        }
        input{
            margin: 5px;
            width: 205px;
        }
        .button{
            margin: 10px 40px;
            width: 120px;
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
            height: 150px;
            width: 590px;
        }
        p{
            width: 500px;
            text-align: center;
        }
        span{
            width: 30px;
            display: inline-block;
        }
        .shot{
            width: 15px;
            display: inline-block;
        }
        .shot1{
            width: 7px;
            display: inline-block;
        }
        select{
            width: 120px;
        }
        .long{
            width: 100px;
        }
    </style>

</head>
<body>
<div class="body">
    <div class="top"></div>
    <table>
        <tr><th>新增培训</th></tr>
        <tr><td>
            <form action="saveTrain" method="post">
                培训主题：<input name="train_name" type="text" required>
                培训地点：<input name="train_address" type="text" required><br>
                开始时间：<input name="start_time" type="datetime-local" required>
                结束时间：<input name="end_time" type="datetime-local" required><br>
                培训备注：（培训的内容及要求，对象等）<br>
                <textarea name="message" required></textarea><br>
                <input type="submit" value="新增"  class="button">
                <input type="reset" value="重置" class="button">
                <a href="manageTrain"><input type="button" value="返回" class="button"></a>
            </form>

        </td></tr>

    </table>
    <div class="bottom"></div>
</div>

</body>
</html>
