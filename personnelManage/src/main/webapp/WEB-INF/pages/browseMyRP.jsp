<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/5/4 0004
  Time: 10:05
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
<form method="post" action="manageSalary">
    选择月份<input type="month" name="month" value="${month}">
    <input type="submit" value="查看奖惩">
</form>
<div>
    <table>
        <caption>奖惩信息</caption>
        <tr>
            <th>奖惩编号</th><th>奖惩类别</th><th>奖惩原因</th>
            <th>奖惩金额</th><th>奖惩时间</th><th>执行状态</th>
        </tr>
        <c:forEach items="${myRP}" var="rewardPunish">
            <tr><td>${rewardPunish.r_and_p_no}</td>
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
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
