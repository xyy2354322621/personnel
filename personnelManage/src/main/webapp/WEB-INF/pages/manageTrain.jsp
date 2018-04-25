<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/25 0025
  Time: 14:42
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
</head>
<body>
<a href="createTrain">新开培训</a>
<a href="gotoEmployeeHome">返回</a>
<div>
    <table>
        <caption>职位信息</caption>
        <tr>
            <th>培训编号</th><th>培训名称</th><th>培训地点</th>
            <th>开始时间</th><th>结束时间</th><th>备注</th>
            <th>修改</th><th>删除</th><th>添加学员</th>
        </tr>
        <c:forEach items="${trainList}" var="train">
            <tr>
                <td>${train.train_no}</td><td>${train.train_name}</td>
                <td>${train.train_address}</td><td>${train.start_time}</td>
                <td>${train.end_time}</td><td>${train.message}</td>
                <td><a href="alterTrain?train_no=${train.train_no}">修改</a></td>
                <td><a href="deleteTrain?train_no=${train.train_no}">删除</a></td>
                <td><a href="chooseEmpToTrain?train_no=${train.train_no}">添加</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
