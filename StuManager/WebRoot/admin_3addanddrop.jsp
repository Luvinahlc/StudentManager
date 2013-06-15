<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<jsp:useBean id="SelectCourseBean" class="com.stuman.web.jsf.bean.SelectCourseBean" scope="page"/>
<jsp:setProperty property="*" name="SelectCourseBean"/>
<%	String sno=request.getParameter("sno");
	String cno=request.getParameter("cno");	
 
	if(sno!=null){
		boolean flag=SelectCourseBean.checkstuExist();
		if(!flag) {
			SelectCourseBean.setMsg("该学生学号不存在");
		}
		else if(cno!=null){
			SelectCourseBean.dropSelectedCourse(sno,cno);
			request.removeAttribute("sno");
			request.removeAttribute("cno");
		}
		else
			request.removeAttribute("sno");
	}
 	 %>
 	 
<%  String sno1=request.getParameter("sno1"); 
	String cno1=request.getParameter("cno1");
	String teacher=request.getParameter("teacher");
	
	if(sno1!=null){
	SelectCourseBean.setSno(sno1);
	boolean flag=SelectCourseBean.checkstuExist();
		if(!flag) {
			SelectCourseBean.setMsg("该学生学号不存在");
		}
		else if(cno1!=null&&teacher!=null){
			teacher=new String(teacher.getBytes("ISO-8859-1"),"utf8");
			System.out.println(teacher);
			SelectCourseBean.setCno(cno1);
			if(SelectCourseBean.checkSelectExist())
				SelectCourseBean.setMsg("该选课记录已存在");
			else{				
				if(SelectCourseBean.ChooseCourse(sno1,cno1,teacher)){
					SelectCourseBean.setMsg("选课成功");
				}
				else
					SelectCourseBean.setMsg("选课失败");
			}
		
			request.removeAttribute("sno1");
			request.removeAttribute("cno1");
			request.removeAttribute("teacher");
		}
		else
			request.removeAttribute("sno1");
	}
	%>

