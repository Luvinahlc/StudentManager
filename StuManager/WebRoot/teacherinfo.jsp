<%@page language="java" contentType="text/html; charset=utf-8"%>
<jsp:useBean id="AcademicBean" class="com.stuman.web.jsf.bean.AcademicBean" scope="page"/>
<%	AcademicBean.setAno((String)(session.getAttribute("id")));
	AcademicBean.CheckAcademicDean(); %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
	<head>
		<title>南京大学教务系统</title>
   
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="css/teacherinner.css" rel="stylesheet" type="text/css">  
	</head>

	<body>
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
    <title>教务员信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
    <link href="css/table.css" rel="stylesheet" type="text/css">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">

	function selectItem(idName)
	{
		var idStr = "";
		document.getElementById("d11").className = "DIV_HIDDEN";
		document.getElementById("tab1").className = "TAB_UNSELECTED";
		var clickOb  = document.getElementById(idName);
		clickOb.className = "TAB_SELECTED";
		if(idName == "tab1")
		{
			idStr = "d11";
		}
		var  divOb  = document.getElementById(idStr);
		divOb.className = "DIV_SHOW";
	}
	function mouseOver(idName)
	{
		var ob = document.getElementById(idName);
		var name = ob.className;
		name = name.replace("CURSOR_HAND");
		ob.className = name+" CURSOR_HAND ";
	}

</script>
</head>
<body class="BODY"  leftmargin="50" rightmargin="50" 
	onLoad="selectItem('tab1')"
>
  <div  align="center">
			<div style="position:absolute; top:100px; left:50px; height:80px; width:250px;">	
				<table width="100%" border="0" borderColor="#3366CC">
					<tr  height="20">
						<td id='tab1' class="TAB_SELECTED"   onClick="javascript:selectItem('tab1')"  onMouseOver="javaScript:mouseOver('tab1')"> 
							教务员信息
				 		</td>
					</tr>
				</table>
			</div>
		<div id="d11" class=DIV_HIDDEN >
			<table width="100%" CLASS="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">
				<tr><th colspan="7"  class="TABLE_TH" >教务员信息</th></TR>
						<tr height="27">
							<td rowspan="5" align="left" width="100"><img src="image/common.jpg" width="100" height="135"/></td>
							<td  class="TABLE_TD_02">教务员编号</td>
							<td colspan="3" class="TABLE_TD_01"><%=AcademicBean.getAno() %></td>
							
						</tr>
						
						<tr height="27">
							<td class="TABLE_TD_02">姓名</td>
							<td class="TABLE_TD_01"><%=AcademicBean.getAname() %></td>
										
						</tr>	
						
						<tr height="27">
							<td  class="TABLE_TD_02">出生日期</TD>
							<td colspan="3" class="TABLE_TD_01"><%=AcademicBean.getAbirthday() %></TD>						
						</tr>	
						
						<tr height="27">
							<td  class="TABLE_TD_02">身份证号</TD>
							<td colspan="3" class="TABLE_TD_01"><%=AcademicBean.getAidno() %></TD>
						</tr>	
						
						<tr height="27">
							<td  class="TABLE_TD_02">所在院系</TD>
							<td colspan="3" class="TABLE_TD_01"><%=AcademicBean.getAdept() %></TD>
						</tr>					
			</table>
		 </div>
		
  </div>
  </body>
</html>

	</body>
</html>
