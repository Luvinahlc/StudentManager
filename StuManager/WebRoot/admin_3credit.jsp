<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<jsp:useBean id="SelectCourseBean" class="com.stuman.web.jsf.bean.SelectCourseBean" scope="page"/>
<jsp:useBean id="StudentBean" class="com.stuman.web.jsf.bean.StudentBean" scope="page"/>
<%  
	String sno=request.getParameter("sno");
	SelectCourseBean.setSno(sno);
	System.out.println(SelectCourseBean.getSno());
	if(sno==null)SelectCourseBean.setMsg("");
	if(sno!=null){
	    
		if(SelectCourseBean.checkstuExist()==false)SelectCourseBean.setMsg("该学生学号不存在");
		System.out.println(sno);
		request.removeAttribute("sno");
	} %>
<%@page import ="com.stuman.domain.Courseinfo" %>
<%@page import ="com.stuman.domain.Courseplan" %>
<html>
  <head>
    <title>南京大学教务系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 <link href="css/inner.css" rel="stylesheet" type="text/css">
	 <link href="css/table.css" rel="stylesheet" type="text/css">
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
	<div id="admin_3credit" align="center">
				<font style="font-size: 12px;font-weight:bold;color: #FF0000"></font><br>
					<form action="admin_3credit.jsp" method="post" >	
						学号: 
						<input type="text" name="sno">
							<br/>
						<input type="submit" value="查询">
					
							<br/>
						<label style="color :#FF0000"><%=SelectCourseBean.getMsg()%></label>
							<br />	
						</form>
	
	<TD  >
	    	<table width="70%"  class="TABLE_BODY">
				<tr class="TABLE_TH">
				<th align="center">学号</th>
				<th align="center">姓名</th>
				  <th align="center">学分总数</th>
					<tr class="TABLE_TR_02">				    					    
						<td width="200" align="center">
						<%=SelectCourseBean.getsno()%>
						</td>			
						<td align="center"  width="150" >
						<%=SelectCourseBean.getsname()%>
						</td>		    					    
						<td align="center"  width="150">
						<%=SelectCourseBean.getSumCredit()%>
						</td>

					</tr>
			</table>				
		</TD>
	</div>
  </body>
</html>

