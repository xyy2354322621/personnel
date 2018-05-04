<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/22 0022
  Time: 12:09
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
            width: 530px;
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
        <tr><th>修改简历</th></tr>
        <tr><td>
            <form action="updateResume" method="post">
                姓<span></span>名：<input name="tourist_name" type="text" value="${sessionScope.alterResume.tourist_name}" required><br>
                <c:if test="${sessionScope.alterResume.gender=='男'}"><span></span>
                    性<span></span>别：<input name="gender" type="radio" value="男" checked>男
                    <input name="gender" type="radio" value="女" >女<br>
                </c:if>
                <c:if test="${sessionScope.alterResume.gender=='女'}">
                    性<span></span>别：<input name="gender" type="radio" value="男" >男
                    <input name="gender" type="radio" value="女" checked>女<br>
                </c:if>
                生<span></span>日：<input name="birthday" type="text" value="${sessionScope.alterResume.birthday}" required><span></span>
                身份证号：<input name="id_no" type="text"  value="${sessionScope.alterResume.id_no}" required><br>
                电话号码：<input name="phone" type="text"  value="${sessionScope.alterResume.phone}" pattern="^[1][3,4,5,7,8][0-9]{9}$" required><span></span>
                电子邮件：<input name="email" type="email" value="${sessionScope.alterResume.email}" required><br>
                学历背景：<input name="education" type="text" value="${sessionScope.alterResume.education}" required><span></span>
                毕业院校：<input name="graduate_academy" type="text" value="${sessionScope.alterResume.graduate_academy}" required><br>
                自我简绍：<br>
                <textarea name="introduction" required>${sessionScope.alterResume.introduction}</textarea><br>
                教育经历：<br>
                <textarea name="education_background" required>${sessionScope.alterResume.education_background}</textarea><br>
                工作经历：<br>
                <textarea name="employment_record" required>${sessionScope.alterResume.employment_record}</textarea><br>
                项目经验：<br>
                <textarea name="project_experience" required>${sessionScope.alterResume.project_experience}</textarea><br>
                <input type="submit" value="修改" class="button">
                <input type="reset" value="重置" class="button">
                <a href="manageResume"><input type="button" value="返回" class="button"></a>

            </form>

        </td></tr>

    </table>
    <div class="bottom"></div>
</div>

</body>
</html>
