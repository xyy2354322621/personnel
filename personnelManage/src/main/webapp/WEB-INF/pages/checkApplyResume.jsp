<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/23 0023
  Time: 13:51
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
<a href="browseApplyResume?recruit_no=${sessionScope.curRecruit.recruit_no}">返回</a>
<fieldset>
    <legend>申请简历</legend>
    <form action="updateResume" method="post">
        姓名：<input name="tourist_name" disabled type="text" value="${sessionScope.applyResume.tourist_name}"><br>
        性别：<input name="tourist_name" disabled  type="text" value="${sessionScope.applyResume.gender}"><br>
        生日：<input name="birthday"  disabled type="text" value="${sessionScope.applyResume.birthday}" ><br>
        身份证号：<input name="id_no"  disabled type="text"  value="${sessionScope.applyResume.id_no}"><br>
        电话号码：<input name="phone"  disabled type="text"  value="${sessionScope.applyResume.phone}"><br>
        电子邮件：<input name="email" disabled type="email" value="${sessionScope.applyResume.email}" ><br>
        学历背景：<input name="education"  disabled type="text" value="${sessionScope.applyResume.education}" ><br>
        履历简绍：<br>
        <textarea name="introduction" disabled >${sessionScope.applyResume.introduction}</textarea><br>
    </form>
</fieldset>
</body>
</html>
