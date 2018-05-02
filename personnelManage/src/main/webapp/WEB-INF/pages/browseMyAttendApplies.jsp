<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/28 0028
  Time: 17:53
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
<a href="browseMyAttendance">返回</a>
<form method="post" action="browseMyAttendApplies">
    选择月份：<input id="month" type="month" name="month" value=${sessionScope.curMonth}>
    <input id="ba" type="submit" value="查看申请">
</form>
<div>
    <table id="attendTable">
        <caption>申请信息</caption>
        <tr>
            <th>申请日期</th><th>上班忘打卡</th><th>下班忘打卡</th>
            <th>事假</th><th>病假</th><th>年假</th><th>婚假</th>
            <th>产假</th><th>丧假</th><th>审批情况</th>
        </tr>

        <c:forEach items="${myAttendApplies}" var="attend">
            <tr>
                <td>${attend.date}</td><td>${attend.forget_clock_in}</td>
                <td>${attend.forget_clock_out}</td><td>${attend.person_leave}小时</td>
                <td>${attend.sick_leave}小时</td><td>${attend.annual_leave}天</td>
                <td>${attend.marriage_leave}天</td>
                <td>${attend.maternity_leave}天</td><td>${attend.funeral_leave}天</td>
                <td>${attend.approve}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
