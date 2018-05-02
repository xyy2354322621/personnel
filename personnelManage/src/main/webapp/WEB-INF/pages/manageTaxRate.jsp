<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/27 0027
  Time: 11:17
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
<a href="addTaxRate">新增</a>

<div>
    <table>
        <caption>个税税率信息</caption>
        <tr>
            <th>税率编号</th><th>级距下限</th>
            <th>级距上限</th><th>个税税率</th><th>速算扣除数</th>
            <th>修改</th><th>删除</th>
        </tr>


            <c:forEach items="${taxRateList}" var="taxRat" >
        <tr>
                <td>${taxRat.tax_no}</td>
                <td>${taxRat.low_money}元</td><td>${taxRat.high_money}元</td>
                <td>${taxRat.tax_rate}%</td><td>${taxRat.quick_deduction}元</td>
                <td><a href="alterTaxRate?tax_no=${taxRat.tax_no}">修改</a></td>
                <td><a href="deleteTaxRate?tax_no=${taxRat.tax_no}">删除</a></td>
        </tr>
            </c:forEach>

    </table>
</div>

</body>
</html>
