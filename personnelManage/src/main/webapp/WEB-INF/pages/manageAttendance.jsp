<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/27 0027
  Time: 14:33
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
        $(function () {
            $("#spv").click(function () {
                window.location.href="setPublicVacation?date="+$("#date").val();
            });
            $("#cpv").click(function () {
                window.location.href="updateCancerPublicVacation?date="+$("#date").val();
            });
        });

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

                $("#attendTable  tr:not(:first)").html("");
                var table = document.getElementById("attendTable");
                <c:forEach items="${attendanceList}" var="atd">
                var index = data.selectedIndex;
                if (data.options[index].innerHTML=="${atd.depart_name}"){
                    var row = table.insertRow();
                    var cell1=row.insertCell();
                    var cell2=row.insertCell();
                    var cell3=row.insertCell();
                    var cell19=row.insertCell();
                    var cell4=row.insertCell();
                    var cell5=row.insertCell();
                    var cell6=row.insertCell();
                    var cell7=row.insertCell();
                    var cell8=row.insertCell();
                    var cell9=row.insertCell();
                    var cell10=row.insertCell();
                    var cell11=row.insertCell();
                    var cell12=row.insertCell();
                    var cell20=row.insertCell();
                    var cell13=row.insertCell();
                    var cell14=row.insertCell();
                    var cell15=row.insertCell();
                    var cell16=row.insertCell();
                    var cell17=row.insertCell();
                    var cell18=row.insertCell();
                    cell1.innerHTML="${atd.attend_no}";
                    cell2.innerHTML="${atd.e_id}";
                    cell3.innerHTML="${atd.e_name}";
                    cell19.innerHTML="${atd.depart_name}";
                    cell4.innerHTML="${atd.pos_name}";
                    cell5.innerHTML="${atd.attend_time}";
                    cell6.innerHTML="${atd.leave_time}";
                    cell7.innerHTML="${atd.overtime}分钟";
                    cell8.innerHTML="${atd.be_late}分钟";
                    cell9.innerHTML="${atd.leave_early}分钟";
                    cell10.innerHTML="${atd.date}";
                    cell11.innerHTML="${atd.person_leave}分钟";
                    cell12.innerHTML="${atd.sick_leave}分钟";
                    cell20.innerHTML="${atd.absenteeism}天";
                    cell13.innerHTML="${atd.annual_leave}天";
                    cell14.innerHTML="${atd.marriage_leave}天";
                    cell15.innerHTML="${atd.maternity_leave}天";
                    cell16.innerHTML="${atd.funeral_leave}天";
                    cell17.innerHTML="${atd.public_leave}天";
                    cell18.innerHTML="<a href='vacationSet?attend_no=${atd.attend_no}'><input type='button' value='设置'></a> ";
                }
                </c:forEach>
            }
            </c:forEach>
        }

        function posSelect(date) {
            $("#attendTable  tr:not(:first)").html("");
            var table = document.getElementById("attendTable");
            var depart = document.getElementById("dpt");
            var index = depart.selectedIndex;
            <c:forEach items="${attendanceList}" var="atd">
                if (date.value=="${atd.pos_no}"){
                var row = table.insertRow();
                var cell1=row.insertCell();
                var cell2=row.insertCell();
                var cell3=row.insertCell();
                var cell19=row.insertCell();
                var cell4=row.insertCell();
                var cell5=row.insertCell();
                var cell6=row.insertCell();
                var cell7=row.insertCell();
                var cell8=row.insertCell();
                var cell9=row.insertCell();
                var cell10=row.insertCell();
                var cell11=row.insertCell();
                var cell12=row.insertCell();
                var cell20=row.insertCell();
                var cell13=row.insertCell();
                var cell14=row.insertCell();
                var cell15=row.insertCell();
                var cell16=row.insertCell();
                var cell17=row.insertCell();
                var cell18=row.insertCell();
                cell1.innerHTML="${atd.attend_no}";
                cell2.innerHTML="${atd.e_id}";
                cell3.innerHTML="${atd.e_name}";
                cell19.innerHTML="${atd.depart_name}";
                cell4.innerHTML="${atd.pos_name}";
                cell5.innerHTML="${atd.attend_time}";
                cell6.innerHTML="${atd.leave_time}";
                cell7.innerHTML="${atd.overtime}分钟";
                cell8.innerHTML="${atd.be_late}分钟";
                cell9.innerHTML="${atd.leave_early}分钟";
                cell10.innerHTML="${atd.date}";
                cell11.innerHTML="${atd.person_leave}分钟";
                cell12.innerHTML="${atd.sick_leave}分钟";
                cell20.innerHTML="${atd.absenteeism}天";
                cell13.innerHTML="${atd.annual_leave}天";
                cell14.innerHTML="${atd.marriage_leave}天";
                cell15.innerHTML="${atd.maternity_leave}天";
                cell16.innerHTML="${atd.funeral_leave}天";
                cell17.innerHTML="${atd.public_leave}天";
                cell18.innerHTML="<a href='vacationSet?attend_no=${atd.attend_no}'><input type='button' value='设置'></a> ";
            }
            </c:forEach>
        }
    </script>
