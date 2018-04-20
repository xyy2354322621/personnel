<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/20 0020
  Time: 14:20
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
    <legend>游客注册</legend>
    <form action="touristRegister" method="get">
        账号：<input name="tourist_no" type="text" placeholder="请输入手机号码" pattern="^[1][3,4,5,7,8][0-9]{9}$" ><br>
        密码：<input name="pass"><br>
        密码：<input name="rePass" placeholder="确认密码"><br>
        <input type="submit" value="注册">
    </form>
</fieldset>
</body>
</html>
