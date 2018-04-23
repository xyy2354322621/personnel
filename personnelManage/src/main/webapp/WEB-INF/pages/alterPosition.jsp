<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/22 0022
  Time: 22:08
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
<a href="managePosition">返回</a>
<fieldset>
    <legend>修改职位</legend>
    <form action="updatePosition" method="get">
        职位名称：<input name="pos_name" type="text" value="${sessionScope.alterPosition.pos_name}"><br>
        基本薪资：<input name="salary" type="text" value="${sessionScope.alterPosition.basic_salary}" pattern="^[1-9]\d{0,6}$"><br>
        <input type="submit" value="修改">
        <input type="reset" value="重置">
    </form>
</fieldset>
</body>

</html>
