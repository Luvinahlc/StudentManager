<%@page language="java" contentType="text/html; charset=utf-8"%>
<jsp:useBean id="AcademicBean" class="com.stuman.web.jsf.bean.AcademicBean" scope="page"/>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%  
	AcademicBean.setAno((String)session.getAttribute("id"));
	AcademicBean.CheckAcdInfo();
	AcademicBean.GetCourses();  
	
	AcademicBean.setMsg("");
	String cno = request.getParameter("cno");
	if(cno == null){cno = "";}
	//System.out.println(cno + " aa");
	String ctime = request.getParameter("ctime");
	String cplace = request.getParameter("cplace");
	String etime = request.getParameter("examtime");
	String eplace = request.getParameter("examplace");
	
	String submit = request.getParameter("submit");
	if(submit != null){
		submit = new String(submit.getBytes("ISO-8859-1"),"utf8");
		if(submit.contains("查询")){			
			if(cno == null || cno == ""){
				AcademicBean.setMsg("请输入课程号");
			}
			else if(!AcademicBean.CheckCourseExist(new String(cno.getBytes("ISO-8859-1"),"utf8")))
				AcademicBean.setMsg("课程不存在");
		}
		if(submit.contains("确定")){
			if(ctime != null && cplace != null){				
				boolean info=AcademicBean.setPlanBycno(cno, cplace, ctime, eplace, etime);
				if(info)
					AcademicBean.setMsg("课程排课成功");
				else
					AcademicBean.setMsg("课程排课失败");
			}
		}
	}
	
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
    <title>排课</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
    <link href="css/table.css" rel="stylesheet" type="text/css">
	<script type="text/javascript"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  </head>
  
  <body class="BODY"  leftmargin="50" rightmargin="50">
	<div id="d11" align="center" >
	院系排课
	<hr>
	<p></p>
﻿
	<form action="teacoursescheduling.jsp" method="post">
			<table width="16%" CLASS="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">		
				<tr align="left" class="TABLE_TR_01">
				<td>课程号</td>
				<td><input type="text" name="cno" value = <%= cno %>>
				</td>
				</tr>
			</table>
			<p align="center">
				<input type="submit" name = "submit" value="查询">
			</p>
			
			<div align="center"></div>
			<table width="16%" CLASS="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">		
				<tr align="left" class="TABLE_TR_01">
				<td>上课时间</td>
				<td><input type="text" name="ctime" value = <%= AcademicBean.ctimeBycno(cno)%>></td>
				</tr>
				<tr align="left" class="TABLE_TR_02">
				<td width="37%">上课地点</td>
				<td width="63%"><input type="text" name="cplace" value = <%= AcademicBean.cplaceBycno(cno) %>></td>
				</tr>  
				<tr align="left" class="TABLE_TR_01">
				<td width="37%">考试时间</td>
				<td width="63%"><input type="text" name="examtime" value = <%= AcademicBean.eplaceBycno(cno) %>></td>
				</tr> 
				<tr align="left" class="TABLE_TR_02">
				<td width="37%">考试地点
				</td>
				<td width="63%"><input type="text" name="examplace" value = <%= AcademicBean.etimeBycno(cno) %>></td>
				</tr> 
			</table>
			<p align="center">
				<input type="submit" name = "submit" value="确定">
			</p>
		<div align = "center"><label> <%=AcademicBean.getMsg() %></label></div>

		</div>
  		</body>
  	</html>
  </body>
</html>
<br>