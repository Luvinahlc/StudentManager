<%@page language="java" contentType="text/html; charset=utf-8"%>
<jsp:useBean id="StudentBean" class="com.stuman.web.jsf.bean.StudentBean" scope="page"/>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%  
	String str=request.getParameter("submit");
	if(str!=null)
	{
		str=new String(str.getBytes("ISO-8859-1"),"utf8"); 
		System.out.println(str);
		StudentBean.setMsg("");
	
		if(str.contains("查询"))
		{
			String sno=request.getParameter("sno");
			StudentBean.queryStuInfo(sno);	
		}
		if(str.contains("统计"))
		{
			String sno=request.getParameter("stuno");
			StudentBean.queryStuInfo(sno);
			StudentBean.setMsg("");
			String dept=request.getParameter("deps");
			StudentBean.setdptname(dept);
			StudentBean.listStudentbydept(dept);
		}
	}	 
%>
<%StudentBean.listdepname(); %>

<html>
  <head>
    <title>南京大学教务系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 <link href="css/inner.css" rel="stylesheet" type="text/css"> 
	 <link href="css/table.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
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
    <li id="teachinginfo"><a href="admin_graduateinfo.faces">毕业信息管理</a></li>
  </ul>
</div>
	</div>

<div align="center">
学籍信息查询
<hr >
				<font style="font-size: 12px;font-weight:bold;color: #FF0000"></font><br>
					<form action="admin_3infoquerystatistics.jsp" method="post" >	
						学号: 
						<input type="text" name="sno">
							<br/>
						<input type="submit" name="submit" value="查询">
							<br/>
						<label style="color :#FF0000"><%=StudentBean.getMsg()%></label>
							<br />
					</form>
</div>


<div id="d11" align="center" >
			<table width="90%" CLASS="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">
				<tr><th colspan="7"  class="TABLE_TH" >学籍信息</th></TR>
						<tr height="27">
							<td rowspan="5" align="left" width="100"><img src="images/common.jpg" width="100" height="135"/></td>
							<td  class="TABLE_TD_02"  width="150" >学号</td>
							<td class="TABLE_TD_01" width="150" ><%=StudentBean.getSno()%></td>
							<td class="TABLE_TD_02" width="150" >姓名</td>
							<td class="TABLE_TD_01" width="150" ><%=StudentBean.getSname() %></td>
							<td class="TABLE_TD_02" width="150" >性别</td>
							<td class="TABLE_TD_01" width="150" ><%=StudentBean.getGender() %></td>
						</tr>
						<tr height="27">
							<td  class="TABLE_TD_02">出生日期</TD>
							<td class="TABLE_TD_01"><%=StudentBean.getsbirthday() %></TD>
							<td  class="TABLE_TD_02">身份证号</TD>
							<td colspan="3" class="TABLE_TD_01"><%=StudentBean.getSidno() %></TD>
						</tr>
						
						<tr height="27">
						<td  class="TABLE_TD_02">年级</TD>
							<td class="TABLE_TD_01"><%=StudentBean.getGrade() %></TD>
							<td  class="TABLE_TD_02">毕业时间</TD>
							<td class="TABLE_TD_01"><%=StudentBean.getgraduationDate() %></TD>
							<td  class="TABLE_TD_02">学位</TD>
							<td class="TABLE_TD_01"><%=StudentBean.getDegree() %></TD>
						</tr>
						
						<tr height="27">
							<td  class="TABLE_TD_02">所在院系</TD>
							<td class="TABLE_TD_01"><%=StudentBean.getSdept() %></TD>
							<td  class="TABLE_TD_02">所在专业</TD>
							<td colspan="3" class="TABLE_TD_01"><%=StudentBean.getMajor() %></TD>
						</tr>

						<tr height="27">	
							<td  class="TABLE_TD_02">专业方向</TD>
							<td class="TABLE_TD_01"><%=StudentBean.getField() %></TD>						
							<td  class="TABLE_TD_02">导师</TD>
							<td colspan="3" class="TABLE_TD_01"><%=StudentBean.getTutor() %></TD>
						</tr>
					
			</table>

学籍信息统计
<hr >
<div align="center">
		<form action="admin_3infoquerystatistics.jsp?stuno=<%=StudentBean.getSno()%>" method="post" >
				  院系	
				 <select name="deps">
				<%int listnum=StudentBean.getdepname().size();
				   for(int i=0;i<listnum;i++){%>
					<option value="<%=StudentBean.getdepname().get(i)%>"><%= StudentBean.getdepname().get(i)%></option>
					<%} %>
					</select>
					<br/>
					<input type="submit" name="submit" value="统计">
					
		</form>
</div>
<TD  >
	    	<table width="70%"  class="TABLE_BODY">
				<tr class="TABLE_TH">
				<th align="center">院系</th>
				  <th align="center">学生人数</th>
					<tr class="TABLE_TR_02">				    					    
						<td align="center" width="200">
						<%=StudentBean.getdptname()%>
						</td>			    					    
						<td align="center" width="200">
						<%=StudentBean.getStuNum() %>
						</td>

					</tr>
			</table>				
		</TD>
	 </div>
  </body>
</html>

