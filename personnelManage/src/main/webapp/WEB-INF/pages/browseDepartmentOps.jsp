<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/5/4 0004
  Time: 9:25
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
    <script type="text/javascript" src="js/jquery-3.1.0.js"></script>
    <script type="text/javascript">
        function departSelect(data) {
            <c:forEach items="${departmentList}" var="department">
            if(data.value==${department.depart_no}){
                $("#attendTable  tr:not(:first)").html("");
                var table = document.getElementById("attendTable");
                <c:forEach items="${department.positionSet}" var="pos">
                    var row = table.insertRow();
                    var cell1=row.insertCell();
                    var cell2=row.insertCell();
                    var cell3=row.insertCell();
                    var cell4=row.insertCell();
                    var cell5=row.insertCell();
                    cell1.innerHTML="${department.depart_name}";
                    cell2.innerHTML="${department.depart_location}";
                    cell3.innerHTML="${pos.pos_name}";
                    cell4.innerHTML="${pos.basic_salary}";
                    cell5.innerHTML="<a href='posEmployee?pos_no=${pos.pos_no}'>下属员工</a> ";
                </c:forEach>
            }
            </c:forEach>
        }


    </script>
</head>
<body>
部门：<select id="dpt" onchange="departSelect(this)">
    <option></option>
    <c:forEach items="${sessionScope.departmentPosition}" var="depart">
        <option value="${depart.depart_no}">${depart.depart_name}</option>
    </c:forEach>
</select>
职位：<select id="posSelect" onchange="posSelect(this)" name="pos_no">
    <option></option>
    <c:forEach items="${sessionScope.departmentPosition[0].positionSet}" var="pos">
        <option value="${pos.pos_no}">${pos.pos_name}</option>
    </c:forEach>
</select>
<div>
    <table id="attendTable">
        <caption>部门信息</caption>
        <tr>
            <th>部门名称</th><th>部门地址</th><th>职位名称</th>
            <th>基本薪资</th><th>下属员工</th>
        </tr>

        <c:forEach items="${departmentList}" var="depart">
            <c:forEach items="${depart.positionSet}" var="pos">
                <tr>
                    <td>${depart.depart_name}</td><td>${depart.depart_location}</td>
                    <td>${pos.pos_name}</td><td>${pos.basic_salary}</td>
                    <td><a href="posEmployee?pos_no=${pos.pos_no}">下属员工</a> </td>
                </tr>
            </c:forEach>
        </c:forEach>
    </table>
</div>
</body>
</html>
