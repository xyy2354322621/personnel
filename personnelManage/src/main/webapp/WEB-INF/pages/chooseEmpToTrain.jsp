<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/25 0025
  Time: 16:53
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
            <c:forEach items="${sessionScope.departmentPosition}" var="department">
            if(data.value==${department.depart_no}){
                var posSelect = document.getElementById("posSelect");
                posSelect.options.length=0;
                var posOpt1 = document.createElement("option");
                posSelect.appendChild(posOpt1);
                <c:forEach items="${department.positionSet}" var="position">
                var posOpt = document.createElement("option");
                posOpt.value=${position.pos_no};
                posOpt.innerHTML="${position.pos_name}";
                posSelect.appendChild(posOpt);
                </c:forEach>

                $("#empTable  tr:not(:first)").html("");
                var table = document.getElementById("empTable");
                <c:forEach items="${sessionScope.TrainEmployees}" var="emp">
                var index = data.selectedIndex;
                if (data.options[index].innerHTML=="${emp.depart_name}"){
                    var row = table.insertRow();
                    var cell1=row.insertCell();
                    var cell2=row.insertCell();
                    var cell3=row.insertCell();
                    var cell4=row.insertCell();
                    var cell5=row.insertCell();
                    var cell6=row.insertCell();
                    cell1.innerHTML="${emp.e_id}";
                    cell2.innerHTML="${emp.e_name}";
                    cell3.innerHTML="${emp.gender}";
                    cell4.innerHTML="${emp.depart_name}";
                    cell5.innerHTML="${emp.pos_name}";
                    cell6.innerHTML="<input name='chosenEmp' type='checkbox' value='${emp.e_id}'>选择";

                }
                </c:forEach>
            }
            </c:forEach>
        }

        function posSelect(date) {
            $("#empTable  tr:not(:first)").html("");
            var table = document.getElementById("empTable");
            <c:forEach items="${sessionScope.TrainEmployees}" var="emp">
            if (date.value=="${emp.pos_no}"){
                var row = table.insertRow();
                var cell1=row.insertCell();
                var cell2=row.insertCell();
                var cell3=row.insertCell();
                var cell4=row.insertCell();
                var cell5=row.insertCell();
                var cell6=row.insertCell();
                cell1.innerHTML="${emp.e_id}";
                cell2.innerHTML="${emp.e_name}";
                cell3.innerHTML="${emp.gender}";
                cell4.innerHTML="${emp.depart_name}";
                cell5.innerHTML="${emp.pos_name}";
                cell6.innerHTML="<input name='chosenEmp' type='checkbox' value='${emp.e_id}'>选择";
               }
            </c:forEach>
        }
    </script>
</head>
<body>
<a href="manageTrain">返回</a>

部门：<select id="dpt" onchange="departSelect(this)">
    <c:forEach items="${sessionScope.departmentPosition}" var="depart">
        <option value="${depart.depart_no}">${depart.depart_name}</option>
    </c:forEach>
</select>
职位：<select id="posSelect" onchange="posSelect(this)" name="pos_no">
    <c:forEach items="${sessionScope.departmentPosition[0].positionSet}" var="pos">
        <option value="${pos.pos_no}">${pos.pos_name}</option>
    </c:forEach>
</select>

<div>
    <form method="post" action="addEmpToTrain">
        <input type="hidden" name="train_no" value="${train.train_no}">
    <table id="empTable">
        <caption>员工</caption>
        <tr>
            <th>员工编号</th><th>姓名</th><th>性别</th>
            <th>所在部门</th><th>职位</th>
            <th>选择</th>
        </tr>
        <c:forEach items="${sessionScope.TrainEmployees}" var="employee">
            <tr>
                <td>${employee.e_id}</td><td>${employee.e_name}</td>
                <td>${employee.gender}</td>
                <td>${employee.depart_name}</td><td>${employee.pos_name}</td>
                <td><input name="chosenEmp" type="checkbox" value="${employee.e_id}">选择</td>
                </tr>
        </c:forEach>
    </table>
        <input type="submit" value="确定">
    </form>
</div>
</body>
</html>
