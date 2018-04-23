<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/22 0022
  Time: 11:48
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
<a href="manageResume">返回</a>
<div>
    <table>
        <tr>
            <td>简历编号</td><td>${sessionScope.checkResume.resume_no}</td>
            <td>姓名</td><td>${sessionScope.checkResume.tourist_name}</td>
        </tr>
        <tr>
            <td>生日</td><td>${sessionScope.checkResume.birthday}</td>
            <td>身份证号</td><td>${sessionScope.checkResume.id_no}</td>
        </tr>
        <tr>
            <td>电话</td><td>${sessionScope.scanResume.phone}</td>
            <td>电子邮箱</td><td>${sessionScope.scanResume.email}</td>
        </tr>
        <tr>
            <td>性别</td><td>${sessionScope.scanResume.gender}</td>
            <td>学历背景</td><td>${sessionScope.scanResume.education}</td>
        </tr>
    </table>
    <table>
        <caption>履历简绍</caption>
        <tr><td>${sessionScope.scanResume.introduction}</td></tr>
    </table>
    <a href="alterResume?resume_no=${sessionScope.scanResume.resume_no}">修改简历</a>
    <a href="deleteResume?resume_no=${sessionScope.scanResume.resume_no}">删除简历</a>
</div>
</body>
</html>
