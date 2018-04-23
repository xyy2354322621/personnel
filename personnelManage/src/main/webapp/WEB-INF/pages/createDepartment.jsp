<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/20 0020
  Time: 18:36
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
<a href="manageDepartment">返回</a>

<fieldset>
    <legend>创建部门</legend>
    <form action="saveDepartment" method="get">
        部门名称：<input name="depart_name" type="text" autofocus><br>
        部门地址：<input name="depart_location" type="text" ><br>
        <input type="submit" value="创建">
        <input type="reset" value="重置">
    </form>
</fieldset>
</body>
</html>