</head>
<body>

<a href="gotoEmployeeHome">返回</a>
<%--<a href="createTodayAttendance">生成今日考勤</a>--%>
<%--<a href="createTomorrowAttendance">生成明日考勤</a>--%>
<a href="createThisMonthAttendance">生成当月考勤</a>
<a href="createNextMonthAttendance">生成下月考勤</a>
<a href="tidyPrevMonthAttendance">整理上月考勤</a>
<a href="tidyCurMonthAttendance">整理当月考勤</a>
<a href="browseAttendApplies">查看考勤申请</a>
<form method="post" action="browseThisDateAttendance">
    选择日期：<input id="date" type="date" name="date" value=${sessionScope.curDate}>
    <input id="ba" type="submit" value="查看考勤">
    <input id="spv" type="button" value="设为公假日">
    <input id="cpv" type="button" value="取消公假日">
</form>
部门：<select id="dpt" onchange="departSelect(this)">
    <option></option>
    <c:forEach items="${sessionScope.departmentPosition}" var="depart">
        <option value="${depart.depart_no}">${depart.depart_name}</option>
    </c:forEach>
</select>
职位：<select id="posSelect" onchange="posSelect(this)" name="pos_no">
    <option></option>
    <c:forEach items="${sessionScope.departmentPosition[0].positionSet}" var="pos">
        <option value="${pos.pos_no}">${pos.pos_name}</option>
    </c:forEach>
</select>
<div>
    <table id="attendTable">
        <caption>考勤信息</caption>
        <tr>
            <th>考勤编号</th><th>员工编号</th><th>员工姓名</th>
            <th id="depart" >所在部门</th><th id="pos">员工职位</th>
            <th>上班时间</th><th>下班时间</th><th>加班时间</th>
            <th>迟到时间</th><th>早退时间</th><th>考勤日期</th>
            <th>事假</th><th>病假</th><th>旷工</th><th>年假</th><th>婚假</th>
            <th>产假</th><th>丧假</th><th>公假</th>
            <th>假期设置</th>
        </tr>

        <c:forEach items="${attendanceList}" var="attend">
            <tr>
                <td>${attend.attend_no}</td><td>${attend.e_id}</td><td>${attend.e_name}</td>
                <td>${attend.depart_name}</td><td>${attend.pos_name}</td><td>${attend.attend_time}</td>
                <td>${attend.leave_time}</td><td>${attend.overtime}分钟</td><td>${attend.be_late}分钟</td>
                <td>${attend.leave_early}分钟</td><td>${attend.date}</td><td>${attend.person_leave}小时</td>
                <td>${attend.sick_leave}小时</td><td>${attend.absenteeism}天</td><td>${attend.annual_leave}天</td><td>${attend.marriage_leave}天</td>
                <td>${attend.maternity_leave}天</td><td>${attend.funeral_leave}天</td><td>${attend.public_leave}天</td>
                <td><a href="vacationSet?attend_no=${attend.attend_no}"><input type="button" value="设置"></a> </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
