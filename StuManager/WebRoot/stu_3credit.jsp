
<%@page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<jsp:useBean id="StudentBean" class="com.stuman.web.jsf.bean.StudentBean" scope="page"/>
<%	String sno = (String)session.getAttribute("id");
	StudentBean.countCredit(sno); %>
<html xmlns="http://www.w3.org/1999/xhtml">
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
    <base href="login.faces">
    <title>学分信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
    <link href="css/table.css" rel="stylesheet" type="text/css">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<style type="text/css">
<!--
.STYLE2 {
	font-size: 14px;
	font-weight: bold;
	color: #ffffff;
}
-->
</style>

  </head>

  <body class="BODY"  leftmargin="50" rightmargin="50">
   
  <div  align="center">
    <TABLE width="100%"  height="10%" align="left" >
      <TR>
        <TD colspan="4">&nbsp;</TD>
      </TR>
      
      <TR align="left">
      	<TD width="50">&nbsp;</TD>
        <TD width="150"  align="right" valign="top">
			<div>
				<table  width="100%" height="100%" border="0"  bordercolor="#3366CC">
				       <tr></tr><tr></tr>
					   <tr class="TEXT_TITLE"><td>学分统计 </td></tr>
				       <tr height="5"><td > </td></tr>   
			   </table>
			</div>
		</TD>
		<TD width="10" >&nbsp;</TD>
        <TD align="left" valign="top">
	    	<table width="95%"  class="TABLE_BODY">
				<tr class="TABLE_TH">
				  <th align="center">总学分数</th>
				  
				</tr>
				
					<tr class="TABLE_TR_02">				    					    
						<td align="center"><%=StudentBean.getSum() %></td>
						
					</tr>					
				
			</table>				
		</TD>
      </TR>
    </TABLE>
  </div>
  </body>
</html>
	
<div class="Line"></div>
  </body>
</html>

