<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/21 0021
  Time: 11:10
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
        function showDesc(data) {
            alert(data.firstChild.value);
        }
    </script>
</head>
<body>
欢迎${sessionScope.tourist.tourist_no}访问人事管理系统
<a href="gotoEmployeeLogin">员工登录</a>
<a href="gotoTouristLogin">游客登录</a>
<a href="gotoTouristRegister">游客注册</a>
<a href="manageResume">我的简历</a>
<a href="manageApply">我的申请</a>

<div>
    <table>
        <caption>招聘信息</caption>
        <tr>
            <th>招聘职位</th><th>职位类别</th><th>招聘人数</th>
            <th>职位薪资</th><th>发布时间</th><th>要求描述</th>
            <th>投递简历</th>
        </tr>
        <c:forEach items="${sessionScope.issuingRecruit}" var="recruit">
            <tr>
                <td>${recruit.position}</td><td>${recruit.position_type}</td>
                <td>${recruit.recruit_number}</td><td>${recruit.salary}</td>
                <td>${recruit.issue_time}</td>
                <td><a href="checkRecruit?recruit_no=${recruit.recruit_no}">点击查看</a></td>
                <%--<td ><span onclick="showDesc(this)"><input type="hidden" value="${recruit.description}">点击查看</span></td>--%>
                <td><a href="applyPosition?recruit_no=${recruit.recruit_no}">申请职位</a> </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
