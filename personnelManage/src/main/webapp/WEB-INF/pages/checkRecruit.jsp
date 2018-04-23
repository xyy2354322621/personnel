<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/21 0021
  Time: 21:09
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
        <tr>
            <td>招聘职位</td><td>${sessionScope.checkRecruit.position}</td>
            <td>职位类别</td><td>${sessionScope.checkRecruit.position_type}</td>
        </tr>
        <tr>
            <td>职位薪资</td><td>${sessionScope.checkRecruit.salary}</td>
            <td>招聘人数</td><td>${sessionScope.checkRecruit.recruit_number}</td>
        </tr>
    </table>
    <table>
        <caption>岗位要求</caption>
        <tr><td>${sessionScope.checkRecruit.description}</td></tr>
    </table>
    <a href="applyPosition?recruit_no=${sessionScope.checkRecruit.recruit_no}">申请职位</a>
</div>
</body>
</html>
