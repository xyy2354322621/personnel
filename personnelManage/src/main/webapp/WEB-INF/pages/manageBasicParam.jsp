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
            <th>迟到时间限制</th><th>早退时间限制</th><th>每月工作天数</th>
            <th>个人社保比率</th><th>公司缴纳社保比率</th>
            <th>单位罚款金额</th><th>加班奖励比率</th><th>个税起征金额</th>
            <th>事假付薪比率</th><th>病假付薪比率</th><th>婚假付薪比率</th>
            <th>产假付薪比率</th><th>丧假付薪比率</th><th>年假付薪比率</th>
            <th>公假付薪比率</th><th>旷工付薪比率</th>
            <th>修改</th>
        </tr>

        <tr>
            <td>${basicParam.b_attend_time}</td><td>${basicParam.b_leave_time}</td>
            <td>${basicParam.b_overtime_limit}分钟</td><td>${basicParam.b_attend_time_limit}分钟</td>
            <td>${basicParam.b_leave_time_limit}分钟</td><td>${basicParam.b_workdays_month}天</td>
            <td>${basicParam.b_social_security_ratio}%</td>
            <td>${basicParam.b_company_pay_social}%</td><td>${basicParam.b_unit_penalty}元/分钟</td>
            <td>${basicParam.b_overtime_reward_radio}%</td>
            <td>${basicParam.b_tax_threshold}元</td>
            <td>${basicParam.person_leave_pay_ratio}%</td><td>${basicParam.sick_leave_pay_ratio}%</td>
            <td>${basicParam.marriage_leave_pay_ratio}%</td><td>${basicParam.maternity_leave_pay_ratio}%</td>
            <td>${basicParam.funeral_leave_pay_ratio}%</td><td>${basicParam.annual_leave_pay_ratio}%</td>
            <td>${basicParam.public_leave_pay_ratio}%</td><td>${basicParam.absenteeism_punish_ratio}%</td>
            <td><a href="alterBasicParam">修改</a></td>
        </tr>
    </table>
</div>

</body>
</html>
