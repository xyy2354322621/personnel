<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/26 0026
  Time: 8:45
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
<form method="post" action="updateTrainRecord">
    <input type="hidden" name="train_record_no" value="${trainRecord.train_record_no}">
    <input type="hidden" name="train_no" value="${trainRecord.train_no}">
    员工编号：<input type="text" name="e_id" value="${trainRecord.e_id}" readonly><br>
    员工姓名：<input type="text" name="e_name" value="${trainRecord.e_name}" readonly><br>
    出勤记录：（在原有基础上修改，否则原记录将被覆盖）<br>
    <textarea name="attend" >${trainRecord.attend}</textarea><br>
    考核记录：<input type="text" name="examine" value="${trainRecord.examine}" ><br>
    <input type="submit" value="修改提交">
</form>
<body>

</body>
</html>
