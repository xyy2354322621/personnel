<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/24 0024
  Time: 14:16
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
    <script>
        function departSelect(data) {
            <c:forEach items="${sessionScope.departmentPosition}" var="department">
            if(data.value==${department.depart_no}){
                var posSelect = document.getElementById("posSelect");
                posSelect.options.length=0;
                <c:forEach items="${department.positionSet}" var="position">
                var posOpt = document.createElement("option");
                posOpt.value=${position.pos_no};
                posOpt.innerHTML="${position.pos_name}";
                posSelect.appendChild(posOpt);
                </c:forEach>
            }
            </c:forEach>
        }
    </script>
</head>
<body>
<form method="post" action="confirmPosition">
    部门：<select id="dpt" onchange="departSelect(this)">
        <c:forEach items="${sessionScope.departmentPosition}" var="depart">
            <option value="${depart.depart_no}">${depart.depart_name}</option>
        </c:forEach>
    </select>
    职位：<select id="posSelect" name="pos_no">
        <c:forEach items="${sessionScope.departmentPosition[0].positionSet}" var="pos">
            <option value="${pos.pos_no}">${pos.pos_name}</option>
        </c:forEach>
    </select>
    <input type="submit">
</form>
</body>
</html>
