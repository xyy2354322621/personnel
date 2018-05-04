<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/27 0027
  Time: 16:46
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
        function vacationChange(date) {
            var timeIn = document.getElementById("time");
            var unit = document.getElementById("unit");
            if (date.value=="事假" ){
                timeIn.removeAttribute("readonly");
                timeIn.value=1;
                unit.innerHTML="小时"
            }else if (date.value=="病假" ){
                timeIn.removeAttribute("readonly");
                timeIn.value=1;
                unit.innerHTML="小时"
            }else {
                timeIn.setAttribute("readonly","true");
                timeIn.value=1;
                unit.innerHTML="天（天数不可更改）"
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
            margin: 10px 15px;
            width: 100px;
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
            width: 550px;
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
        .input{
            width: 183px;
        }
    </style>

</head>
<body>
<div class="body">
    <div class="top"></div>
    <table>
        <tr><th>请假</th></tr>
        <tr><td>
            <form method="post" action="attendApplyLeave">
                <input type="hidden" name="attend_no" value="${attendance.attend_no}">
                <select id="vacation" name="vacation" onchange="vacationChange(this)">
                    <option value="事假">事假</option>
                    <option value="病假">病假</option>
                    <option value="年假">年假</option>
                    <option value="婚假">婚假</option>
                    <option value="产假">产假</option>
                    <option value="丧假">丧假</option>
                </select>
                请假时长：<input id="time" name="time" type="number" max="8" pattern="^[1-8].?\d?$" value="1" required><span id="unit">小时</span>
                <br><input type="submit" value="确定" class="button">
                <input type="reset" value="重置" class="button">
                <a href="browseMyAttendance"><input type="button" value="返回" class="button"></a>

            </form>

        </td></tr>

    </table>
    <div class="bottom"></div>
</div>
</body>
</html>
