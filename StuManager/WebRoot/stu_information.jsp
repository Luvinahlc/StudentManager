<%@page language="java" contentType="text/html; charset=utf-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>南京大学教务系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 <link href="css/inner.css" rel="stylesheet" type="text/css"> 
  </head>
  <body >
	<div id="Header">
<div id="Logo"><a href="student.faces"><img src="images/Logo_Student.jpg" border="0"></a></div>
<div id="TopLink"><img src="images/Icon_Help.gif"><a href="student/index.do#">帮助</a>&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/Icon_Exit.gif"><a href="login.faces">退出</a></div>
<div id="UserInfo">~~欢迎您~~</div>
<script type="text/javascript" language="javascript" src="js/prototype.js"></script>
<div id="Nav">
  <ul>
    <li id="homepage"><a href="student.faces">首 页</a></li>
    <li id="studentinfo"><a href="stu_information.faces">个人信息</a></li>
    <li id="teachinginfo"><a href="stu_gradelook.faces">成绩查看</a></li>
    <li id="teachinginfo"><a href="stu_courseplan.faces">学期选课</a></li>
  </ul>
</div>
	</div>
<div id="Function">
    <ul>
      <li><a href="stu_3infolookandmodi.faces"><img src="images/achievement.png"><br />基本信息查看和修改</a></li>
      <li><a href="stu_3graduatecheck.faces"><img src="images/achievement.png"><br />毕业信息查询</a></li>
	</ul>
</div>
<div class="Line"></div>
  </body>
</html>
