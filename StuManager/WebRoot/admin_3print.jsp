<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<jsp:useBean id="SelectCourseBean" class="com.stuman.web.jsf.bean.SelectCourseBean" scope="page"/>
<jsp:setProperty property="*" name="SelectCourseBean"/>
<% 	String submit=request.getParameter("submit");
	if(submit!=null){
		if(!SelectCourseBean.checkstuExist())
			SelectCourseBean.setMsg("该学生不存在");
		else
			SelectCourseBean.checklist(); 
	}
%>

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

<<<<<<< HEAD
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
			<div align="center"><label   style="color :#FF0000"><%=SelectCourseBean.getMsg()%></label></div>
  <div  align="center" style="width: 100%">
    <TABLE width="100%"  height="100%" align="center" >
      <tr><td height="15"></td></tr>
      <TR align="center">
		<TD width="10" >&nbsp;</TD>
        <TD align="center" valign="top">
        
        <form action="admin_3print.jsp" method="post">
	<table width="25%" align="right">
	<tr>
  <td > 请输入学号：</td>
  <td><input type="text" name="sno" value=<%=SelectCourseBean.getSno()%> /> </td>
  <td><input type="submit" name="submit" value="确定 " /></td>
  </tr>
   </table>
   
   	
 
			<table width="95%"  class="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">
				<tr class="TABLE_TH">
				  <th >序号</th>
				  <th >课程号</th>
				  <th >课程名称</th>
				  <th >学分</th>
				  <th >开课院系</th>
				  <th >成绩</th>
				 
				  </tr>
				 
				 <%int num=SelectCourseBean.getCourses().size();
				   for(int i=0;i<num;i++){
				   	if(i%2 == 0) {%>
				   	<tr align="left" class="TABLE_TR_01">
				   	<% }%>
				   	<%if(i%2 == 1) {%>
				   	<tr align="left" class="TABLE_TR_02">
				   	<% }%>
			
				   	<td valign="middle"><%=i+1%></td>
					<td valign="middle"><%=((Selectcourse)(SelectCourseBean.getCourses().get(i))).getId().getCno()%></td>
					<td valign="middle"><%=(SelectCourseBean.getCourinfo().get(i)).getCname()%></td>
					<td valign="middle"><%=(SelectCourseBean.getCourinfo().get(i)).getCredit()%></td>
					<td valign="middle"><%=(SelectCourseBean.getCourinfo().get(i)).getCdept()%></td>
					<td valign="middle"><%=((Selectcourse)(SelectCourseBean.getCourses().get(i))).getScore()%></td>
				   	</tr>	
				  
				   <% }%>
				   
			</table>
			
			<br />
	
  <label><input type="button" value="打印 " onclick="window.focus();window.print()"></label>


				</form>
			</TD>
			</TR>
			</TABLE>
			</div>

	
  </body>
  
</html>
=======
>>>>>>> eb647a47dce07219b51251026e57ad5df93dacf2
  </body>
</html>

