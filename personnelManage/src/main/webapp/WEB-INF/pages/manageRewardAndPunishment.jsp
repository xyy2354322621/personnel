<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/26 0026
  Time: 11:12
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
<a href="createRewardPunish">新增奖惩</a>
<div>
    <table>
        <caption>奖惩信息</caption>
        <tr>
            <th>员工编号</th><th>员工姓名</th><th>奖惩类别</th><th>奖惩原因</th>
            <th>奖惩金额</th><th>奖惩时间</th><th>执行状态</th>
            <th>是否执行</th>
            <th>修改</th><th>删除</th>
        </tr>
        <c:forEach items="${rewardAanPunishList}" var="rewardPunish">
            <tr>
                <td>${rewardPunish.e_id}</td><td>${rewardPunish.e_name}</td>
                <td>${rewardPunish.type}</td>
                <td>${rewardPunish.reason}</td><td>${rewardPunish.money}</td>
                <td>${rewardPunish.time}</td>
                <td>
                    <c:if test="${rewardPunish.exist==1}">
                        执行中
                    </c:if>
                    <c:if test="${rewardPunish.exist==0}">
                        已取消
                    </c:if>
                </td>
                <td>
                    <c:if test="${rewardPunish.exist==1}">
                        <a href="cancerRewardPunish?r_and_p_no=${rewardPunish.r_and_p_no}">取消</a>
                    </c:if>
                    <c:if test="${rewardPunish.exist==0}">
                        <a href="executeRewardPunish?r_and_p_no=${rewardPunish.r_and_p_no}">执行</a>
                    </c:if>
                </td>
                <td>
                    <a href="alterRewardPunish?r_and_p_no=${rewardPunish.r_and_p_no}">修改</a>
                </td>
                <td><a href="deleteRewardPunish?r_and_p_no=${rewardPunish.r_and_p_no}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
