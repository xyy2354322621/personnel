<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/24 0024
  Time: 21:04
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
<a href="managePosition">返回</a>
<div>
    <table id="empTable">
        <caption>所有员工</caption>
        <tr>
            <th>员工编号</th><th>姓名</th><th>性别</th><th>生日</th>
            <th>身份证号</th><th>手机号</th><th>电子邮箱</th><th>入职时间</th>
            <th>在职状态</th><th>教育背景</th>
            <th>所在部门</th><th>职位</th>
        </tr>
        <c:forEach items="${sessionScope.positionEmployees}" var="employee">
            <tr>
                <td>${employee.e_id}</td><td>${employee.e_name}</td>
                <td>${employee.gender}</td><td>${employee.birthday}</td>
                <td>${employee.id_no}</td><td>${employee.phone}</td>
                <td>${employee.email}</td><td>${employee.entry_time}</td>
                <td>${employee.state}</td><td>${employee.education}</td>
                <td>${employee.depart_name}</td><td>${employee.pos_name}</td>
                </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
