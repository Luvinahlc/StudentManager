<%@page language="java" contentType="text/html; charset=utf-8"%>
<jsp:useBean id="AcademicBean" class="com.stuman.web.jsf.bean.AcademicBean" scope="page"/>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%  
	AcademicBean.setAno((String)session.getAttribute("id"));
	System.out.println(AcademicBean.getAno());
	AcademicBean.CheckAcdInfo(); 

	AcademicBean.setMsg("");
	String cno = request.getParameter("cno");
	String cname = request.getParameter("cname");
	String credit = request.getParameter("credit");
	String type = request.getParameter("type");
	String teacher = request.getParameter("teacher");
	
	if(teacher == null || teacher == ""){AcademicBean.setMsg("请输入任课教师");}
	if(type == null || type == ""){AcademicBean.setMsg("请输入课程类型");}
	if(credit == null || credit == ""){AcademicBean.setMsg("请输入学分");}
	if(cname == null || cname == ""){AcademicBean.setMsg("请输入课程名");}
	if(cno == null || cno == ""){AcademicBean.setMsg("请输入课程号");}
	
	if(cno != null && cname !=null && credit != null && type != null && teacher != null && teacher != "" && cno != "" && cname != "" && credit != "" && type != ""){
		if(AcademicBean.CheckCourseExist(new String(cno.getBytes("ISO-8859-1"),"utf8"))){
			AcademicBean.setMsg("课程已存在");
		}
		
		if(AcademicBean.addCourse(cno, cname, credit,type,teacher)){
			AcademicBean.setMsg("添加成功");
		}
		else
			AcademicBean.setMsg("添加失败");	
	}

%>

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

<html>
  <head>
    <base href="login.faces">
    <title>课程添加</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
    <link href="css/table.css" rel="stylesheet" type="text/css">
	<script type="text/javascript"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  </head>
  
<body class="BODY"  leftmargin="50" rightmargin="50">
<div id="d11" align="center" >
添加课程
<hr>
<p></p>
<form action="teaaddcourse.jsp" method="post">
	<table width="16%" CLASS="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">
		
				<tr align="left" class="TABLE_TR_01">
					<td>课程号</td>
					<td><input type="text" name="cno"></td>
				</tr>
				<tr align="left" class="TABLE_TR_02">
					<td >课程名</td>
					<td><input type="text" name="cname"></td>
				</tr>
				<tr align="left" class="TABLE_TR_01">
					<td>学分</td>
					<td><input type="text" name="credit"></td>
				</tr>
				<tr align="left" class="TABLE_TR_02">
					<td>课程类型</td>
					<td><input type="text" name="type"></td>
				</tr>
				<tr align="left" class="TABLE_TR_01">
					<td>任课教师</td>
					<td><input type="text" name="teacher"></td>
				</tr>			
			</table>	
		<div align="center">
			
				<input type="submit" value="确定"><br/>
				<label> <%=AcademicBean.getMsg() %></label>	
			
		</div>
		
</form>
</div>
  </body>
  </html>
</body>
</html>
