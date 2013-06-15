<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.*"%>
<%@page import="com.stuman.web.jsf.bean.AcademicBean"%>
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
		StudentBean.setmsg_save("");
	
		if(str.contains("查询"))
		{
		String sno=request.getParameter("sno");
		System.out.println(sno);
		StudentBean.queryStuInfo(sno);
		
		}
		if(str.contains("保存")){
		{
		String sno=request.getParameter("stuno");
		System.out.println(sno);
		StudentBean.queryStuInfo(sno);
		
		String sname=request.getParameter("name");
		if(sname!=null)
		{
			StudentBean.setSname(sname);
		}
		String sgender=request.getParameter("gend");
		sgender=new String(sgender.getBytes("ISO-8859-1"),"utf8");
		if(sgender!=null)
		{
			Integer gender=0;
			if(sgender.contains("男")) gender=1;
			else if(sgender.contains("女")) gender=0;
			StudentBean.setSgender(gender);
		}
		String sbirthday=request.getParameter("birt");
		if(sbirthday!=null)
		{
			StudentBean.setSbirthday(Date.valueOf(sbirthday));
		}
		String sidno=request.getParameter("idno");
		if(sidno!=null)
			StudentBean.setSidno(sidno);
		String sgrade=request.getParameter("grad");
		if(sgrade!=null)
			StudentBean.setGrade(sgrade);
		String sgraduationDate=request.getParameter("gdate");
		
		if(sgraduationDate!=null)
		{
			StudentBean.setGraduationDate(Date.valueOf(sgraduationDate));
		}
		String sdegree=request.getParameter("degr");
		if(sdegree!=null)
			StudentBean.setDegree(sdegree);
			
		String sdept=request.getParameter("dept");
		if(sdept!=null)
			StudentBean.setdptname(sdept);
			
		String smajor=request.getParameter("majo");
		if(smajor!=null)
			StudentBean.setMajor(smajor);
		
		String sfield=request.getParameter("fiel");
		if(sfield!=null)
			StudentBean.setField(sfield);
			
		String stutor=request.getParameter("tuto");
		if(stutor!=null)
			StudentBean.setTutor(stutor);
			
		StudentBean.modifyStuInfo();
		StudentBean.setmsg_save("保存成功");
	}	
  }
}
%>
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
<script type="text/javascript" src="js/date.js"></script>
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
学籍信息查询与修改
<hr >
				<font style="font-size: 12px;font-weight:bold;color: #FF0000"></font><br>
					<form action="admin_3lookandmodi.jsp" method="post" >
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
		<form action="admin_3lookandmodi.jsp?stuno=<%=StudentBean.getSno()%>" method="post">
			<table width="90%" CLASS="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">
				<tr><th colspan="7"  class="TABLE_TH" >学籍信息</th></TR>
						<tr height="27">
							<td rowspan="5" align="left" width="100"><img src="images/common.jpg" width="100" height="135"/></td>
							<td  class="TABLE_TD_02">学号</td>
							<td class="TABLE_TD_01"><%=StudentBean.getSno()%></td>
							<td class="TABLE_TD_02">姓名</td>
							<td class="TABLE_TD_01"><input type="text" name="name" value="<%=StudentBean.getSname()%>"/></td>
							<td class="TABLE_TD_02">性别</td>
							<td class="TABLE_TD_01"><input type="text" name="gend" value="<%=StudentBean.getGender()%>"/></td>
						</tr>
						<tr height="27">
							<td  class="TABLE_TD_02">出生日期</TD>
							<td class="TABLE_TD_01"><input id="date" type="text" name="birt" onClick="javascript:ShowCalendar(date)" value="<%=StudentBean.getsbirthday()%>"/></TD>
							<td  class="TABLE_TD_02">身份证号</TD>
							<td colspan="3" class="TABLE_TD_01"><input type="text" name="idno" value="<%=StudentBean.getSidno() %>"/></TD>
						</tr>
						
						<tr height="27">
						<td  class="TABLE_TD_02">年级</TD>
							<td class="TABLE_TD_01"><input name="grad" type="text" value="<%=StudentBean.getGrade() %>"/></TD>
							<td  class="TABLE_TD_02">毕业时间</TD>
							<td class="TABLE_TD_01"><input id="date1" type="text" name="gdate" onClick="javascript:ShowCalendar(date1)" value="<%=StudentBean.getgraduationDate() %>"/></TD>
							<td  class="TABLE_TD_02">学位</TD>
							<td class="TABLE_TD_01"><input name="degr" type="text" value="<%=StudentBean.getDegree() %>"/></TD>
						</tr>
						
						<tr height="27">
							<td  class="TABLE_TD_02">所在院系</TD>
							<td class="TABLE_TD_01"><input name="dept" type="text"  value="<%=StudentBean.getSdept() %>"/></TD>
							<td  class="TABLE_TD_02">所在专业</TD>
							<td colspan="3" class="TABLE_TD_01"><input name="majo"  type="text" value="<%=StudentBean.getMajor() %>"/></TD>
						</tr>

						<tr height="27">	
							<td  class="TABLE_TD_02">专业方向</TD>
							<td class="TABLE_TD_01"><input name="fiel" type="text"  value="<%=StudentBean.getField()%>"/></TD>						
							<td  class="TABLE_TD_02">导师</TD>
							<td colspan="3" class="TABLE_TD_01"><input name="tuto" type="text"  value="<%=StudentBean.getTutor()%>"/></TD>
						</tr>
					
			</table>
						<input type="submit" name="submit" value="保存">
						<label style="color :#FF0000" ><%=StudentBean.getmsg_save() %></label>
</form>
	 </div>
  </body>
</html>

