<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/23 0023
  Time: 11:30
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
            width: 1250px;
            background-image: url(img/body.png);
            background-size: 100% auto;
        }
        table{
            border: 2px solid gray;
            /*height: 300px;*/
            margin: 10px auto;
            padding: 10px;
            border-collapse:collapse;
        }
        td,th{
            border:1px solid gray;
            width: 70px;
            text-align: center;
        }
        input{
            margin: 5px;
            width: 205px;
        }
        .button{
            margin: 10px 40px;
            width: 120px;
        }
        .top{
            height: 200px;
            margin: 0 auto;
            width: 1250px;
            background-image: url(img/top.jpg);
            background-size: 100% auto;
        }
        .bottom{
            height: 300px;
        }
        textarea{
            height: 150px;
            width: 590px;
        }
        p{
            width: 500px;
            text-align: center;
        }
        span{
            width: 30px;
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
            width: 120px;
        }
        .long{
            width: 100px;
        }
    </style>

</head>
<body>
    <div class="body">
        <a href="manageRecruit">返回</a>
        <div class="top"></div>
        <c:if test="${sessionScope.applies.size()>0}">
            <table>
            <caption>面试申请</caption>
            <tr>
                <th>申请编号</th><th>投递时间</th><th>阅读状态</th><th>是否邀请</th>
                <th>面试状态</th><th>录用状态</th><th>查看简历</th>
                <th>面试邀请</th><th>拒绝申请</th><th>删除申请</th>
                <th>面试记录</th><th>录用</th>
            </tr>
            <c:forEach items="${sessionScope.applies}" var="apply">
                <tr>
                    <td>${apply.apply_no}</td><td>${apply.apply_time}</td>
                    <td>${apply.isRead}</td><td>${apply.invite}</td>
                    <td>${apply.interview}</td><td>${apply.hire}</td>
                    <td><a href="checkApplyResume?apply_no=${apply.apply_no}&resume_no=${apply.resume_no}">查看简历</a></td>
                    <td>
                        <c:if test="${apply.invite=='未邀请'}">
                            <a href="inviteInterview?apply_no=${apply.apply_no}&recruit_no=${apply.recruit_no}">邀请面试</a>
                        </c:if>
                        <c:if test="${apply.invite=='已邀请'}">
                            <c:if test="${apply.interview!='同意面试'}">
                                <a href="cancerInvite?apply_no=${apply.apply_no}&recruit_no=${apply.recruit_no}">取消邀请</a>
                            </c:if>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${apply.interview=='未面试'}">
                            <a href="refuseApply?apply_no=${apply.apply_no}&recruit_no=${apply.recruit_no}">不予面试</a>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${apply.interview=='未面试'}">
                            <a href="deleteApply?apply_no=${apply.apply_no}&recruit_no=${apply.recruit_no}&exist=${apply.exist}">删除申请</a>
                        </c:if>
                        <c:if test="${apply.interview=='面试失败'}">
                            <a href="deleteApply?apply_no=${apply.apply_no}&recruit_no=${apply.recruit_no}&exist=${apply.exist}">删除申请</a>
                        </c:if>
                        <c:if test="${apply.hire=='录用'}">
                            <a href="deleteApply?apply_no=${apply.apply_no}&recruit_no=${apply.recruit_no}&exist=${apply.exist}">删除申请</a>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${apply.interview=='同意面试'}">
                            <c:if test="${apply.hire!='录用'}">
                                <a href="successInterview?apply_no=${apply.apply_no}&recruit_no=${apply.recruit_no}">成功</a>
                                <a href="failInterview?apply_no=${apply.apply_no}&recruit_no=${apply.recruit_no}">失败</a>
                            </c:if>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${apply.interview=='面试成功'}">
                            <c:if test="${apply.hire!='录用'}">
                                <a href="hireEmployee?apply_no=${apply.apply_no}&resume_no=${apply.resume_no}&recruit_no=${apply.recruit_no}">录用</a>
                            </c:if>
                        </c:if>
                    </td>

                </tr>
            </c:forEach>
        </table>
        </c:if >
        <div class="bottom"></div>
    </div>
</body>
</html>
