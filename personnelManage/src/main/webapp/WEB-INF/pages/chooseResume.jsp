<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/21 0021
  Time: 18:38
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
<a href="createResume">创建简历</a>
<a href="manageResume">修改简历</a>
<div>
    <table>
        <caption>我的简历</caption>
        <tr>
            <th>简历编号</th><th>姓名</th><th>生日</th>
            <th>身份证号</th><th>手机号</th><th>电子邮箱</th>
            <th>教育背景</th><th>个人履历简绍</th><th>投递</th>
        </tr>
        <c:forEach items="${sessionScope.myResumes}" var="resume">
            <tr>
                <td>${resume.resume_no}</td><td>${resume.tourist_name}</td>
                <td>${resume.birthday}</td><td>${resume.id_no}</td>
                <td>${resume.phone}</td><td>${resume.email}</td>
                <td>${resume.education}</td>
                <td><a href="checkResume?resume_no=${resume.resume_no}">点击查看</a></td>
                <td><a href="sendResume?resume_no=${resume.resume_no}">投递</a> </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
