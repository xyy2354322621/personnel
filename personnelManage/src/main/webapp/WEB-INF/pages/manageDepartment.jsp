<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/20 0020
  Time: 19:03
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
<a href="createDepartment">创建部门</a>
<a href="gotoEmployeeHome">返回</a>
<div>
    <table>
        <caption>部门信息</caption>
        <tr>
            <th>部门编号</th><th>部门名称</th><th>部门地址</th>
            <th>创建时间</th><th>部门状态</th><th>修改</th>
            <th>解散</th><th>删除</th>
        </tr>
        <c:forEach items="${sessionScope.departments}" var="department">
            <tr>
                <td>${department.depart_no}</td><td>${department.depart_name}</td>
                <td>${department.depart_location}</td><td>${department.create_time}</td>
                <td>
                    <c:if test="${department.exist==1}">
                        正常
                    </c:if>
                    <c:if test="${department.exist==0}">
                        已解散
                    </c:if>
                </td>
                <td><a href="alterDepartment?pos_no=${department.depart_no}">修改</a></td>
                <td>
                    <c:if test="${department.exist==1}">
                        <a href="dissolveDepartment?pos_no=${department.depart_no}">解散</a>
                    </c:if>
                    <c:if test="${department.exist==0}">
                        <a href="recoverDepartment?pos_no=${department.depart_no}">恢复</a>
                    </c:if>

                </td>
                <td><a href="deleteDepartment?pos_no=${department.depart_no}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
