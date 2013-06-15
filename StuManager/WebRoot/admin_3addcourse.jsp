<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%> 
<jsp:useBean id="CourseBean" class="com.stuman.web.jsf.bean.CourseBean" scope="page"/>

<jsp:setProperty property="*" name="CourseBean"/>

<%	
	String str=request.getParameter("submit");
	boolean result=false;
	if(str!=null){
		str=new String(str.getBytes("ISO-8859-1"),"utf8");
		System.out.println("str:"+str);
		boolean flag=CourseBean.CheckCourseExist();
		if(str.contains("添加")){			
			if(!flag){
				result=CourseBean.addCourse();
				if(result)
					CourseBean.setMsg("添加成功");
				else
					CourseBean.setMsg("添加失败");
			}
			else
				CourseBean.setMsg("该课程已存在");
		}
		else if(str.contains("修改")){
			if(!flag){
				CourseBean.setMsg("该课程不存在");
			}
			else{
				result=CourseBean.addCourse();
				if(result)
					CourseBean.setMsg("修改成功");
				else
					CourseBean.setMsg("修改失败");
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
	<script type="text/javascript">
	</script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  </head>
 
	<body class="BODY"  leftmargin="50" rightmargin="50">
	<label style="color :#FF0000"><%=CourseBean.getMsg()%></label>
  <div  align="center" style="width: 100%">
    <TABLE width="100%"  height="100%" align="center" >
      <tr><td height="15"></td></tr>
      <TR align="center">
		<TD width="10" >&nbsp;</TD>
        <TD align="center" valign="top">
	 <form action="admin_3addcourse.jsp" method="post">
	<table width="55%" align="left">
	<tr class="TABLE_TH">
				  <th colspan="7" >公共课的添加</th>
	 </tr>
				 
	<tr align="left" class="TABLE_TR_01">
  <td > 课程号：</td>
  <td><input type="text" name="cno" value=<%=CourseBean.getCno()%> /> </td>
  </tr>
  <tr align="left" class="TABLE_TR_02">
   <td > 课程名称：</td>
  <td><input type="text" name="cname" value=<%=CourseBean.getCname()%> /> </td>
  </tr>
  <tr align="left" class="TABLE_TR_01">
   <td > 学分：</td>
  <td><input type="text" name="credit" value=<%=CourseBean.getCredit()%> /> </td>
  </tr>
  <tr align="left" class="TABLE_TR_02">
   <td > 学时：</td>
  <td><input type="text" name="hour" value=<%=CourseBean.getHour()%> /> </td>
  </tr>
  <tr align="left" class="TABLE_TR_01">
   <td > 开课院系：</td>
  <td><input type="text" name="cdept"  value=<%= CourseBean.getCdept() %> /> </td>
  </tr>

  <tr >
  <td><input type="submit" name="submit" value="添加 " /></td>
  <td><input type="submit" name="submit" value="修改 " /></td>
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