<% SelectCourseBean.checkSelectedCourse(); %>
<% SelectCourseBean.checkCourse(); %>
<% SelectCourseBean.checkCoursePlan(); %>
<%@page import ="com.stuman.domain.Selectcourse" %>
<%@page import ="com.stuman.domain.SelectcourseId" %>
<html >
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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
    <script type="text/javascript">
	function selectItem(idName)
	{
		var idStr = "";
		document.getElementById("d11").className = "DIV_HIDDEN";
		document.getElementById("d22").className = "DIV_HIDDEN";
		document.getElementById("tab1").className = "TAB_UNSELECTED";
		document.getElementById("tab2").className = "TAB_UNSELECTED";
		var clickOb  = document.getElementById(idName);
		clickOb.className = "TAB_SELECTED";
		if(idName == "tab1")
		{
			idStr = "d11";
		}
		else if(idName == "tab2")
		{
			idStr = "d22";
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
	function con(sno,cno){
        if(window.confirm("确认退选？")){
           location.href="admin_3addanddrop.jsp?sno="+sno+"&cno="+cno;  
       }
   }
   
    function con1(sno1,cno1,teacher){
        if(window.confirm("确认选课？")){
           location.href="admin_3addanddrop.jsp?sno1="+sno1+"&cno1="+cno1+"&teacher="+teacher; 
       }
   }
    </script>
  </head>

<body class="BODY"  leftmargin="50" rightmargin="50" onLoad="selectItem('tab2')" >
  <div  align="center">
  
  		<div style="position:absolute; top:100px; left:50px; height:80px; width:250px;">	
				<table width="100%" border="0" borderColor="#3366CC">
					<tr  height="20">
						<td id='tab1' class="TAB_SELECTED"   onClick="javascript:selectItem('tab1')"  onMouseOver="javaScript:mouseOver('tab1')"> 
							已选课程
				 		</td>
						<td id='tab2' class="TAB_SELECTED" onClick="javascript:selectItem('tab2')" onMouseOver="javaScript:mouseOver('tab2')" >
							 可选课程
						</td>
					</tr>
				</table>
			</div>

    

      <div id="d11" class=DIV_HIDDEN >
   
			<table width="95%"  class="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">
				<tr class="TABLE_TH">
				  <th >学号</th>
				  <th >课程号</th>
				  <th >成绩</th>
				  <th >任课教师</th>
				  <th>操作 </th>
				  </tr>
				 
				 <%int listnum=SelectCourseBean.getCourses().size();
				   for(int i=0;i<listnum;i++){
				   	if(i%2 == 0) {%>
				   	<tr align="left" class="TABLE_TR_01">
				   	<% }%>
				   	<%if(i%2 == 1) {%>
				   	<tr align="left" class="TABLE_TR_02">
				   	<% }%>
				
				   	<td valign="middle"><%=((Selectcourse)(SelectCourseBean.getCourses().get(i))).getId().getSno()%></td>
					<td valign="middle"><%=((Selectcourse)(SelectCourseBean.getCourses().get(i))).getId().getCno()%></td>
					<td valign="middle"><%=((Selectcourse)(SelectCourseBean.getCourses().get(i))).getScore()%></td>
					<td valign="middle"><%=((Selectcourse)(SelectCourseBean.getCourses().get(i))).getTeacher()%></td>
					<td><a href = "javascript:con(<%=((Selectcourse)(SelectCourseBean.getCourses().get(i))).getId().getSno()%>,<%=((Selectcourse)(SelectCourseBean.getCourses().get(i))).getId().getCno()%>)">退选</a></td>
				   	</tr>	
				  
				   <% }%>
				   
			</table>
			</div>
<div id="d22" class=DIV_HIDDEN >
<form action="admin_3addanddrop.jsp" method="post">
	<table width="95%">
	<tr>
  <td > 请输入学号：</td>
  <td><input type="text" name="sno" value=<%=SelectCourseBean.getSno()%> /> </td>
  <td><input type="submit" name="submit" value="确定 " /></td>
  </tr>
   </table>
   	</form>
   	<label style="color :#FF0000"><%=SelectCourseBean.getMsg()%></label>
   	<br />
   	
   <br />
			<table width="95%"  class="TABLE_BODY" bordercolor="#777777" border="1" style="border-color:#777777;border-collapse:collapse">
				<tr class="TABLE_TH">
				  <th >课程号</th>
				  <th >课程名称</th>
				  <th >学分</th>
				  <th >学时</th>
				  <th> 开课院系</th>
				  <th >教师</th>
				  <th> 操作 </th>
				  </tr>
			
	 <%int litnum=SelectCourseBean.getCrs().size();
				   for(int i=0;i<litnum;i++){
				   	if(i%2 == 0) {%>
				   	<tr align="left" class="TABLE_TR_01">
				   	<% }%>
				   	<%if(i%2 == 1) {%>
				   	<tr align="left" class="TABLE_TR_02">
				   	<% }%>
				
				   	<td valign="middle"><%=(SelectCourseBean.getCourinfo().get(i)).getCno()%></td>
					<td valign="middle"><%=((SelectCourseBean.getCourinfo().get(i))).getCname()%></td>
					<td valign="middle"><%=((SelectCourseBean.getCourinfo().get(i))).getCredit()%></td>
					<td valign="middle"><%=((SelectCourseBean.getCourinfo().get(i))).getHour()%></td>
					<td valign="middle"><%=((SelectCourseBean.getCourinfo().get(i))).getCdept()%></td>
					<td valign="middle"><%=((SelectCourseBean.getCrs().get(i))).getTeacher()%></td>
					<td valign="middle"><a href="javascript:con1(<%=SelectCourseBean.getSno()%>,<%=(SelectCourseBean.getCourinfo().get(i)).getCno()%>,'<%=((SelectCourseBean.getCrs().get(i))).getTeacher()%>')">选课</a></td>
				   	</tr>	
				  
				   <% }%>
				   
			</table>
	
			</div>
	</div>
  </body>
  
</html>
  </body>
</html>

