<%@page language="java" contentType="text/html; charset=utf-8"%>
<jsp:useBean id="StudentBean" class="com.stuman.web.jsf.bean.StudentBean" scope="page"/>
<%@ page import="java.sql.Date" %>
<%	StudentBean.setSno((String)(session.getAttribute("id")));
	StudentBean.CheckStuInfo(); %>
<%
	String idno=request.getParameter("idno");
	String birthday=request.getParameter("birthday");
	System.out.println("bir:"+birthday);
	if(idno!=null&&birthday!=null){
<<<<<<< HEAD
		if(idno.length()!=18){
			StudentBean.setMsg("请输入正确的身份证号");
		}
		else{
			boolean flag=true;
			for(int i=0;i<17;i++){
				if(!Character.isDigit(idno.charAt(i))){
					flag=false;
					break;
				}
			}
			if(!(Character.isDigit(idno.charAt(17))||idno.charAt(17)=='x'||idno.charAt(17)=='X')){
				flag=false;
			}
			if(flag){
				StudentBean.setSidno(idno);
				System.out.println(birthday);
				StudentBean.setSbirthday(Date.valueOf(birthday));
				if(StudentBean.modifyStuInfo())
					StudentBean.setMsg("修改成功");
				else
					StudentBean.setMsg("修改失败");
				}
			else
				StudentBean.setMsg("请输入正确的身份证号");
		}
			
=======
		StudentBean.setSidno(idno);
		System.out.println(birthday);
		StudentBean.setSbirthday(Date.valueOf(birthday));
		StudentBean.modifyStuInfo();
>>>>>>> 5e5c5985879fcd38cca9b1df0bf979028fec51ee
	}
	request.removeAttribute("idno");
	request.removeAttribute("birthday");
 %>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
  <head>
    <title>南京大学教务系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 <link href="css/inner.css" rel="stylesheet" type="text/css"> 
  </head>
  <body >
	<div id="Header">
<div id="Logo"><a href="student.faces"><img src="images/Logo_Student.jpg" border="0"></a></div>
<div id="TopLink"><img src="images/Icon_Help.gif"><a href="student/index.do#">帮助</a>&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/Icon_Exit.gif"><a href="login.faces">退出</a></div>
<div id="UserInfo">~~欢迎您~~</div>
<script type="text/javascript" language="javascript" src="js/prototype.js"></script>
<div id="Nav">
  <ul>
    <li id="homepage"><a href="student.faces">首  页</a></li>
    <li id="studentinfo"><a href="stu_information.faces">个人信息</a></li>
    <li id="teachinginfo"><a href="stu_gradelook.faces">成绩查看</a></li>
    <li id="teachinginfo"><a href="stu_courseplan.faces">学期选课</a></li>
  </ul>
</div>
	</div>
	
	
<html>
  <head>
    <base>
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
		document.getElementById("d22").className = "DIV_HIDDEN";
		document.getElementById("tab2").className = "TAB_UNSELECTED";
		
		var clickOb  = document.getElementById(idName);
		clickOb.className = "TAB_SELECTED";

		 if(idName == "tab2")
		{
			idStr = "d22";
		}
	
		var  divOb  = document.getElementById(idStr);
		divOb.className = "DIV_SHOW";
	
	}
</script>

</head>

<body class="BODY"  leftmargin="50" rightmargin="50" 
 
	onLoad="selectItem('tab2')"
 
>

	<div  align="center">
			<div style="position:absolute; top:100px; left:50px; height:80px; width:250px;">	
				<table width="100%" border="0" borderColor="#3366CC">
					<tr  height="20">
						<td id='tab2' class="TAB_SELECTED"   onClick="javascript:selectItem('tab1')"  onMouseOver="javaScript:mouseOver('tab1')"> 
							学生信息查看和修改
				 		</td>
					</tr>
				</table>
			</div>
	
		<div id="d22" class="DIV_HIDDEN" >
			<form action="stu_3infolookandmodi.jsp" method="post">
				<table width="100%" CLASS="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">
					<tr><th colspan="7"  class="TABLE_TH" >基本信息</th></tr>
					
						
							<tr height="27">
								<td rowspan="5" align="left" width="100"><img src="images/common.jpg" width="100" height="135"/></td>
								<td class="TABLE_TD_02">学号<br></TD>
								<td class="TABLE_TD_01"><%=StudentBean.getSno()%><br></TD>
								<td class="TABLE_TD_02">姓名<br></TD>
								<td class="TABLE_TD_01"><%=StudentBean.getSname() %><br></TD>
								
							</tr>
							
							<tr height="27">
								<td class="TABLE_TD_02">性别<br></TD>
								<td class="TABLE_TD_01"><%=StudentBean.getGender() %><br></TD>
								<td  class="TABLE_TD_02">出生日期<br></TD>
								<td class="TABLE_TD_01"><input id="birthday" name="birthday"  maxlength="200" value=<%=StudentBean.getSbirthday() %> /><br></TD>
							</tr>
							
							<tr height="27">
								<td  class="TABLE_TD_02">身份证号<br></TD>
								<td  class="TABLE_TD_01"><input id="idno" name="idno" maxlength="200" value=<%=StudentBean.getSidno() %> /><br></TD>
								<td  class="TABLE_TD_02">院系<br></TD>
								<td  class="TABLE_TD_01"><%=StudentBean.getSdept() %><br></TD>
							</tr>
							
							<tr height="27">
								<td  class="TABLE_TD_02">专业<br></TD>
								<td  class="TABLE_TD_01"><%=StudentBean.getMajor() %><br></TD>
								<td  class="TABLE_TD_02">方向<br></TD>
								<td  class="TABLE_TD_01"><%=StudentBean.getField() %><br></TD>
							</tr>
							
							<tr height="27">
								<td  class="TABLE_TD_02">年级<br></TD>
								<td  class="TABLE_TD_01"><%=StudentBean.getGrade() %><br></TD>
								<td  class="TABLE_TD_02"><br></TD>
								<td  class="TABLE_TD_01"><br></TD>
							</tr>
							
							<tr height="27">
								<td COLSPAN="6" Style="text-align:center"><input type="submit" value="保  存" >
								</td>
								
							</tr>			
				</table>
			</form>
		</div>
	</div>
	
</body>
</html>


	
	
<div class="Line"></div>
  </body>
</html>

