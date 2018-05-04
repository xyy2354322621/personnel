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
<c:if test="${sessionScope.train==0}">
    您有新的培训通知未查看，请点击《我的培训》菜单查看
</c:if>
<br>
<c:if test="${sessionScope.employee.grade!='0'}">
    <a href="manageDepartment">部门管理</a>
    <a href="managePosition">职位管理</a>
    <a href="manageEmployee">员工管理</a>
    <a href="manageRecruit">招聘管理</a>
    <a href="manageTrain">培训管理</a>
    <a href="manageSalary">薪资管理</a>
    <a href="manageAttendance">考勤管理</a>
    <a href="manageRewardAndPunishment">奖惩管理</a>
    <a href="manageBasicParam">基本参数管理</a>
    <a href="manageTaxRate">个税税率管理</a>
    <br>
</c:if>
<c:if test="${sessionScope.clockIn==0 && sessionScope.leaveTimeGap<0}">
    <a href="clockIn">上班打卡</a>
</c:if>
<c:if test="${sessionScope.clockIn==0 && sessionScope.leaveTimeGap>0}">
    <a href="clockOut">下班打卡</a>
</c:if>
<c:if test="${sessionScope.clockIn!=0 && sessionScope.clockOut==0}">
    <a href="clockOut">下班打卡</a>
</c:if>
<c:if test="${sessionScope.clockIn!=0 && sessionScope.clockOut!=0}">
    <a href="clockOut">更新下班打卡</a>
</c:if>
<a href="browseMyAttendance">我的考勤</a>
<a href="browseMySalary">我的工资</a>
<a href="browseMyTrain">我的培训</a>
<a href="browseMyRP">我的奖惩</a>
<a href="browseDepartmentOps">公司部门职位</a>
</body>
</html>
