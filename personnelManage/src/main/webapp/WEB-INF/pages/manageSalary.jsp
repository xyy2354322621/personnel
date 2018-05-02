<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/29 0029
  Time: 21:48
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
                <c:forEach items="${salaryList}" var="salary">
                var index = data.selectedIndex;
                if (data.options[index].innerHTML=="${salary.depart_name}"){
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
                    cell1.innerHTML="${salary.e_id}";
                    cell2.innerHTML="${salary.e_name}";
                    cell3.innerHTML="${salary.depart_name}";
                    cell4.innerHTML="${salary.pos_name}";
                    cell5.innerHTML="${salary.salary_month}";
                    cell6.innerHTML="${salary.basic_salary}";
                    cell7.innerHTML="${salary.performance}";
                    cell8.innerHTML="${salary.overtime_pay}";
                    cell9.innerHTML="${salary.reward_money}";
                    cell10.innerHTML="${salary.punish_money}";
                    cell11.innerHTML="${salary.basic_salary+salary.performance+salary.overtime_pay+salary.reward_money-salary.punish_money}";
                    cell12.innerHTML="${salary.income_tax}";
                    cell13.innerHTML="${salary.social_security}";
                    cell14.innerHTML="${salary.company_social}";
                    cell15.innerHTML="${salary.net_payroll}";
                    cell16.innerHTML="${salary.payoff}";
                    cell17.innerHTML="<input type='button' value='调整绩效' onclick='changePerformance(this)' id='pfm' name='${salary.salary_no}'>";
                }
                </c:forEach>
            }
            </c:forEach>
        }

        function posSelect(date) {
            $("#empTable  tr:not(:first)").html("");
            var table = document.getElementById("empTable");
            <c:forEach items="${salaryList}" var="salary">
            if (date.value=="${salary.pos_no}"){
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
                cell1.innerHTML="${salary.e_id}";
                cell2.innerHTML="${salary.e_name}";
                cell3.innerHTML="${salary.depart_name}";
                cell4.innerHTML="${salary.pos_name}";
                cell5.innerHTML="${salary.salary_month}";
                cell6.innerHTML="${salary.basic_salary}";
                cell7.innerHTML="${salary.performance}";
                cell8.innerHTML="${salary.overtime_pay}";
                cell9.innerHTML="${salary.reward_money}";
                cell10.innerHTML="${salary.punish_money}";
                cell11.innerHTML="${salary.basic_salary+salary.performance+salary.overtime_pay+salary.reward_money-salary.punish_money}";
                cell12.innerHTML="${salary.income_tax}";
                cell13.innerHTML="${salary.social_security}";
                cell14.innerHTML="${salary.company_social}";
                cell15.innerHTML="${salary.net_payroll}";
                cell16.innerHTML="${salary.payoff}";
                cell17.innerHTML="<input type='button' value='调整绩效' onclick='changePerformance(this)' id='pfm' name='${salary.salary_no}'>";
            }
            </c:forEach>
        }
    </script>
</head>
<body>
<a href="gotoEmployeeHome">返回</a>
<a href="createPrevMonthSalary">生成上月工资单</a>
<a href="createCurMonthSalary">生成当月工资单</a>
<form method="post" action="manageSalary">
    选择月份<input type="month" name="month" value="${month}">
    <input type="submit" value="查看工资单">
</form>
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
        <caption>薪资</caption>
        <tr>
            <th>员工编号</th><th>姓名</th><th>所在部门</th><th>职位</th>
            <th>计薪月份</th><th>基本薪资</th><th>当月绩效</th><th>加班费用</th>
            <th>当月奖励</th><th>当月惩罚</th><th>薪资总额</th><th>所得税</th>
            <th>个人应缴社保</th><th>公司代缴社保</th><th>实发工资</th><th>发放状态</th>
            <th>调整绩效</th>
        </tr>
        <c:forEach items="${salaryList}" var="salary">
            <tr>
                <td>${salary.e_id}</td><td>${salary.e_name}</td>
                <td>${salary.depart_name}</td><td>${salary.pos_name}</td>
                <td>${salary.salary_month}</td><td>${salary.basic_salary}</td>
                <td>${salary.performance}</td><td>${salary.overtime_pay}</td>
                <td>${salary.reward_money}</td><td>${salary.punish_money}</td>
                <td>${salary.basic_salary+salary.performance+salary.overtime_pay+salary.reward_money-salary.punish_money}</td>
                <td>${salary.income_tax}</td><td>${salary.social_security}</td>
                <td>${salary.company_social}</td><td>${salary.net_payroll}</td>
                <td>${salary.payoff}</td>
                <td><input type="button" value="调整绩效" onclick="changePerformance(this)" id="pfm" name="${salary.salary_no}"></td>
            </tr>
        </c:forEach>
    </table>

</div>
<script>
    function changePerformance(date) {
        var performance = prompt("请输入此员工该月的绩效奖金");
        if (performance){
            window.location.href="changeEmpSalaryPerformance?salary_no="+date.name+"&perform="+performance;
        }
    }
</script>
</body>
</html>
