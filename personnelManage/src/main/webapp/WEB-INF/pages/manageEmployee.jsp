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
    <script type="text/javascript" src="js/jquery-3.1.0.js"></script>
    <script type="text/javascript">
        function dimission(data) {
            var reason = prompt("请输入离职原因");
            if (reason){
                window.location.href="dimission?e_id="+data.id+"&dimission_reason="+reason;
            }else {
                alert("离职原因必须输入");
            }
        }

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
                <c:forEach items="${sessionScope.employees}" var="emp">
                var index = data.selectedIndex;
                if (data.options[index].innerHTML=="${emp.depart_name}"){
                    var row = table.insertRow();
                    var cell1=row.insertCell();
                    var cell2=row.insertCell();
                    var cell3=row.insertCell();
                    var cell4=row.insertCell();
                    var cell5=row.insertCell();
                    var cell6=row.insertCell();
                    var cell7=row.insertCell();
                    var cell8=row.insertCell();
                    var cell9=row.insertCell();
                    var cell10=row.insertCell();
                    var cell11=row.insertCell();
                    var cell12=row.insertCell();
                    var cell13=row.insertCell();
                    var cell14=row.insertCell();
                    var cell15=row.insertCell();
                    var cell16=row.insertCell();
                    var cell17=row.insertCell();
                    var cell18=row.insertCell();
                    cell1.innerHTML="${emp.e_id}";
                    cell2.innerHTML="${emp.e_name}";
                    cell3.innerHTML="${emp.gender}";
                    cell4.innerHTML="${emp.birthday}";
                    cell5.innerHTML="${emp.id_no}";
                    cell6.innerHTML="${emp.phone}";
                    cell7.innerHTML="${emp.email}";
                    cell8.innerHTML="${emp.entry_time}";
                    cell9.innerHTML="${emp.state}";
                    cell10.innerHTML="${emp.education}";
                    cell11.innerHTML="${emp.dimission_time}";
                    cell12.innerHTML="${emp.dimission_reason}";
                    cell13.innerHTML="${emp.depart_name}";
                    cell14.innerHTML="${emp.pos_name}";
                    cell15.innerHTML="${emp.grade}";
                    cell16.innerHTML="<a href='changePosition?e_id=${emp.e_id}'>调职</a>";
                    cell17.innerHTML="<span id='${emp.e_id}' onclick='dimission(this)' style='text-decoration: underline;color: blue'>离职</span>";
                    cell18.innerHTML="<a href='changeGrade?e_id=${emp.e_id}&grade=${emp.grade}'>调级</a>";
                }
                </c:forEach>
            }
            </c:forEach>
        }

        function posSelect(date) {
            $("#empTable  tr:not(:first)").html("");
            var table = document.getElementById("empTable");
            <c:forEach items="${sessionScope.employees}" var="emp">
            if (date.value=="${emp.pos_no}"){
                var row = table.insertRow();
                var cell1=row.insertCell();
                var cell2=row.insertCell();
                var cell3=row.insertCell();
                var cell4=row.insertCell();
                var cell5=row.insertCell();
                var cell6=row.insertCell();
                var cell7=row.insertCell();
                var cell8=row.insertCell();
                var cell9=row.insertCell();
                var cell10=row.insertCell();
                var cell11=row.insertCell();
                var cell12=row.insertCell();
                var cell13=row.insertCell();
                var cell14=row.insertCell();
                var cell15=row.insertCell();
                var cell16=row.insertCell();
                var cell17=row.insertCell();
                var cell18=row.insertCell();
                cell1.innerHTML="${emp.e_id}";
                cell2.innerHTML="${emp.e_name}";
                cell3.innerHTML="${emp.gender}";
                cell4.innerHTML="${emp.birthday}";
                cell5.innerHTML="${emp.id_no}";
                cell6.innerHTML="${emp.phone}";
                cell7.innerHTML="${emp.email}";
                cell8.innerHTML="${emp.entry_time}";
                cell9.innerHTML="${emp.state}";
                cell10.innerHTML="${emp.education}";
                cell11.innerHTML="${emp.dimission_time}";
                cell12.innerHTML="${emp.dimission_reason}";
                cell13.innerHTML="${emp.depart_name}";
                cell14.innerHTML="${emp.pos_name}";
                cell15.innerHTML="${emp.grade}";
                cell16.innerHTML="<a href='changePosition?e_id=${emp.e_id}'>调职</a>";
                cell17.innerHTML="<span id='${emp.e_id}' onclick='dimission(this)' style='text-decoration: underline;color: blue'>离职</span>";
                cell18.innerHTML="<a href='changeGrade?e_id=${emp.e_id}&grade=${emp.grade}'>调级</a>";
            }
            </c:forEach>
        }
    </script>
</head>
<body>
<a href="gotoEmployeeHome">返回</a>
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
    <table id="empTable">
        <caption>员工</caption>
        <tr>
            <th>员工编号</th><th>姓名</th><th>性别</th><th>生日</th>
            <th>身份证号</th><th>手机号</th><th>电子邮箱</th><th>入职时间</th>
            <th>在职状态</th><th>教育背景</th><th>离职时间</th><th>离职原因</th>
            <th>所在部门</th><th>职位</th><th>权限级别</th>
            <th>调职</th><th>离职</th><th>调级</th><th>转正</th>
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
                <td>
                    <c:if test="${employee.state=='试用期'}">
                        <a href="changeToNormal?e_id=${employee.e_id}&grade=${employee.grade}">转正</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
