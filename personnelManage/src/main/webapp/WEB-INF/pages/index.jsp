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
 <p>
     欢迎访问人事管理系统
     <a href="gotoEmployeeLogin">员工登录</a>
     <a href="gotoTouristLogin">游客登录</a>
     <a href="gotoTouristRegister">游客注册</a>
     <a href="touristVisit">游客访问</a>
 </p>
</body>
</html>