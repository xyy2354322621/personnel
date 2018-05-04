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
        <caption>我的简历</caption>
        <tr>
            <th>简历编号</th><th>姓名</th><th>生日</th>
            <th>身份证号</th><th>手机号</th><th>电子邮箱</th>
            <th>学历</th><th>毕业院校</th>
            <th>删除简历</th><th>修改简历</th>
        </tr>
        <tr>
            <td>${sessionScope.scanResume.resume_no}</td><td>${sessionScope.scanResume.tourist_name}</td>
            <td>${sessionScope.scanResume.birthday}</td><td>${sessionScope.scanResume.id_no}</td>
            <td>${sessionScope.scanResume.phone}</td><td>${sessionScope.scanResume.email}</td>
            <td>${sessionScope.scanResume.education}</td><td>${sessionScope.scanResume.graduate_academy}</td>
            <td><a href="alterResume?resume_no=${sessionScope.scanResume.resume_no}">修改简历</a></td>
            <td><a href="deleteResume?resume_no=${sessionScope.scanResume.resume_no}">删除简历</a></td>
        </tr>
    </table>
    自我简绍：<br>
    <textarea name="introduction">${sessionScope.scanResume.introduction}</textarea><br>
    教育经历：<br>
    <textarea name="education_background">${sessionScope.scanResume.education_background}</textarea><br>
    工作经历：<br>
    <textarea name="employment_record">${sessionScope.scanResume.employment_record}</textarea><br>
    项目经验：<br>
    <textarea name="project_experience">${sessionScope.scanResume.project_experience}</textarea><br>
    <a href="alterResume?resume_no=${sessionScope.scanResume.resume_no}">修改简历</a>
    <a href="deleteResume?resume_no=${sessionScope.scanResume.resume_no}">删除简历</a>
</div>
</body>
</html>
