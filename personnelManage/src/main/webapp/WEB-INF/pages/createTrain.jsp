<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/25 0025
  Time: 15:15
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
<a href="manageTrain">返回</a>

<fieldset>
    <legend>新开培训</legend>
    <form action="saveTrain" method="get">
        培训主题：<input name="train_name" type="text" ><br>
        培训地点：<input name="train_address" type="text" ><br>
        开始时间：<input name="start_time" type="datetime-local" ><br>
        结束时间：<input name="end_time" type="datetime-local" ><br>
        培训备注：（培训的内容及要求，对象等）<br>
        <textarea name="message"  ></textarea><br>
        <input type="submit" value="新增">
        <input type="reset" value="重置">
    </form>
</fieldset>
</body>
</html>
