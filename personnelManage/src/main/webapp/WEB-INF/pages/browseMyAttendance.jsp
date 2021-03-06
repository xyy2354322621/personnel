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
<a href="gotoEmployeeHome">返回</a>
<a href="browseMyAttendApplies">我的申请</a>
<form method="post" action="browseMyAttendance">
    选择月份：<input id="month" type="month" name="month" value=${sessionScope.curMonth}>
    <input id="ba" type="submit" value="查看考勤">
</form>
<div>
    <table id="attendTable">
        <caption>考勤信息</caption>
        <tr>
            <th>上班时间</th><th>下班时间</th><th>加班时间</th>
            <th>迟到时间</th><th>早退时间</th><th>考勤日期</th>
            <th>事假</th><th>病假</th><th>旷工</th><th>年假</th><th>婚假</th>
            <th>产假</th><th>丧假</th><th>公假</th>
            <th>上班忘打卡</th><th>下班忘打卡</th><th>请假</th>
        </tr>

        <c:forEach items="${myAttendances}" var="attend">
            <tr>
                <td>${attend.attend_time}</td>
                <td>${attend.leave_time}</td><td>${attend.overtime}分钟</td><td>${attend.be_late}分钟</td>
                <td>${attend.leave_early}分钟</td><td>${attend.date}</td><td>${attend.person_leave}小时</td>
                <td>${attend.sick_leave}小时</td><td>${attend.absenteeism}天</td><td>${attend.annual_leave}天</td><td>${attend.marriage_leave}天</td>
                <td>${attend.maternity_leave}天</td><td>${attend.funeral_leave}天</td><td>${attend.public_leave}天</td>
                <td>
                    <c:if test="${attend.attend_time==null}">
                        <a href="forgetClockIn?attend_no=${attend.attend_no}">申请</a>
                    </c:if>
                </td>
                <td>
                    <c:if test="${attend.leave_time==null}">
                        <a href="forgetClockOut?attend_no=${attend.attend_no}">申请</a>
                    </c:if>
                </td>
                <td>
                    <c:if test="${attend.person_leave==0 && attend.sick_leave==0 && attend.annual_leave==0
                    && attend.maternity_leave==0 && attend.marriage_leave==0 && attend.funeral_leave==0
                    && attend.public_leave==0}">
                        <a href="applyLeave?attend_no=${attend.attend_no}">请假</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
