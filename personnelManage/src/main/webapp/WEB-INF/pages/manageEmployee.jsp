<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/23 0023
  Time: 9:02
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
    <script type="text/javascript">
        function dimission(data) {
            var reason = prompt("请输入离职原因");
            if (reason){
                window.location.href="dimission?e_id="+data.id+"&dimission_reason="+reason;
                /*var xmlHttp = new XMLHttpRequest();
                xmlHttp.open("GET","dimission?e_id="+data.id+"&dimission_reason="+reason);
                xmlHttp.send();
                xmlHttp.onreadystatechange=function (){
                }*/
            }else {
                alert("离职原因必须输入");
            }
        }
    </script>
</head>
<body>
<div>
    <table>
        <caption>所有员工</caption>
        <tr>
            <th>员工编号</th><th>姓名</th><th>性别</th><th>生日</th>
            <th>身份证号</th><th>手机号</th><th>电子邮箱</th><th>入职时间</th>
            <th>在职状态</th><th>教育背景</th><th>离职时间</th><th>离职原因</th>
            <th>所在部门</th><th>职位</th><th>权限级别</th>
            <th>调职</th><th>离职</th><th>调级</th>
        </tr>
        <c:forEach items="${sessionScope.employees}" var="employee">
            <tr>
                <td>${employee.e_id}</td><td>${employee.e_name}</td>
                <td>${employee.gender}</td><td>${employee.birthday}</td>
                <td>${employee.id_no}</td><td>${employee.phone}</td>
                <td>${employee.email}</td><td>${employee.entry_time}</td>
                <td>${employee.state}</td><td>${employee.education}</td>
                <td>${employee.dimission_time}</td><td>${employee.dimission_reason}</td>
                <td>${employee.depart_name}</td><td>${employee.pos_name}</td>
                <td>${employee.grade}</td>
                <td><a href="changePosition?e_id=${employee.e_id}">调职</a></td>
                <td><span id="${employee.e_id}" onclick="dimission(this)" style="text-decoration: underline;color: blue">离职</span></td>
                <td><a href="changeGrade?e_id=${employee.e_id}&grade=${employee.grade}">调级</a></td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
