<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/5/3 0003
  Time: 14:19
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
</head>
<body>
<a href="gotoEmployeeHome">返回</a>
<c:if test="${sessionScope.myTrainRecord.size()>0}" >
    <div>
        <table id="trainTable">
            <caption>培训信息</caption>
            <tr>
                <th>培训主题</th><th>培训内容</th><th>培训地点</th><th>开始时间</th>
                <th>结束时间</th><th>培训考核</th><th>培训出勤</th><th>已知悉</th>
            </tr>

            <c:forEach items="${sessionScope.myTrainRecord}" var="train">
                <tr>
                    <td>${train.train_name}</td><td>${train.message}</td>
                    <td>${train.train_address}</td><td>${train.start_time}</td>
                    <td>${train.end_time}</td><td>${train.examine}</td>
                    <td>${train.attend}</td>
                    <td>
                        <c:if test="${train.scan==0}">
                            <a href="scanTranInfo?train_record_no=${train.train_record_no}">已知悉</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
</body>
</html>
