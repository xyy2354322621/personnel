<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/27 0027
  Time: 11:39
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
        function checkNull(date) {
            if (date.value==null || date.value==""){
                eleat("输入的值不能为空");
            }
        }
        function checkRange(date) {
            var low = document.getElementById("low");
            if (date.value==null || date.value==""){
                eleat("输入的值不能为空");
            }else {
                if (low.value>date.value){
                    eleat("级距上限不可小于级距上限");
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
            margin: 10px 40px;
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
    </style>

</head>
<body>
<div class="body">
    <div class="top"></div>
    <table>
        <tr><th>修改基本参数</th></tr>
        <tr><td>
            <form action="updateBasicParam" method="get">
                上班时间：<input name="b_attend_time" type="time" value="${basicParam.b_attend_time}" required>
                下班时间：<input name="b_leave_time" type="time" value="${basicParam.b_leave_time}" required><span class="shot1"></span>
                最低加班时间：<input name="overtime" type="text" value="${basicParam.b_overtime_limit}" pattern="^\d{1,4}$" required>分钟<br>
                迟到时间限制：<input name="attendLimit" type="text" value="${basicParam.b_attend_time_limit}" pattern="^\d{1,4}$" required>分钟<span class="shot"></span>
                早退时间限制：<input name="leaveLimit" type="text" value="${basicParam.b_leave_time_limit}" pattern="^\d{1,4}$" required>分钟<br>
                每月工作天数：<input name="workdays" type="text" max="31" value="${basicParam.b_workdays_month}" pattern="^\d{1,2}\.?\d{1,2}$" required>天<span></span>
                社&nbsp&nbsp保&nbsp&nbsp比&nbsp&nbsp率：<input name="social" type="text" value="${basicParam.b_social_security_ratio}" pattern="^\d{1,3}\.?\d{1,2}$" required>%<br>
                公司支付社保：<input name="companySocial" type="text" value="${basicParam.b_company_pay_social}" pattern="^\d{1,3}\.?\d{1,2}$" required>%<span></span>
                单位罚款金额：<input name="unitPenalty" type="text" value="${basicParam.b_unit_penalty}" pattern="^\d{1,4}$">元/分钟<br>
                加班奖励比率：<input name="overtimeReward" type="text" value="${basicParam.b_overtime_reward_radio}" pattern="^\d{1,3}\.?\d{1,2}$" required>%<span></span>
                个税起征金额：<input name="threshold" type="text" value="${basicParam.b_tax_threshold}" pattern="^\d{1,7}\.?\d{1,2}$">%<br>
                事假付薪比率：<input name="personLeave" type="text" value="${basicParam.person_leave_pay_ratio}" pattern="^\d{1,3}\.?\d{1,2}$" required>%<span></span>
                病假付薪比率：<input name="sickLeave" type="text" value="${basicParam.sick_leave_pay_ratio}" pattern="^\d{1,3}\.?\d{1,2}$" required>%<br>
                婚假付薪比率：<input name="marriageLeave" type="text" value="${basicParam.marriage_leave_pay_ratio}" pattern="^\d{1,3}\.?\d{1,2}$" required>%<span></span>
                产假付薪比率：<input name="maternityLeave" type="text" value="${basicParam.maternity_leave_pay_ratio}" pattern="^\d{1,3}\.?\d{1,2}$" required>%<br>
                丧假付薪比率：<input name="funeralLeave" type="text" value="${basicParam.funeral_leave_pay_ratio}" pattern="^\d{1,3}\.?\d{1,2}$" required>%<span></span>
                年假付薪比率：<input name="annualLeave" type="text" value="${basicParam.annual_leave_pay_ratio}" pattern="^\d{1,3}\.?\d{1,2}$" required>%<br>
                公假付薪比率：<input name="publicLeave" type="text" value="${basicParam.public_leave_pay_ratio}" pattern="^\d{1,3}\.?\d{1,2}$" required>%<span></span>
                旷工付薪比率：<input name="absenteeismLeave" type="text" value="${basicParam.absenteeism_punish_ratio}" pattern="^-?\d{1,3}\.?\d{1,2}$" required>%<br>
                <input type="submit" value="修改" class="button">
                <input type="reset" value="重置" class="button">
                <a href="manageBasicParam"><input type="button" value="返回" class="button"></a>
            </form>

        </td></tr>

    </table>
    <div class="bottom"></div>
</div>
</body>
</html>
