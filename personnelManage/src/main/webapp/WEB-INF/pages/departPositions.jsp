<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/24 0024
  Time: 21:26
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
<div>
    <table>
        <caption>职位信息</caption>
        <tr>
            <th>职位编号</th><th>职位名称</th><th>所属部门</th>
            <th>基本薪资</th><th>职位状态</th><th>下属员工</th>
        </tr>
        <c:forEach items="${sessionScope.departPositions}" var="position">
            <tr>
                <td>${position.pos_no}</td><td>${position.pos_name}</td>
                <td>${position.depart_name}</td><td>${position.basic_salary}</td>
                <td>
                    <c:if test="${position.exist==1}">
                        使用中
                    </c:if>
                    <c:if test="${position.exist==0}">
                        已废弃
                    </c:if>
                </td>
                <td><a href="positionEmployee?pos_no=${position.pos_no}">下属员工</a></td>
        </c:forEach>
    </table>
</div>
</body>
</html>
