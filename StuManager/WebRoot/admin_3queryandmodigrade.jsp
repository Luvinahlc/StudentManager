<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<jsp:useBean id="SelectCourseBean" class="com.stuman.web.jsf.bean.SelectCourseBean" scope="request"/>
<jsp:setProperty property="*" name="SelectCourseBean"/>
<%	
	String str=request.getParameter("submit");
	if(str!=null){
		str=new String(str.getBytes("ISO-8859-1"),"utf8");
		System.out.println(str);
		if(str.contains("查询")){
			if(!SelectCourseBean.checkSelectExist()){
				SelectCourseBean.setMsg("该选课记录不存在");
			}
			else
				SelectCourseBean.checkScore();
		}
		if(str.contains("修改")){
			if(!SelectCourseBean.checkSelectExist()){
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
  <div  align="center" style="width: 100%">
   <form action="admin_3queryandmodigrade.jsp" method="post">
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
  
</html>
	
  </body>
</html>

