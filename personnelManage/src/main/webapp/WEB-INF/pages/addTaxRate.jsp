<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/30 0030
  Time: 16:03
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
    <script type="text/javascript">
        function checkRange() {
            var low = document.getElementById("low");
            var high = document.getElementById("high");
            if (parseFloat(low.value) > parseFloat(high.value)){
                alert("级距上限不可小于级距下限");
                high.focus();
            }

        }
    </script>
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
            margin: 50px auto;
            padding: 10px;
        }
        input{
            margin: 5px;
        }
        .button{
            margin: 5px 3px;
            width: 80px;
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
    </style>
</head>
<body>


<div class="body">
    <div class="top"></div>
    <table>
        <tr><th>添加税率</th></tr>
        <tr><td>
            <form action="saveTaxRate" method="post">
                级距下限：<input name="low" id="low" type="number" required="required">元<br>
                级距上限：<input name="high" id="high" type="number" required >元<br>
                个税税率：<input name="rate" type="text" required pattern="^\d{1,2}\.?\d{1,2}">%<br>
                速算扣除：<input name="deduction" type="number" required="required">元<br>
                <input type="submit" value="新增" onmouseover="checkRange()" class="button">
                <input type="reset" value="重置" class="button">
                <a href="manageTaxRate"><input type="button" value="返回" class="button"></a>
            </form>
        </td></tr>

    </table>
    <div class="bottom"></div>
</div>
</body>
</html>
