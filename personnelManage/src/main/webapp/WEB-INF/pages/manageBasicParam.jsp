<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/27 0027
  Time: 11:17
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

<div>
    <table>
        <caption>基本参数信息</caption>
        <tr>
            <th>上班时间</th><th>下班时间</th><th>最低加班时间</th>
            <th>迟到时间限制</th><th>早退时间限制</th><th>社保比率</th><th>住房公积金比率</th>
            <th>单位罚款金额</th><th>加班奖励比率</th>
            <th>修改</th>
        </tr>

        <tr>
            <td>${basicParam.b_attend_time}</td><td>${basicParam.b_leave_time}</td>
            <td>${basicParam.b_overtime_limit}分钟</td><td>${basicParam.b_attend_time_limit}分钟</td>
            <td>${basicParam.b_leave_time_limit}分钟</td><td>${basicParam.b_social_security_ratio}%</td>
            <td>${basicParam.b_housing_fund_ratio}%</td><td>${basicParam.b_unit_penalty}元</td>
            <td>${basicParam.b_overtime_reward_radio}%</td>
            <td><a href="alterBasicParam">修改</a></td>
        </tr>
    </table>
</div>

</body>
</html>
