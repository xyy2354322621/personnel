<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/22 0022
  Time: 23:12
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
    <legend>修改部门</legend>
    <form action="updateDepartment" method="get">
        部门名称：<input name="depart_name" type="text" value="${sessionScope.alterDepartment.depart_name}"><br>
        部门地址：<input name="depart_location" type="text" value="${sessionScope.alterDepartment.depart_location}"><br>
        <input type="submit" value="修改">
        <input type="reset" value="重置">
    </form>
</fieldset>

</body>
</html>
