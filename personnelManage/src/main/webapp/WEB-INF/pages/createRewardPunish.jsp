<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/26 0026
  Time: 13:20
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

            var empSelect = document.getElementById("empSelect");
            empSelect.options.length=0;
            var index = data.selectedIndex;
            var depart_name=data.options[index].innerText;
            <c:forEach items="${sessionScope.employees}" var="emp">
                if (depart_name=="${emp.depart_name}"){
                    var posEmp = document.createElement("option");
                    posEmp.value=${emp.e_id};
                    posEmp.innerHTML="${emp.e_name}";
                    empSelect.appendChild(posEmp);
                }
            </c:forEach>
        }
        </c:forEach>
    }

    function posSelectChange(data) {
        var empSelect = document.getElementById("empSelect");
        empSelect.options.length=0;
        <c:forEach items="${sessionScope.employees}" var="emp">
            if (data.value==${emp.pos_no}){
            var posEmp = document.createElement("option");
            posEmp.value=${emp.e_id};
            posEmp.innerHTML="${emp.e_name}";
            empSelect.appendChild(posEmp);
            }
        </c:forEach>
    }


    </script>
</head>
<body>
<a href="manageRewardAndPunishment">返回</a>

<fieldset>
    <legend>新增奖惩</legend>
    <form action="saveRewardPunish" method="get">
        部门：<select id="dpt" onchange="departSelect(this)">
        <c:forEach items="${sessionScope.departmentPosition}" var="depart">
            <option value="${depart.depart_no}">${depart.depart_name}</option>
        </c:forEach>
    </select>
        职位：<select id="posSelect" onchange="posSelectChange(this)" name="pos_no">
            <option></option>
        <c:forEach items="${sessionScope.departmentPosition[0].positionSet}" var="pos">
            <option value="${pos.pos_no}">${pos.pos_name}</option>
        </c:forEach>
    </select>
        员工：<select id="empSelect" name="e_id">
        <c:forEach items="${sessionScope.employees}" var="emp">
            <c:if test="${emp.depart_name==sessionScope.departmentPosition[0].depart_name}">
                <option value="${emp.e_id}">${emp.e_name}</option>
            </c:if>
        </c:forEach>
    </select>选择被奖惩员工<br>
        奖惩类别：
        <select name="type">
            <option value="奖励">奖励</option>
            <option value="惩罚">惩罚</option>
        </select><br>
        奖惩原因：<br>
        <textarea name="reason"></textarea><br>
        奖惩金额：<input name="money" type="text" placeholder="输入整数(最多8位)" pattern="^[1-9]\d{0,7}$" ><br>
        <input type="submit" value="新增">
        <input type="reset" value="重置">
    </form>
</fieldset>
</body>
</html>
