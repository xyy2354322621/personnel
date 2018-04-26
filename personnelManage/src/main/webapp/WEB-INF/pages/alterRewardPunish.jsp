<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/26 0026
  Time: 14:04
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
<a href="manageRewardAndPunishment">返回</a>

<fieldset>
    <legend>修改奖惩</legend>
    <form action="updateRewardPunish" method="post">
        <input type="hidden" name="r_and_p_no" value="${rewardAanPunish.r_and_p_no}">
        <input type="hidden" name="e_id" value="${rewardAanPunish.e_id}">
        被奖惩人：<input type="text" value="${rewardAanPunish.e_name}" readonly>
        奖惩类别：
        <c:if test="${rewardAanPunish.type=='奖励'}">
            <select name="type">
                <option value="奖励" selected>奖励</option>
                <option value="惩罚">惩罚</option>
            </select>
        </c:if>
        <c:if test="${rewardAanPunish.type=='惩罚'}">
            <select name="type">
                <option value="奖励" >奖励</option>
                <option value="惩罚" selected>惩罚</option>
            </select>
        </c:if>
        奖惩原因：<br>
        <textarea name="reason">${rewardAanPunish.reason}</textarea>
        奖惩金额：<input name="money" type="text" value="${rewardAanPunish.money}" placeholder="输入整数(最多8位)" pattern="^[1-9]\d{0,7}$" ><br>
        奖惩日期：<input type="date" name="time" value="${rewardAanPunish.time}">
        <input type="submit" value="修改">
    </form>
</fieldset>
</body>
</html>
