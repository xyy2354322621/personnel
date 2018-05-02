<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/30 0030
  Time: 16:23
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
<a href="manageTaxRate">返回</a>

<fieldset>
    <legend>添加税率</legend>
    <form action="updateTaxRate" method="post">
        <input name="tax_no" type="hidden" value="${taxRate.tax_no}"><br>
        <%--个税起征：<input name="start" type="number" value="${taxRate.threshold}"><br>--%>
        级距下限：<input name="low" type="number" value="${taxRate.low_money}"><br>
        级距上限：<input name="high" type="number" value="${taxRate.high_money}"><br>
        个税税率：<input name="rate" type="number" value="${taxRate.tax_rate}"><br>
        速算扣除：<input name="deduction" type="number" value="${taxRate.quick_deduction}"><br>
        <input type="submit" value="修改">
        <input type="reset" value="重置">
    </form>
</fieldset>
</body>
</html>
