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
	if(cno == null){
		AcademicBean.setMsg("请输入课程号");
	}
	else if(!AcademicBean.CheckCourseExist(new String(cno.getBytes("ISO-8859-1"),"utf8")))
		AcademicBean.setMsg("课程不存在");
	request.removeAttribute("cno");
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
    <title>选课结果</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
    <link href="css/table.css" rel="stylesheet" type="text/css">
	<script type="text/javascript"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  </head>
  
<body class="BODY"  leftmargin="50" rightmargin="50">
<div id="d11" align="center" >
选课结果
<hr>
<p></p>

   <form action="teacourseselectingresult.jsp" method="post">
			<table width="16%" CLASS="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">
				<tr align="left" class="TABLE_TR_01">
					<td>课程号</td>
					<td><input type="text" name="cno"></td>
				</tr>	
			</table>
			<p><input type="submit" value="确定"></p>
			<div><label> <%=AcademicBean.getMsg() %></label></div>
		<div  align="center" style="width: 100%">
    	<TABLE width="100%"  height="100%" align="center" >

      	<TR align="center">
        	<TD align="center" valign="top">
			<table width="50%"  class="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">
				<tr class="TABLE_TH">
				  <th >学号</th>
				  <th >姓名</th>
				  <th >年级</th>
				  </tr>
				  <%
				  if(cno != null){
				  	int listnum = AcademicBean.getCourseplan().size();
				  	boolean flag = true;
				   	for(int i = 0; i < listnum; i++){
				   		if(AcademicBean.getCourseplan().get(i).getCno().equals(cno)){
				   			flag = false;
				   			for(int j = 0; j < AcademicBean.getSelectcourse().size(); j++){
				   				if(AcademicBean.getSelectcourse().get(j).getId().getCno().equals(cno)){
				   				%>
				   					<tr>
				   					<td valign="middle"><%=(AcademicBean.getSelectcourse().get(j).getId().getSno())%></td>
				   					<td valign="middle"><%=(AcademicBean.snameBysno(AcademicBean.getSelectcourse().get(j).getId().getSno()))%></td>
				   					<td valign="middle"><%=(AcademicBean.gradeBysno(AcademicBean.getSelectcourse().get(j).getId().getSno()))%></td>
				   				
									</tr>
								<%}
							}
						}
					}
					if(flag){
						AcademicBean.setMsg("无法找到该课程");
					}
				   }%>
				   	

			</table>
			</TD>
			</TR>
			</TABLE>
			
			</div>
				
	<div class="Line"></div>
	</form>
  </body>


</html>
<br>