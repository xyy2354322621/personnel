<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/20 0020
  Time: 20:03
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
<a href="createRecruit">发布招聘</a>
<a href="gotoEmployeeHome">返回</a>

<div>
    <table>
        <caption>招聘信息</caption>
        <tr>
            <th>招聘职位</th><th>所属部门</th><th>职位类别</th><th>招聘人数</th>
            <th>职位薪资</th><th>发布时间</th><th>要求描述</th>
            <th>发布状态</th><td>面试申请</td><th>状态变更</th>
            <th>修改</th><th>删除</th>
        </tr>
        <c:forEach items="${sessionScope.recruits}" var="recruit">
            <tr>
                <td>${recruit.pos_name}</td><td>${recruit.depart_name}</td><td>${recruit.position_type}</td>
                <td>${recruit.recruit_number}</td><td>${recruit.salary}</td>
                <td>${recruit.issue_time}</td>
                <td><a href="checkManageRecruit?recruit_no=${recruit.recruit_no}">点击查看</a></td>
                <td>
                    <c:if test="${recruit.issue==1}">
                        发布中
                    </c:if>
                    <c:if test="${recruit.issue==0}">
                        未发布
                    </c:if>
                </td>
                <td><a href="browseApplyResume?recruit_no=${recruit.recruit_no}">查看申请</a></td>
                <td>
                    <c:if test="${recruit.issue==1}">
                        <a href="pauseIssueRecruit?recruit_no=${recruit.recruit_no}">暂停发布</a>
                    </c:if>
                    <c:if test="${recruit.issue==0}">
                        <a href="recoverIssueRecruit?recruit_no=${recruit.recruit_no}">发布</a>
                    </c:if>
                </td>
                <td><a href="alterRecruit?recruit_no=${recruit.recruit_no}">修改</a></td>
                <td><a href="deleteRecruit?recruit_no=${recruit.recruit_no}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
