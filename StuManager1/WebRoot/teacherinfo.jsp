<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
	<head>
		<title>南京大学教务系统</title>
   
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="css/inner.css" rel="stylesheet" type="text/css">  
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




	<f:view>
		<%--<%
			String tea_id = request.getParameter("Teacher_id");
			System.out.println("Student_id = " + tea_id);
			String name = "", id = "", password = "", title = "";
			TeacherDAO teaDao = DAOFactory.getInstance().createTeacherDAO();
			Teacher tea = teaDao.getTeacherByID(tea_id);
			name = tea.getName();
			password = tea.getPassword();
			title = tea.getTitle();
			%>
		--%>
		<p align="center">
			更新教务员
		</p>
		<%--<h:form method="post" action="/MyStuMan/editTeacher.do?Teacher_id=<%=tea_id%>">
		
			--%>
			<h:form>
			<table width="51%" border="1" align="center">
				<tr>
					<td width="33%">
						教务员姓名
					</td>
					<td width="67%">
							<h:inputText id="name" value="#{teacherBean.teacher.name}" />
					</td>
				</tr>
				<tr>
					<td>
						密码
					</td>
					<td>
							<h:inputSecret id="password" value="#{teacherBean.teacher.password}" />
					</td>
				</tr>
				<tr>
					<td>
						院系
					</td>
					<td>
							<h:selectOneListbox id="title" size="１" value="#{teacherBean.teacher.title}">
								<f:selectItem itemLabel="计算机系" itemValue="计算机系"/>
								<f:selectItem itemLabel="数学系" itemValue="数学系"/>
							</h:selectOneListbox>
					</td>
				</tr>
			</table>
			<p align="center">
					<h:commandButton action="#{teacherBean.editTeacher}" id="Submit" value="提交"/>
			</p>
		</h:form>
		<p>
			&nbsp;
		</p>
		</f:view>
		<div class="Line"></div>
	</body>
</html>
