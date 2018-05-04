<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/20 0020
  Time: 19:13
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
            width: 50px;
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
            width: 5px;
            display: inline-block;
        }
        .shot{
            width: 2px;
            display: inline-block;
        }
        .shot1{
            width: 7px;
            display: inline-block;
        }
        select{
            width: 160px;
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
        <tr><th>新增职位</th></tr>
        <tr><td>
            <form action="savePosition" method="get">
                部门选择：<span></span><select name="depart_no" >
                <c:forEach items="${sessionScope.departments}" var="department">
                    <option value="${department.depart_no}" selected>${department.depart_name}</option>
                </c:forEach>
            </select><br>
                职位名称：<input name="pos_name" type="text" required><br>
                基本薪资：<input name="salary" type="text" placeholder="输入整数" pattern="^[1-9]\d{0,6}$" required><br>
                <input type="submit" value="新增" class="button">
                <input type="reset" value="重置" class="button">
                <a href="managePosition"><input type="button" value="返回" class="button"></a>
            </form>
        </td></tr>

    </table>
    <div class="bottom"></div>
</div>

</body>
</html>
