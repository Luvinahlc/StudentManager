<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<jsp:useBean id="SelectCourseBean" class="com.stuman.web.jsf.bean.SelectCourseBean" scope="request"/>
<jsp:setProperty property="*" name="SelectCourseBean"/>
<%	
    String startTimes=request.getParameter("startTime");
	String endTimes=request.getParameter("endTime");
	if(startTimes!=null&&endTimes!=null){
		if(SelectCourseBean.getStartTime()==null||SelectCourseBean.getEndTime()==null){
			SelectCourseBean.setMsg("请输入完整的起止时间");
		}
		else if(!SelectCourseBean.isTimeCorrect()){
			SelectCourseBean.setMsg("截止时间不能早于开始时间！");
		}
		else{
			if(SelectCourseBean.getScoreentertime())
				SelectCourseBean.setMsg("修改成功");
			else
				SelectCourseBean.setMsg("修改失败");
			request.removeAttribute("startTime");
			request.removeAttribute("endTime");
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
<script type="text/javascript" src="js/date.js"></script>
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
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
    <link href="css/table.css" rel="stylesheet" type="text/css">
	<script type="text/javascript"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  </head>
	<body class="BODY"  leftmargin="50" rightmargin="50">
	<label style="color :#FF0000"><%=SelectCourseBean.getMsg()%></label>
  <div  align="center" style="width: 100%">
    <TABLE width="100%"  height="100%" align="center" >
      <tr><td height="15"></td></tr>
      <TR align="center">
		<TD width="10" >&nbsp;</TD>
        <TD align="center" valign="top">
	 <form action="admin_3gradetime.jsp" method="post">
	
   <table width="55%" align="left">
	<tr class="TABLE_TH">
				  <th colspan="7" >设置教务员录入成绩的起止时间</th>
	 </tr>
				 
	<tr align="left" class="TABLE_TR_01">
  <td > 开始时间：</td>
  <td><input type="text" id="date" onClick="javascript:ShowCalendar(date)" name="startTime"  /></td>

   <td > 结束时间：</td>
<td><input type="text" id="date2" onClick="javascript:ShowCalendar(date2)" name="endTime"  /></td>
  </tr>
  <tr >
  <td><input type="submit" name="submit" value="确定 " /></td>
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

