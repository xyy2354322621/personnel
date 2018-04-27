<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/27 0027
  Time: 14:33
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
<a href="createTodayAttendance">生成今日考勤</a>
<a href="createTomorrowAttendance">生成明日考勤</a>

<div>
    <table>
        <caption>考勤信息</caption>
        <tr>
            <th>考勤编号</th><th>员工编号</th><th>员工姓名</th>
            <th>所在部门</th><th>员工职位</th>
            <th>上班时间</th><th>下班时间</th><th>加班时间</th>
            <th>迟到时间</th><th>早退时间</th><th>考勤日期</th>
            <th>事假</th><th>病假</th>
            <th>年假</th><th>婚假</th><th>产假</th>
            <th>假期设置</th>
        </tr>

        <c:forEach items="${attendanceList}" var="attend">
            <tr>
                <td>${attend.attend_no}</td><td>${attend.e_id}</td><td>${attend.e_name}</td>
                <td>${attend.depart_name}</td><td>${attend.pos_name}</td><td>${attend.attend_time}</td>
                <td>${attend.leave_time}</td><td>${attend.overtime}</td><td>${attend.be_late}</td>
                <td>${attend.leave_early}</td><td>${attend.date}</td><td>${attend.person_leave}</td>
                <td>${attend.sick_leave}</td><td>${attend.annual_leave}</td><td>${attend.marriage_leave}</td>
                <td>${attend.maternity_leave}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
