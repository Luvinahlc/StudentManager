<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<jsp:useBean id="StudentBean" class="com.stuman.web.jsf.bean.StudentBean" scope="page"/>
<%	StudentBean.setSno((String)session.getAttribute("id"));
	StudentBean.GetSelectedCourses(); %>
<%@page import ="com.stuman.domain.Courseinfo" %>
<%@page import ="com.stuman.domain.Courseplan" %>
<html >
  <head>
    <title>南京大学教务系统</title>
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
    <li id="homepage"><a href="student.faces">首  页</a></li>
    <li id="studentinfo"><a href="stu_information.faces">个人信息</a></li>
    <li id="teachinginfo"><a href="stu_gradelook.faces">成绩查看</a></li>
    <li id="teachinginfo"><a href="stu_courseplan.faces">学期选课</a></li>
    <li id="studentinfo"><a href="stu_applicationsystem.faces">申报系统</a></li>
    <li id="teachinginfo"><a href="stu_notice.faces">通知查看</a></li>
    <li id="teachinginfo"><a href="stu_courseassess.faces">课程评估</a></li>
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
	<script type="text/javascript">
	 </script>
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
				  <th >课程编号</th>
				  <th >课程名称</th>
				  <th >学分</th>
				  <th >学时</th>
				  <th >开课院系</th>
				  <th >上课时间</th>
				  <th >上课地点</th>
				  <th >课程类型</th>
				  <th >教师</th>
				  <th >考试时间</th>
				  <th >考试地点</th>
				  
				
				  <%int listnum=StudentBean.getCourses().size();
				   for(int i=0;i<listnum;i++){
				   	if(i%2 == 0) {%>
				   	<tr align="left" class="TABLE_TR_01">
				   	<% }%>
				   	<%if(i%2 == 1) {%>
				   	<tr align="left" class="TABLE_TR_02">
				   	<% }%>
				   	
				   	<td valign="middle"><%=((Courseinfo)(StudentBean.getCourses().get(i))).getCno()%></td>
					<td valign="middle"><%=((Courseinfo)(StudentBean.getCourses().get(i))).getCname()%></td>
					<td valign="middle"><%=((Courseinfo)(StudentBean.getCourses().get(i))).getCredit()%></td>
					<td valign="middle"><%=((Courseinfo)(StudentBean.getCourses().get(i))).getHour()%></td>
					<td valign="middle"><%=((Courseinfo)(StudentBean.getCourses().get(i))).getCdept()%></td>
					<td valign="middle"><%=((Courseplan)(StudentBean.getCrs().get(i))).getCtime()%></td>
					<td valign="middle"><%=((Courseplan)(StudentBean.getCrs().get(i))).getCplace()%></td>
					<td valign="middle"><%=((Courseplan)(StudentBean.getCrs().get(i))).getClassType()%></td>
					<td valign="middle"><%=((Courseplan)(StudentBean.getCrs().get(i))).getTeacher()%></td>
					<td valign="middle"><%=((Courseplan)(StudentBean.getCrs().get(i))).getExamTime()%></td>
					<td valign="middle"><%=((Courseplan)(StudentBean.getCrs().get(i))).getExamPlace()%></td>
				   	</tr>	
				   
				   <% }%>
			</table>
			</TABLE>
			</div>
	
  </body>
  
</html>

