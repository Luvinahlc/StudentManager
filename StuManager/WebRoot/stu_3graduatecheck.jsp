<%@page language="java" contentType="text/html; charset=utf-8"%>
<jsp:useBean id="StudentBean" class="com.stuman.web.jsf.bean.StudentBean" scope="page"/>
<%StudentBean.setSno((String)(session.getAttribute("id")));
StudentBean.CheckStuInfo(); %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<html>
  <head>
    <title>南京大学教务系统</title>
    <base href="login.jsp">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/inner.css" rel="stylesheet" type="text/css">  
  </head>
  <!--[if lte IE 6.0000]>
  	<script language="javascript" src="js/pngfix.js"></script>
  <![endif]--> 
  <body >
	<div id="Header">
<div id="Logo"><a href="student/index.do#"><img src="images/Logo_Student.jpg" border="0"></a></div>
<div id="TopLink"><img src="image/Icon_Help.gif"><a href="student/index.do#">帮助</a>&nbsp;&nbsp;&nbsp;&nbsp;<img src="image/Icon_Exit.gif"><a href="login.faces">退出</a></div>
<div id="UserInfo">~~欢迎您~~</div>
<script type="text/javascript" language="javascript" src="js/prototype.js"></script>
<div id="Nav">
  <ul>
    <li id="homepage"><a href="student/index.do">首  页</a></li>
    <li id="studentinfo"><a href="stu_information.faces">个人信息</a></li>
    <li id="teachinginfo"><a href="stu_gradelook.faces">成绩查看</a></li>
    <li id="teachinginfo"><a href="stu_courseplan.faces">学期选课</a></li>

  </ul>
</div>
	</div>
<html>
  <head>
    <base href="login.jsp">
    <title>学生信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
    <link href="css/table.css" rel="stylesheet" type="text/css">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">

	function selectItem(idName)
	{
		var idStr = "";
		document.getElementById("d11").className = "DIV_HIDDEN";
		document.getElementById("tab1").className = "TAB_UNSELECTED";
		var clickOb  = document.getElementById(idName);
		clickOb.className = "TAB_SELECTED";
		if(idName == "tab1")
		{
			idStr = "d11";
		}
		var  divOb  = document.getElementById(idStr);
		divOb.className = "DIV_SHOW";
	}
	function mouseOver(idName)
	{
		var ob = document.getElementById(idName);
		var name = ob.className;
		name = name.replace("CURSOR_HAND");
		ob.className = name+" CURSOR_HAND ";
	}

</script>

</head>
<body class="BODY"  leftmargin="50" rightmargin="50" 
	onLoad="selectItem('tab1')"
>
  <div  align="center">
			<div style="position:absolute; top:100px; left:50px; height:80px; width:250px;">	
				<table width="100%" border="0" borderColor="#3366CC">
					<tr  height="20">
						<td id='tab1' class="TAB_SELECTED"   onClick="javascript:selectItem('tab1')"  onMouseOver="javaScript:mouseOver('tab1')"> 
							毕业信息
				 		</td>
					</tr>
				</table>
			</div>
		<div id="d11" class=DIV_HIDDEN >
			<table width="100%" CLASS="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">
				<tr><th colspan="7"  class="TABLE_TH" >毕业信息</th></TR>
						<tr height="27">
							<td rowspan="5" align="left" width="100"><img src="images/common.jpg" width="100" height="135"/></td>
							<td  class="TABLE_TD_02">学号</td>
							<td class="TABLE_TD_01"><%=StudentBean.getSno()%></td>
							<td class="TABLE_TD_02">姓名</td>
							<td class="TABLE_TD_01"><%=StudentBean.getSname() %></td>
							<td class="TABLE_TD_02">性别</td>
							<td class="TABLE_TD_01"><%=StudentBean.getGender() %></td>
						</tr>
						<tr height="27">
							<td  class="TABLE_TD_02">出生日期</TD>
							<td class="TABLE_TD_01"><%=StudentBean.getSbirthday() %></TD>
							<td  class="TABLE_TD_02">身份证号</TD>
							<td colspan="3" class="TABLE_TD_01"><%=StudentBean.getSidno() %></TD>
							
						</tr>
						
						<tr height="27">
						<td  class="TABLE_TD_02">年级</TD>
							<td class="TABLE_TD_01"><%=StudentBean.getGrade() %></TD>
							<td  class="TABLE_TD_02">毕业时间</TD>
							<td class="TABLE_TD_01"><%=StudentBean.getGraduationDate() %></TD>
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
		 </div>
		
  </div>
  </body>
</html>
  </body>
</html>



