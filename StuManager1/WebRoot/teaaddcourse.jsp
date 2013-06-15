<%@page language="java" contentType="text/html; charset=utf-8"%>
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
    <li id="studentinfo"><a href="updatetea.faces">个人信息</a></li>
     <li id="teachinginfo"><a href="coursemanage.faces">课程管理</a></li>
    <li id="teachinginfo"><a href="studentmanage.faces">学生管理</a></li>
    <li id="teachinginfo"><a href="coursescheduling.faces">排课系统</a></li>
    <li id="studentinfo"><a href="courseselectingresult.faces">选课结果</a></li>
    <li id="studentinfo"><a href="teascoremanage.faces">成绩管理</a></li>
   
  </ul>
</div>
	</div>
	
	
<div class="Line"></div>
  </body>
	
	
	
	<f:view>
		<p>
		</p>
		<p align="center">
			新增课程
		</p>
		<h:form>
			<div align="center"></div>
			<table width="37%" border="1" align="center">
				<tr>
					<td>
						课程号
					</td>
					<td>
						<h:inputText id="id" value="#{courseBean.id}" />
					</td>
				</tr>
				<tr>
					<td width="37%">
						课程名
					</td>
					<td width="63%">
						<h:inputText id="name" value="#{courseBean.name}" />
					</td>
				</tr>
				<tr>
					<td>
						学分
					</td>
					<td>
						<h:selectOneListbox id="mark" size="3" value="#{courseBean.mark}">
							<f:selectItem itemLabel="1" itemValue="1"/>
							<f:selectItem itemLabel="2" itemValue="2"/>
							<f:selectItem itemLabel="3" itemValue="3"/>
							<f:selectItem itemLabel="4" itemValue="4"/>
						</h:selectOneListbox>
					</td>
				</tr>
				<tr>
					<td>
						系别
					</td>
					<td>
						<h:selectOneListbox id="department" size="3" value="#{courseBean.dep}">
							<f:selectItem itemLabel="计算机" itemValue="计算机"/>
							<f:selectItem itemLabel="机械系" itemValue="机械系"/>
							<f:selectItem itemLabel="电子系" itemValue="电子系"/>
							<f:selectItem itemLabel="数学系" itemValue="数学系"/>
						</h:selectOneListbox>
					</td>
				</tr>
				<tr>
					<td>
						预修课
					</td>
					<td>

						<h:selectOneListbox id="department" size="3" value="#{courseBean.prepare}">
							<f:selectItem itemLabel="语文" itemValue="语文"/>
							<f:selectItem itemLabel="数学" itemValue="数学"/>
							<f:selectItem itemLabel="英语" itemValue="英语"/>
							<f:selectItem itemLabel="音乐" itemValue="音乐"/>
						</h:selectOneListbox>

					</td>
				</tr>
			</table>
			<p align="center">
				<h:commandButton action="#{courseBean.addCourse}" id="Submit2" value="确定"/>
			</p>
			<p>
				&nbsp;
			</p>
		</h:form>
		<p>
			<a href="getcourse.faces">&lt;&lt;Back </a>
		</p>
		</f:view>
	</body>
</html>
