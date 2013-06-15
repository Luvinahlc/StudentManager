<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<jsp:useBean id="SelectCourseBean" class="com.stuman.web.jsf.bean.SelectCourseBean" scope="page"/>
<% SelectCourseBean.checkSelectedCourse(); %>
<%@page import ="com.stuman.domain.Selectcourse" %>
<%@page import ="com.stuman.domain.SelectcourseId" %>


<html>
  <head>
    <title>南京大学教务系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 <link href="css/inner.css" rel="stylesheet" type="text/css"> 
  </head>
  
<body >
<div id="Header">
	<div id="Logo"><a href="admin.faces"><img src="images/Logo_Student.jpg" border="0"></a></div>
	<div id="TopLink"><img src="images/Icon_Help.gif"><a href="student/index.do#">帮助</a>&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/Icon_Exit.gif"><a href="login.faces">退出</a></div>
	<div id="UserInfo">~~欢迎您~~</div>
	<script type="text/javascript" language="javascript" src="js/prototype.js"></script>
	<div id="Nav">
  		<ul>
   		 	<li id="homepage"><a href="admin.faces">首  页</a></li>
    		<li id="studentinfo"><a href="admin_stustatus.faces">学籍信息</a></li>
    		<li id="teachinginfo"><a href="admin_grademanage.faces">成绩管理</a></li>
    		<li id="teachinginfo"><a href="admin_courseplan.faces">选课安排</a></li>
  		</ul>
	</div>
</div>

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

<body class="BODY"  leftmargin="50" rightmargin="50">
  <div  align="center" style="width: 100%">
    <TABLE width="100%"  height="100%" align="center" >
      <tr><td height="15"></td></tr>
      <TR align="center">
		<TD width="10" >&nbsp;</TD>
        <TD align="center" valign="top">
			<table width="95%"  class="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">
				<tr class="TABLE_TH">
				  <th >学号</th>
				  <th >课程号</th>
				  <th >成绩</th>
				  <th >任课教师</th>
				 
				  </tr>
				 
				 <%int listnum=SelectCourseBean.getCourses().size();
				   for(int i=0;i<listnum;i++){
				   	if(i%2 == 0) {%>
				   	<tr align="left" class="TABLE_TR_01">
				   	<% }%>
				   	<%if(i%2 == 1) {%>
				   	<tr align="left" class="TABLE_TR_02">
				   	<% }%>
				
				   	<td valign="middle"><%=((Selectcourse)(SelectCourseBean.getCourses().get(i))).getId().getSno()%></td>
					<td valign="middle"><%=((Selectcourse)(SelectCourseBean.getCourses().get(i))).getId().getCno()%></td>
					<td valign="middle"><%=((Selectcourse)(SelectCourseBean.getCourses().get(i))).getScore()%></td>
					<td valign="middle"><%=((Selectcourse)(SelectCourseBean.getCourses().get(i))).getTeacher()%></td>
				   	</tr>	
				  
				   <% }%>
				   
			</table>
			</TD>
			</TR>
			</TABLE>
			</div>
	
  </body>
  
</html>
	
  </body>
</html>

