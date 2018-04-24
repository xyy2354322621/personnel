<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/23 0023
  Time: 16:01
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
<a href="recruit">返回</a>
<div>
    <table>
        <caption>面试申请</caption>
        <tr>
            <th>申请编号</th><th>投递时间</th><th>阅读状态</th><th>面试邀请状态</th>
            <th>面试状态</th><th>录用状态</th><th>面试答复</th><%--<th>删除</th>--%>
        </tr>
        <c:forEach items="${sessionScope.myApplies}" var="apply">
            <tr>
                <td>${apply.apply_no}</td><td>${apply.apply_time}</td>
                <td>${apply.isRead}</td><td>${apply.invite}</td>
                <td>${apply.interview}</td><td>${apply.hire}</td>
                <%--<td><a href="checkApplyRecruit?recruit_no=${apply.recruit_no}">查看招聘</a></td>--%>
                <td>
                    <c:if test="${apply.invite=='已邀请'}">
                        <a href="agreeInvite?apply_no=${apply.apply_no}&recruit_no=${apply.recruit_no}">同意面试</a>
                        <a href="refuseInvite?apply_no=${apply.apply_no}&recruit_no=${apply.recruit_no}">拒绝面试</a>
                    </c:if>
                </td>
                <%--<td>
                    <c:if test="${apply.invite=='拒绝申请'}">
                    <a href="refuseInvite?apply_no=${apply.apply_no}">删除</a>
                    </c:if>
                </td>--%>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
