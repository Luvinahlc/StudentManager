<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<jsp:useBean id="AcademicBean" class="com.stuman.web.jsf.bean.AcademicBean" scope="page"/>
<%	AcademicBean.getApplyinformation(); %>
<%@page import ="com.stuman.domain.Applyinfo" %>
<%@page import ="com.stuman.domain.Student" %>
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
    <li id="studentinfo"><a href="updatetea.faces">个人信息</a></li>
    <li id="teachinginfo"><a href="coursemanage.faces">课程管理</a></li>
    <li id="teachinginfo"><a href="studentmanage.faces">学生管理</a></li>
    <li id="teachinginfo"><a href="coursescheduling.faces">排课系统</a></li>
    <li id="studentinfo"><a href="courseselectingresult.faces">选课结果</a></li>
    <li id="studentinfo"><a href="teascoremanage.faces">成绩管理</a></li>
   
  </ul>
</div>
	</div>
	﻿

<html>
	<head>
		<base href="teacher.faces">
		<title>学生信息</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<link href="css/table.css" rel="stylesheet" type="text/css">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>
	
	<body leftmargin="50" rightmargin="50">
		<div>
		<table  width="100%"  height="100%" align="center" >
			<tr><td height="15"></td></tr>
			<TR align="center">
		<TD width="10" >&nbsp;</TD>
        <TD align="center" valign="top">
			<table width="95%"  class="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">
				<tr class="TABLE_TH">
				  <th >学号</th>
				  <th >姓名</th>
				  <th >申	请	内	容</th>
				  <%int listnum=AcademicBean.getApplyinfo().size();
				  for(int i=0;i<listnum;i++){
				   	if(i%2 == 0) {%>
				   	<tr align="left" class="TABLE_TR_01">
				   	<% }%>
				   	<%if(i%2 == 1) {%>
				   	<tr align="left" class="TABLE_TR_02">
				   	<% }%>
				   	
				   	<td valign="middle"><%=((Applyinfo)(AcademicBean.getApplyinfo().get(i))).getId().getSno() %></td>
				   	<td valign="middle"><%=((Student)(AcademicBean.getStudent().get(i))).getSname() %></td>
				   	<td valign="middle"><%=((Applyinfo)(AcademicBean.getApplyinfo().get(i))).getId().getContent() %></td>
			   	</tr>	
				   	
				   <% }%>
				
			</table>	
		</table>	
		</div>
	</body>
</html>



<div class="Line"></div>
  </body>


</html>
<br>