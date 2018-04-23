<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/22 0022
  Time: 12:09
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
<fieldset>
    <legend>修改简历</legend>
    <form action="updateResume" method="post">
        姓名：<input name="tourist_name" type="text" value="${sessionScope.alterResume.tourist_name}"><br>
        <c:if test="${sessionScope.alterResume.gender=='男'}">
            性别：<input name="gender" type="radio" value="男" checked>男
            <input name="gender" type="radio" value="女" >女<br>
        </c:if>
        <c:if test="${sessionScope.alterResume.gender=='女'}">
            性别：<input name="gender" type="radio" value="男" >男
            <input name="gender" type="radio" value="女" checked>女<br>
        </c:if>
        生日：<input name="birthday" type="text" value="${sessionScope.alterResume.birthday}" ><br>
        身份证号：<input name="id_no" type="text"  value="${sessionScope.alterResume.id_no}"><br>
        电话号码：<input name="phone" type="text"  value="${sessionScope.alterResume.phone}"><br>
        电子邮件：<input name="email" type="email" value="${sessionScope.alterResume.email}" ><br>
        学历背景：<input name="education" type="text" value="${sessionScope.alterResume.education}" ><br>
        履历简绍：<br>
        <textarea name="introduction">${sessionScope.alterResume.introduction}</textarea><br>
        <input type="submit" value="修改">
    </form>
</fieldset>
</body>
</html>
