<%@page language="java" contentType="text/html; charset=utf-8"%>
<jsp:useBean id = "AcademicBean" class="com.stuman.web.jsf.bean.AcademicBean" scope="page"/>
<%AcademicBean.setAno((String)session.getAttribute("id")); %>
<% System.out.println(AcademicBean.CheckAcdInfo()); %>
<% System.out.println(AcademicBean.GetCourses()); %> 
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html> 
  <head>
    <title>南京大学教务系统</title>
   
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/teacherinner.css" rel="stylesheet" type="text/css">  
  </head>
  <body >
 
	<div id="Header">
		
 
<div id="Logo"><a href="teacher.faces"><img src="image/Logo_Student.jpg" border="0"></a></div>
<div id="TopLink"><img src="image/Icon_Help.gif"><a href="student/index.do#">帮助</a>&nbsp;&nbsp;&nbsp;&nbsp;<img src="image/Icon_Exit.gif"><a href="login.faces">退出</a></div>
<div id="UserInfo">欢迎您 &nbsp;&nbsp;&nbsp;&nbsp;当前身份：教务员</div>
		
<script type="text/javascript" language="javascript" src="js/prototype.js"></script>
<div id="Nav">
  <ul>
    <li id="homepage"><a href="teacher.faces">首  页</a></li>
<<<<<<< HEAD
    <li id="studentinfo"><a href="teacherinfo.faces">个人信息</a></li>
    <li id="teachinginfo"><a href="teacoursemanage.faces">课程管理</a></li>
    <li id="teachinginfo"><a href="teastudentmanage.faces">学生管理</a></li>
    <li id="teachinginfo"><a href="teacoursescheduling.faces">排课系统</a></li>
    <li id="studentinfo"><a href="teacourseselectingresult.faces">选课结果</a></li>
    <li id="studentinfo"><a href="teascoremanage.faces">成绩管理</a></li>
   
=======
    <li id="studentinfo"><a href="updatetea.faces">个人信息</a></li>
    <li id="teachinginfo"><a href="coursemanage.faces">课程管理</a></li>
    <li id="teachinginfo"><a href="studentmanage.faces">学生管理</a></li>
    <li id="teachinginfo"><a href="coursescheduling.faces">排课系统</a></li>
    <li id="studentinfo"><a href="courseselectingresult.faces">选课结果</a></li>
    <li id="studentinfo"><a href="scorequery.faces">成绩管理</a></li>
>>>>>>> 5e5c5985879fcd38cca9b1df0bf979028fec51ee
   
  </ul>
</div>
</div>

 <html>
  <head>
    <base href="login.faces">
    <title>课程查询</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
    <link href="css/table.css" rel="stylesheet" type="text/css">
	<script type="text/javascript"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  </head>
  
  <body class="BODY"  leftmargin="50" rightmargin="50">
	<div id="d11" align="center" >
	课程查询
	<hr>
	<p></p>

		<div align="center"></div>
			<table width="50%" CLASS="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">		
				<tr align="left" class="TABLE_TH">
				  <th width = "10%">课程编号</th>
				  <th width = "15%">课程名称</th>
				  <th width = "5%">学时</th>
				  <th width = "5%">学分</th>
				  <th width = "10%">课程类型</th>
				  <th width = "20%">上课时间</th>
				  <th width = "20%">上课地点</th>
				  <th width = "15%">任课教师</th>
				</tr>
				  <%int listnum = AcademicBean.getCourseinfo().size();
				   for(int i = 0, j = 0; i < listnum; i++){
				   		String cno = AcademicBean.getCourseinfo().get(i).getCno();
					%>
				   		<tr>				   		
				   		<td valign="middle"><%=(cno)%></td>
				   		<td valign="middle"><%=(AcademicBean.getCourseinfo().get(i).getCname())%></td>
				   		<td valign="middle"><%=(AcademicBean.getCourseinfo().get(i).getHour())%></td>
				   		<td valign="middle"><%=(AcademicBean.getCourseinfo().get(i).getCredit())%></td>
				   		<td valign="middle"><%=(AcademicBean.typeBycno(cno))%></td>
				   		<td valign="middle"><%=(AcademicBean.ctimeBycno(cno))%></td>
				   		<td valign="middle"><%=(AcademicBean.cplaceBycno(cno))%></td>
				   		<td valign="middle"><%=(AcademicBean.teaBycno(cno))%></td>
				   		
				<%}%>
			</table>
			</div>﻿


	<div class="Line"></div>
  </body>


</html>
<br>