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
    <style type="text/css">
        .body{
            margin: 0 auto;
            width: 900px;
            background-image: url(img/body.png);
            background-size: 100% auto;
        }
        table{
            /*border: 2px solid gray;*/
            /*height: 300px;*/
            margin: 10px auto;
            padding: 10px;
        }
        input{
            margin: 5px;
        }
        .button{
            margin: 10px 15px;
            width: 50px;
        }
        .top{
            height: 150px;
            margin: 0 auto;
            width: 900px;
            background-image: url(img/top.jpg);
            background-size: 100% auto;
        }
        .bottom{
            height: 150px;
        }
        textarea{
            height: 150px;
            width: 510px;
        }
        p{
            width: 500px;
            text-align: center;
        }
        span{
            width: 35px;
            display: inline-block;
        }
        .shot{
            width: 15px;
            display: inline-block;
        }
        .shot1{
            width: 7px;
            display: inline-block;
        }
        select{
            width: 140px;
        }
    </style>

</head>
<body>
<div class="body">
    <div class="top"></div>
    <table>
        <tr><th>修改税率</th></tr>
        <tr><td>
            <form action="updateTaxRate" method="post">
                <input name="tax_no" type="hidden" value="${taxRate.tax_no}"><br>
                级距下限：<input name="low" type="number" value="${taxRate.low_money}" required><br>
                级距上限：<input name="high" type="number" value="${taxRate.high_money}" required><br>
                个税税率：<input name="rate" type="number" value="${taxRate.tax_rate}" required pattern="^\d{1,2}\.?\d{1,2}"><br>
                速算扣除：<input name="deduction" type="number" value="${taxRate.quick_deduction}" required><br>
                <input type="submit" value="修改" class="button">
                <input type="reset" value="重置" class="button">
                <a href="manageTaxRate"><input type="button" value="返回" class="button"></a>
            </form>
        </td></tr>

    </table>
    <div class="bottom"></div>
</div>

</body>
</html>
