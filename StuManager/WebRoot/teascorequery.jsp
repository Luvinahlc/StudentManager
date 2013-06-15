<%@page language = "java" contentType="text/html; charset=utf-8"%>
<jsp:useBean id = "AcademicBean" class="com.stuman.web.jsf.bean.AcademicBean" scope="page"/>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<% 
	AcademicBean.setAno((String)session.getAttribute("id"));
	System.out.println(AcademicBean.CheckAcdInfo()); 
	System.out.println(AcademicBean.GetCourses()); 

	AcademicBean.setMsg("");
	String cno = request.getParameter("cno"); 
	if(cno == null){
		AcademicBean.setMsg("请输入课程号");
	}
	else if(!AcademicBean.CheckCourseExist(new String(cno.getBytes("ISO-8859-1"),"utf8")))
		AcademicBean.setMsg("课程不存在");
 %>

 

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
    <li id="studentinfo"><a href="teacherinfo.faces">个人信息</a></li>
    <li id="teachinginfo"><a href="teacoursemanage.faces">课程管理</a></li>
    <li id="teachinginfo"><a href="teastudentmanage.faces">学生管理</a></li>
    <li id="teachinginfo"><a href="teacoursescheduling.faces">排课系统</a></li>
    <li id="studentinfo"><a href="teacourseselectingresult.faces">选课结果</a></li>
    <li id="studentinfo"><a href="teascoremanage.faces">成绩管理</a></li>
   
  	</ul>
  	</div>
  </div>
  
  <html>
  <head>
    <base href="login.faces">
    <title>成绩查询</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
    <link href="css/table.css" rel="stylesheet" type="text/css">
	<script type="text/javascript"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  </head>
  
<body class="BODY"  leftmargin="50" rightmargin="50">
<div id="d11" align="center" >
成绩查询
<hr>
<p></p>

	<form action="teascorequery.jsp" method="post">
		<table width="16%" CLASS="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">
		<tr align="left" class="TABLE_TR_01">
		<td>课程号</td>
		<td><input type="text" name="cno"></td>
		</tr>
		</table>
		
	<p><input type="submit" value="确定"></p>

<div align = "center"><label> <%=AcademicBean.getMsg() %></label></div>

	<div  align="center" style="width: 100%">
    	<TABLE width="50%"  height="100%" align="center" >

      	<TR align="center">
        	<TD align="center" valign="top">
			<table width="80%"  class="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">
				<tr class="TABLE_TH">
				  <th >课程编号</th>
				  <th >课程名称</th>
				  <th >学号</th>
				  <th >成绩</th>
				</tr>
				  <%int listnum = AcademicBean.getSelectcourse().size();
				  	System.out.println(listnum);
				   for(int i = 0, j = 0; i < listnum; i++){
				   		boolean flag = true;
				   		System.out.println(cno);
				   		System.out.println(AcademicBean.getSelectcourse().get(i).getId().getCno());
				   		if(AcademicBean.getSelectcourse().get(i).getId().getCno().equals(cno)){
				   			System.out.println("ss");
				   			if(AcademicBean.getSelectcourse().get(i).getScore().compareTo(0) > 0){
				   				System.out.println("ss");
				   				flag = false;
				   				%>
				   				<tr>
				   				<td valign="middle"><%=(AcademicBean.getSelectcourse().get(i).getId().getCno())%></td>
								<td valign="middle"><%=(AcademicBean.getCourseinfo().get(j).getCname())%></td>
								<td valign="middle"><%=(AcademicBean.getSelectcourse().get(i).getId().getSno())%></td>
								<td valign="middle"><%=(AcademicBean.getSelectcourse().get(i).getScore())%></td>
				   				</tr>	
				   			<% }
				   		}
				   		if(flag){
							AcademicBean.setMsg("无法找到该课程");
						}
					}%>
			</table>
			</TD>
			</TR>
			</TABLE>
			</div>﻿

	
<div class="Line"></div>
	</form>
	</div>
  </body>


</html>
<br>