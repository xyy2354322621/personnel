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
<a href="browseDepartmentOps">返回</a>
<c:if test="${sessionScope.positionEmployees.size()>0}">
<div>
    <table id="empTable">
        <caption>所有员工</caption>
        <tr>
            <th>员工编号</th><th>姓名</th><th>性别</th><th>生日</th>
            <th>手机号</th><th>电子邮箱</th>
        </tr>
        <c:forEach items="${sessionScope.positionEmployees}" var="employee">
            <tr>
                <td>${employee.e_id}</td><td>${employee.e_name}</td>
                <td>${employee.gender}</td><td>${employee.birthday}</td>
                <td>${employee.phone}</td><td>${employee.email}</td>
                </tr>
        </c:forEach>
    </table>
</div>
</c:if>
</body>
</html>
