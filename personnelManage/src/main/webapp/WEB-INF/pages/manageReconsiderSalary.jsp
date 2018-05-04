<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/5/2 0002
  Time: 19:28
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
<a href="manageSalary">返回</a>
<a href="prevMonthSalaryReconsider">上月工资复议</a>
<a href="curMonthSalaryReconsider">当月工资复议</a>
<c:if test="${reconsiderSalaryList.size()>0}" >
    <div>
        <table id="salaryTable">
            <caption>薪资复议</caption>
            <tr>
                <th>计薪月份</th><th>复议金额</th><th>复议说明</th>
                <th>复议状态</th><th>处理</th><th>拒绝</th>
            </tr>
            <c:forEach items="${reconsiderSalaryList}" var="salary">
                <tr>
                    <td>${salary.salary_month}</td><td>${salary.money}</td>
                    <td>${salary.reason}</td><td>${salary.state}</td>
                     <td>
                         <c:if test="${salary.state=='未审核'}">
                             <a href="rewardReconsiderSalary?reconsider_no=${salary.reconsider_no}">本月补齐</a>
                             <a href="punishReconsiderSalary?reconsider_no=${salary.reconsider_no}">本月扣除</a>
                         </c:if>
                    </td>
                    <td>
                        <c:if test="${salary.state=='未审核'}">
                            <a href="refuseReconsiderSalary?reconsider_no=${salary.reconsider_no}">拒绝</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
</body>
</html>
