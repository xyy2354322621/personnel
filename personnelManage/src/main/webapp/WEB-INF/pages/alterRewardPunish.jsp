<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/26 0026
  Time: 14:04
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
            margin: 10px 27px;
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
        <tr><th>修改奖惩</th></tr>
        <tr><td>
            <form action="updateRewardPunish" method="post">
                <input type="hidden" name="r_and_p_no" value="${rewardAanPunish.r_and_p_no}">
                <input type="hidden" name="e_id" value="${rewardAanPunish.e_id}">
                被奖惩人：<input type="text" value="${rewardAanPunish.e_name}" readonly><span></span>
                奖惩类别：
                <c:if test="${rewardAanPunish.type=='奖励'}">
                    <select name="type">
                        <option value="奖励" selected>奖励</option>
                        <option value="惩罚">惩罚</option>
                    </select><br>
                </c:if>
                <c:if test="${rewardAanPunish.type=='惩罚'}">
                    <select name="type">
                        <option value="奖励" >奖励</option>
                        <option value="惩罚" selected>惩罚</option>
                    </select><br>
                </c:if>
                奖惩金额：<input name="money" type="text" value="${rewardAanPunish.money}" placeholder="输入整数(最多8位)" pattern="^[1-9]\d{0,7}\.?\d{0,2}$" required><span></span>
                奖惩日期：<input type="date" name="time" value="${rewardAanPunish.time}" required><br>
                奖惩原因：<br>
                <textarea name="reason" required>${rewardAanPunish.reason}</textarea><br>

                <input type="submit" value="修改"  class="button">
                <input type="reset" value="重置"  class="button">
                <a href="manageRewardAndPunishment"><input type="button" value="返回" class="button"></a>

            </form>

        </td></tr>

    </table>
    <div class="bottom"></div>
</div>

</body>
</html>
