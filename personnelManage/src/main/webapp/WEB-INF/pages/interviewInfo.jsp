<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/23 0023
  Time: 14:59
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
<form action="sendInvite" method="post">
    面试信息：（时间和地点）
    <textarea name="interview_info"></textarea>
    <input type="submit">
</form>
</body>
</html>
