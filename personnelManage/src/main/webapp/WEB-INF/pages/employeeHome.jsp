<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/20 0020
  Time: 17:08
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
<c:if test="${sessionScope.employee.grade!='0'}">
    <a href="manageDepartment">部门管理</a>
    <a href="managePosition">职位管理</a>
    <a href="manageEmployee">员工管理</a>
    <a href="manageRecruit">招聘管理</a>
    <a href="manageTrain">培训管理</a>
</c:if>
</body>
</html>
