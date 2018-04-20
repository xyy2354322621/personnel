<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/20 0020
  Time: 16:42
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
<fieldset>
    <legend>员工登录</legend>
    <form action="employeeLogin" method="post">
        账号：<input name="tourist_no" type="number" placeholder="请输入手机号码" pattern="^[1][3,4,5,7,8][0-9]{9}$" title="手机号不正确"><br>
        密码：<input name="pass" type="password"><br>
        <input type="submit" value="登录">
    </form>
</fieldset>
</body>
</html>
