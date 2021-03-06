<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/23 0023
  Time: 9:58
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
        window.onload=function(){
            var val = ${sessionScope.alterRecruit.salary};
            var options=document.getElementById("select").options;
            for(var i=0;i<options.length;i++) {
                if (val == options[i].value) {
                    options[i].defaultSelected = true;
                    options[i].selected = true;
                    break;
                }
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
            margin: 10px auto;
            padding: 10px;
        }
        input{
            margin: 5px;
        }
        .button{
            margin: 10px 20px;
            width: 120px;
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
            width: 500px;
        }
        p{
            width: 500px;
            text-align: center;
        }
    </style>

</head>
<body>
<div class="body">
    <div class="top"></div>
    <table>
        <tr><th>修改招聘信息</th></tr>
        <tr><td>
            <form action="updateRecruit" method="post">
                招聘职位：<input name="pos_name" type="text" value="${sessionScope.alterRecruit.pos_name}" readonly>
                职位类别：<input name="position_type" type="text" value="${sessionScope.alterRecruit.position_type}"><br>
                招聘人数：<input name="number" type="text" value="${sessionScope.alterRecruit.recruit_number}" pattern="^[1-9]\d{0,4}$" required>
                职位薪资：&nbsp<select name="salary" id="select" style="width: 150px" >
                <option value="1000-3000">1000-3000</option>
                <option value="3000-5000">3000-5000</option>
                <option value="5000-8000">5000-8000</option>
                <option value="8000-10000">8000-10000</option>
                <option value="10000-12000">10000-12000</option>
                <option value="12000-15000">12000-15000</option>
                <option value="15000-18000">15000-18000</option>
                <option value="18000-20000">18000-20000</option>
                <option value="20000-25000">20000-25000</option>
                <option value="25000-30000">25000-30000</option>
                <option value="30000-50000">30000-50000</option>
            </select><br>
                <p>招聘要求</p>
                <textarea name="description">${sessionScope.alterRecruit.description}</textarea><br>
                <input type="submit" value="修改" class="button">
                <input type="reset" value="重置" class="button">
                <a href="manageRecruit"><input type="button" value="返回" class="button"></a>

            </form>

        </td></tr>

    </table>
    <div class="bottom"></div>
</div>

</body>
</html>
