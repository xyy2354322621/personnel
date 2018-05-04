<%--
  Created by IntelliJ IDEA.
  User: xiyueyang
  Date: 2018/4/21 0021
  Time: 22:00
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
        <tr><th>创建简历</th></tr>
        <tr><td>
            <form action="saveResume" method="post">
                姓<span></span>名：<input name="tourist_name" type="text"  required><br>
                性<span></span>别：<input name="gender" type="radio" value="男" checked>男
                <input name="gender" type="radio" value="女" >女<br>
                生<span></span>日：<input name="birthday" type="text"  required><span></span>
                身份证号：<input name="id_no" type="text"  required><br>
                电话号码：<input name="phone" type="text"  pattern="^[1][3,4,5,7,8][0-9]{9}$" required><span></span>
                电子邮件：<input name="email" type="email"  required><br>
                学历背景：<input name="education" type="text"  required><span></span>
                毕业院校：<input name="graduate_academy" type="text"  required><br>
                自我简绍：<br>
                <textarea name="introduction" required></textarea><br>
                教育经历：<br>
                <textarea name="education_background" required></textarea><br>
                工作经历：<br>
                <textarea name="employment_record" required></textarea><br>
                项目经验：<br>
                <textarea name="project_experience" required></textarea><br>
                <input type="submit" value="创建" class="button">
                <input type="reset" value="重置" class="button">
                <a href="manageResume"><input type="button" value="返回" class="button"></a>
            </form>
        </td></tr>
    </table>
    <div class="bottom"></div>
</div>
</body>
</html>
