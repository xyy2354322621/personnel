<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/25 0025
  Time: 15:30
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
        }
        .button{
            margin: 10px 15px;
            width: 150px;
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
            width: 550px;
        }
        p{
            width: 500px;
            text-align: center;
        }
        span{
            width: 35px;
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
            width: 140px;
        }
        .input{
            width: 183px;
        }
    </style>

</head>

<body>
<div class="body">
    <div class="top"></div>
    <table>
        <tr><th>修改培训</th></tr>
        <tr><td>
            <form action="updateTrain" method="get">
                <input type="hidden" name="train_no" value="${train.train_no}">
                培训主题：<input name="train_name" type="text" value="${train.train_name}" required class="input">
                培训地点：<input name="train_address" type="text" value="${train.train_address}" required class="input"><br>
                开始时间：<input name="start_time" type="datetime-local" value="${train.start_time}" required>
                结束时间：<input name="end_time" type="datetime-local" value="${train.end_time}" required><br>
                培训备注：（培训的内容及要求，对象等）<br>
                <textarea name="message" required>${train.message}</textarea><br>
                <input type="submit" value="修改" class="button">
                <input type="reset" value="重置" class="button">
                <a href="manageTrain"><input type="button" value="返回" class="button"></a>

            </form>
        </td></tr>

    </table>
    <div class="bottom"></div>
</div>

</body>
</html>
