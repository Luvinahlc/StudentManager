<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<jsp:useBean id="SelectCourseBean" class="com.stuman.web.jsf.bean.SelectCourseBean" scope="request"/>
<jsp:setProperty property="*" name="SelectCourseBean"/>
<%	
	boolean isTime=SelectCourseBean.getScoreEnterTime();
	if(isTime){
		String str=request.getParameter("submit");
		if(str!=null){
			str=new String(str.getBytes("ISO-8859-1"),"utf8");
			String ano=(String)session.getAttribute("id");
			System.out.println(str);
			if(str.contains("查询")){				
				if(!SelectCourseBean.checkSelectExistInDept(ano)){
					SelectCourseBean.setMsg("该选课记录不存在");
				}
				else
					SelectCourseBean.checkScore();
			}
			if(str.contains("修改")){
				if(!SelectCourseBean.checkSelectExistInDept(ano)){
					SelectCourseBean.setMsg("该选课记录不存在");
				}
				else{
					if(SelectCourseBean.Modify())
						SelectCourseBean.setMsg("修改成功");
					else
						SelectCourseBean.setMsg("修改失败");
				}
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
	﻿
 
	<html>
  <head>
    <base href="login.faces">
    <title>课程信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
    <link href="css/table.css" rel="stylesheet" type="text/css">
	<script type="text/javascript"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  </head>
<%if(isTime){ %>
<body class="BODY"  leftmargin="50" rightmargin="50">
  <div  align="center" style="width: 100%">
   <form action="teainputscore.jsp" method="post">
    <TABLE width="100%"  height="100%" align="center" >
      <tr><td height="15"></td></tr>
      <TR align="center">
		<TD width="10" >&nbsp;</TD>
        <TD align="center" valign="top">
			<table width="40%"  class="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">
				<tr  align="left" class="TABLE_TR_01">
				<td > 成绩</td>
				<td > <input type="text" name="score" value=<%=SelectCourseBean.getCourseScore()%> /></td>
				</tr>
				<tr  align="left" class="TABLE_TR_02">
				<td > 请输入学号</td>
				<td > <input type="text" name="sno" value=<%=SelectCourseBean.getSno()%> /></td>
				</tr>
				<tr  align="left" class="TABLE_TR_01">
				<td > 请输入课程号</td>
				<td > <input type="text" name="cno" value=<%=SelectCourseBean.getCno()%> /></td>
				</tr>
				
				
			</table>
			<label   style="color :#FF0000"><%=SelectCourseBean.getMsg()%></label>
			<br />
				<label>
	<input type="submit" name="submit" value="查询 " />
	</label>
&nbsp;&nbsp;&nbsp;&nbsp;
	<label>
	<input type="submit" name="submit" value="修改"   />
	</label>
			
			</TD>
			</TR>
			</TABLE>
			</form>
			</div>
	
  </body>
  <%} %>
  <% if(!isTime){ %>
  	<a>成绩录入尚未开始！<br/></a>
  <% }%>
  
</html>