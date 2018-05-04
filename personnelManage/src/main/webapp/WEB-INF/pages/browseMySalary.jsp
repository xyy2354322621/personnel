<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/5/2 0002
  Time: 18:26
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
<a href="gotoEmployeeHome">返回</a>
<a href="browseMyReconsiders">我的复议</a>
<c:if test="${sessionScope.mySalary.size()>0}" >
    <div>
        <table id="salaryTable">
            <caption>薪资信息</caption>
            <tr>
                <th>计薪月份</th><th>基本薪资</th><th>当月绩效</th><th>加班费用</th>
                <th>当月奖励</th><th>当月惩罚</th><th>薪资总额</th><th>所得税</th>
                <th>个人社保</th><th>实发工资</th><th>发放状态</th><th>复议</th>
            </tr>

            <c:forEach items="${sessionScope.mySalary}" var="salary">
                <tr>
                    <td>${salary.salary_month}</td><td>${salary.basic_salary}</td>
                    <td>${salary.performance}</td><td>${salary.overtime_pay}</td>
                    <td>${salary.reward_money}</td><td>${salary.punish_money}</td>
                    <td>${salary.basic_salary+salary.performance+salary.overtime_pay+salary.reward_money-salary.punish_money}</td>
                    <td>${salary.income_tax}</td><td>${salary.social_security}</td>
                    <td>${salary.net_payroll}</td><td>${salary.payoff}</td>
                     <td>
                         <a href="reconsiderSalary?salary_no=${salary.salary_no}">复议</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
</body>
</html>
