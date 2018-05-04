<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/20 0020
  Time: 20:05
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
    <script>
        function departSelect(data) {
            <c:forEach items="${sessionScope.departmentPosition}" var="department">
            if(data.value==${department.depart_no}){
                var posSelect = document.getElementById("posSelect");
                posSelect.options.length=0;
                <c:forEach items="${department.positionSet}" var="position">
                var posOpt = document.createElement("option");
                posOpt.value=${position.pos_no};
                posOpt.innerHTML="${position.pos_name}";
                posSelect.appendChild(posOpt);
                </c:forEach>
            }
            </c:forEach>
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
            width: 70px;
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
            width: 520px;
        }
        p{
            width: 500px;
            text-align: center;
        }
        .select{
            width: 180px;
        }
        span{
            width: 30px;
            display: inline-block;
        }
    </style>

</head>
<body>
<div class="body">
    <div class="top"></div>
    <table>
        <tr><th>发布招聘</th></tr>
        <tr><td>
            <form action="saveRecruit" method="post">
                部<span></span>门：<select id="dpt" onchange="departSelect(this)" class="select">
                <c:forEach items="${sessionScope.departmentPosition}" var="depart">
                    <option value="${depart.depart_no}">${depart.depart_name}</option>
                </c:forEach>
            </select>
                职<span></span>位：<select id="posSelect" name="pos_no" class="select">
                <c:forEach items="${sessionScope.departmentPosition[0].positionSet}" var="pos">
                    <option value="${pos.pos_no}">${pos.pos_name}</option>
                </c:forEach>
            </select><br>
                职位类别：<input name="position_type" type="text" >
                招聘人数：<input name="number" type="text" placeholder="输入整数" pattern="^[1-9]\d{0,4}$" required>
                职位薪资：<select name="salary"  >
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
                招聘要求：<br>
                <textarea name="description" required></textarea><br>
                <input type="submit" value="发布" class="button">
                <input type="reset" value="重置"  class="button">
                <a href="manageRecruit"><input type="button" value="返回" class="button"></a>

            </form>
        </td></tr>

    </table>
    <div class="bottom"></div>
</div>

</body>
</html>
