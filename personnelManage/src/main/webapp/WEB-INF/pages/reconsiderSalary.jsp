<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/5/2 0002
  Time: 18:47
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
<a href="browseMySalary">返回</a>
<form action="saveReconsiderSalary" method="post">
    <input type="hidden" name="salary_no" value="${salary.salary_no}">
    复议金额<input type="text" name="money" pattern="^-?\d{1,7}\.?\d{1,2}"><br>
    复议说明<input type="text" name="season" ><br>
    <input type="submit" value="确定">
</form>

</body>
</html>
