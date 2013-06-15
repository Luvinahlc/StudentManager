<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%> 
<jsp:useBean id="CourseplanBean" class="com.stuman.web.jsf.bean.CourseplanBean" scope="page"/>

<jsp:setProperty property="*" name="CourseplanBean" />
<%	String str=request.getParameter("submit");
	boolean result=false;
	if(str!=null){
		result=CourseplanBean.addCoursePlan(); 
	}
	if(str!=null){
		str=new String(str.getBytes("ISO-8859-1"),"utf8");
		boolean flag=CourseplanBean.CheckCourseExist();
		boolean flag2=CourseplanBean.CheckCnoExist();
		if(!flag2){
			CourseplanBean.setMsg("该课程不存在");
		}	
		else{
		if(str.contains("添加")){		
			if(!flag){
				result=CourseplanBean.addCoursePlan();
				if(result)
					CourseplanBean.setMsg("添加成功");
				else
					CourseplanBean.setMsg("添加失败");
			}
			else
				CourseplanBean.setMsg("该排课已存在");
		}
		else if(str.contains("修改")){
			if(!flag){
				CourseplanBean.setMsg("该排课不存在");
			}
			else{
				result=CourseplanBean.addCoursePlan();
				if(result)
					CourseplanBean.setMsg("修改成功");
				else
					CourseplanBean.setMsg("修改失败");
			}
		}
		}
	}
%>
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
	<label style="color :#FF0000"><%=CourseplanBean.getMsg()%></label>
  <div  align="center" style="width: 100%">
    <TABLE width="100%"  height="100%" align="center" >
      <tr><td height="15"></td></tr>
      <TR align="center">
		<TD width="10" >&nbsp;</TD>
        <TD align="center" valign="top">
	 <form action="admin_3plancourse.jsp" method="post">
   <table width="55%" align="left">
	<tr class="TABLE_TH">
				  <th colspan="7" >公共课的排课</th>
	 </tr>
				 
	<tr align="left" class="TABLE_TR_01">
  <td > 课程号：</td>
  <td><input type="text" name="cno" value=<%=CourseplanBean.getCno()%> /> </td>
  </tr>
  <tr align="left" class="TABLE_TR_02">
   <td > 上课时间：</td>
  <td><input type="text" name="ctime" value=<%=CourseplanBean.getCtime()%> /> </td>
  </tr>
  <tr align="left" class="TABLE_TR_01">
   <td > 上课地点：</td>
  <td><input type="text" name="cplace" value=<%=CourseplanBean.getCplace()%> /> </td>
  </tr>
  <tr align="left" class="TABLE_TR_02">
   <td >课程类型：</td>
  <td><input type="text" name="type" value=<%=CourseplanBean.getType()%> /> </td>
  </tr>
  <tr align="left" class="TABLE_TR_01">
   <td > 任课教师：</td>
  <td><input type="text" name="teacher" value=<%=CourseplanBean.getTeacher()%> /> </td>
  </tr>
  <tr align="left" class="TABLE_TR_02">
   <td > 考试时间：</td>
  <td><input type="text" name="examTime" value=<%=CourseplanBean.getExamTime()%> /> </td>
  </tr>
  <tr align="left" class="TABLE_TR_01">
   <td > 考试地点：</td>
  <td><input type="text" name="examPlace" value=<%=CourseplanBean.getExamPlace()%> /> </td>
  </tr>
  <tr >
  <td><input type="submit" name="submit" value="添加排课 " /></td>
  <td><input type="submit" name="submit" value="修改排课 " /></td>
  </tr>
   </table>
   
   </form>
	</TD>
			</TR>
			</TABLE>
			</div>
	
  </body>
  </html>
  </body>
</html>

