<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/20 0020
  Time: 19:13
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
    <legend>新增职位</legend>
    <form action="savePosition" method="get">
        部门选择：<select name="depart_no" style="width: 150px">
        <c:forEach items="${sessionScope.departments}" var="department">
            <option value="${department.depart_no}" selected>${department.depart_name}</option>
        </c:forEach>
        </select><br>
        职位名称：<input name="pos_name" type="text" ><br>
        基本薪资：<input name="salary" type="text" placeholder="输入整数" pattern="^[1-9]\d{0,6}$"><br>
        <input type="submit" value="新增">
        <input type="reset" value="重置">
    </form>
</fieldset>
<a href="managePosition">返回</a>
</body>
</html>
