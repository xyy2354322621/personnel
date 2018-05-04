<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/22 0022
  Time: 10:02
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
<a href="chooseResume">返回</a>
<div>
    <table>
        <caption>我的简历</caption>
        <tr>
            <th>简历编号</th><th>姓名</th><th>生日</th>
            <th>身份证号</th><th>手机号</th><th>电子邮箱</th>
            <th>学历</th><th>毕业院校</th><th>投递</th>
        </tr>
        <tr>
            <td>${sessionScope.checkResume.resume_no}</td><td>${sessionScope.checkResume.tourist_name}</td>
            <td>${sessionScope.checkResume.birthday}</td><td>${sessionScope.checkResume.id_no}</td>
            <td>${sessionScope.checkResume.phone}</td><td>${sessionScope.checkResume.email}</td>
            <td>${sessionScope.checkResume.education}</td><td>${sessionScope.checkResume.graduate_academy}</td>
            <td> <a href="sendResume?resume_no=${sessionScope.checkResume.resume_no}">投递</a></td>
        </tr>
    </table>
    自我简绍：<br>
    <textarea name="introduction">${sessionScope.checkResume.introduction}</textarea><br>
    教育经历：<br>
    <textarea name="education_background">${sessionScope.checkResume.education_background}</textarea><br>
    工作经历：<br>
    <textarea name="employment_record">${sessionScope.checkResume.employment_record}</textarea><br>
    项目经验：<br>
    <textarea name="project_experience">${sessionScope.checkResume.project_experience}</textarea><br>
    <a href="sendResume?resume_no=${sessionScope.checkResume.resume_no}">投递</a>
</div>
</body>
</html>
