<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/21 0021
  Time: 22:00
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
<a href="manageResume">返回</a>

<fieldset>
    <legend>创建简历</legend>
    <form action="saveResume" method="post">
        姓名：<input name="tourist_name" type="text" ><br>
        性别：<input name="gender" type="radio" value="男" checked>男
        <input name="gender" type="radio" value="女" >女<br>
        生日：<input name="birthday" type="date" ><br>
        身份证号：<input name="id_no" type="text"  ><br>
        电话号码：<input name="phone" type="text"  ><br>
        电子邮件：<input name="email" type="email"  ><br>
        学历背景：<input name="education" type="text"  ><br>
        履历简绍：<br>
        <textarea name="introduction"></textarea><br>
        <input type="submit" value="保存">
        <input type="reset" value="重置">
    </form>
</fieldset>
<a href="manageResume">返回</a>
</body>
</html>
