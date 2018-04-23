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
</head>
<body>
<fieldset>
    <legend>发布招聘</legend>
    <form action="saveRecruit" method="post">
       <%-- 部门选择：<select name="department.depart_no" style="width: 150px">
        <c:forEach items="${sessionScope.departments}" var="department">
            <option value="${department.depart_no}" >${department.depart_name}</option>
        </c:forEach>
    </select><br>--%>
        招聘职位：<input name="position" type="text" ><br>
        职位类别：<input name="position_type" type="text" ><br>
        招聘人数：<input name="number" type="text" placeholder="输入整数" pattern="^[1-9]\d{0,4}$"><br>
        职位薪资：<select name="salary" style="width: 150px" >
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
        职位描述：<br>
        <textarea name="description"></textarea><br>
        <input type="submit" value="发布">
        <input type="reset" value="重置">
    </form>
</fieldset>
<a href="manageRecruit">返回</a>
</body>
</html>
