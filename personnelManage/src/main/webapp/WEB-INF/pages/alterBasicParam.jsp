<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/27 0027
  Time: 11:39
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
<a href="manageBasicParam">返回</a>

<fieldset>
    <legend>基本参数修改</legend>
    <form action="updateBasicParam" method="get">
        上班时间：<input name="b_attend_time" type="time" value="${basicParam.b_attend_time}"><br>
        下班时间：<input name="b_leave_time" type="time" value="${basicParam.b_leave_time}"><br>
        最低加班时间：<input name="overtime" type="text" value="${basicParam.b_overtime_limit}" pattern="^\d{1,4}$">分钟<br>
        迟到时间限制：<input name="attendLimit" type="text" value="${basicParam.b_attend_time_limit}" pattern="^\d{1,4}$">分钟<br>
        早退时间限制：<input name="leaveLimit" type="text" value="${basicParam.b_leave_time_limit}" pattern="^\d{1,4}$">分钟<br>
        社&nbsp&nbsp保&nbsp&nbsp比&nbsp&nbsp率：<input name="social" type="text" value="${basicParam.b_social_security_ratio}" pattern="^\d{1,3}\.?\d{1,2}$">%<br>
        住房公积比率：<input name="houseFund" type="text" value="${basicParam.b_housing_fund_ratio}" pattern="^\d{1,3}\.?\d{1,2}$">%<br>
        单位罚款金额：<input name="unitPenalty" type="text" value="${basicParam.b_unit_penalty}" pattern="^\d{1,4}$">元<br>
        加班奖励比率：<input name="overtimeReward" type="text" value="${basicParam.b_overtime_reward_radio}" pattern="^\d{1,3}\.?\d{1,2}$">%<br>

        <input type="submit" value="修改">
        <input type="reset" value="重置">
    </form>
</fieldset>
</body>
</html>
