<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/25 0025
  Time: 15:30
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
<a href="managePosition">返回</a>

<fieldset>
    <legend>修改培训</legend>
    <form action="updateTrain" method="get">
        <input type="hidden" name="train_no" value="${train.train_no}">
        培训名称：<input name="train_name" type="text" value="${train.train_name}"><br>
        培训地点：<input name="train_address" type="text" value="${train.train_address}"><br>
        开始时间：<input name="start_time" type="datetime-local" value="${train.start_time}"><br>
        结束时间：<input name="end_time" type="datetime-local" value="${train.end_time}"><br>
        培训备注：<textarea name="message"  ></textarea><br>
        <input type="submit" value="新增">
        <input type="reset" value="重置">
    </form>
</fieldset>
<body>

</body>
</html>
