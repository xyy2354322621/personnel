<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/23 0023
  Time: 11:30
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
<a href="manageRecruit">返回</a>
<div>
    <table>
        <caption>面试申请</caption>
        <tr>
            <th>申请编号</th><th>投递时间</th><th>阅读状态</th><th>面试邀请状态</th>
            <th>面试状态</th><th>录用状态</th><th>查看简历</th>
            <th>邀请面试</th><th>拒绝申请</th><th>删除申请</th>
            <th>面试记录</th><th>录用</th>
        </tr>
        <c:forEach items="${sessionScope.applies}" var="apply">
            <tr>
                <td>${apply.apply_no}</td><td>${apply.apply_time}</td>
                <td>${apply.isread}</td><td>${apply.invite}</td>
                <td>${apply.interview}</td><td>${apply.hire}</td>
                <td><a href="checkApplyResume?apply_no=${sessionScope.apply.apply_no}&resume_no=${apply.resume_no}">查看简历</a></td>
                <td>
                    <c:if test="${apply.invite=='未邀请'}">
                        <a href="inviteInterview?apply_no=${sessionScope.apply.apply_no}&recruit_no=${sessionScope.apply.recruit_no}">邀请面试</a>
                    </c:if>
                    <c:if test="${apply.invite=='已邀请'}">
                        <a href="cancerInvite?apply_no=${sessionScope.apply.apply_no}&recruit_no=${sessionScope.apply.recruit_no}">取消邀请</a>
                    </c:if>
                </td>
                <td>
                    <c:if test="${apply.invite!='同意邀请'}">
                        <a href="refuseApply?apply_no=${sessionScope.apply.apply_no}&recruit_no=${sessionScope.apply.recruit_no}">拒绝申请</a>
                    </c:if>
                </td>
                <td>
                    <c:if test="${apply.invite!='同意邀请'}">
                        <a href="deleteApply?apply_no=${sessionScope.apply.apply_no}&recruit_no=${sessionScope.apply.recruit_no}">删除申请</a>
                    </c:if>
                </td>
                <td>
                    <c:if test="${apply.invite!='同意邀请'}">
                        <a href="successInterview?apply_no=${sessionScope.apply.apply_no}&recruit_no=${sessionScope.apply.recruit_no}">面试成功</a>
                        <a href="failInterview?apply_no=${sessionScope.apply.apply_no}&recruit_no=${sessionScope.apply.recruit_no}">面试失败</a>
                    </c:if>
                </td>
                <td>
                    <c:if test="${apply.interview=='面试成功'}">
                        <a href="hireApply?apply_no=${sessionScope.apply.apply_no}&resume_no=${sessionScope.apply.resume_no}">录用</a>
                    </c:if>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
