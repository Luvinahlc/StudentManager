<%@page language="java" contentType="text/html; charset=GBK"%>
<%@page import="java.sql.*,com.stuman.domain.*" errorPage="errorpage.faces"%>
<html>
	<head>
		<title>管理员登陆</title>
	</head>
	<body>
		<p>
			<%/*
			 String admin_id = (String)session.getAttribute("id"); 
			 System.out.println(admin_id);
			 if(admin_id==null){response.sendRedirect("login.faces");}      
			 */
		%>
		<center>
		<br><br>
			您以经登录! 点击下面连接执行相关操作
		</center>
		<br>
		<table align="center">
			<tr>
				<td>
					<a href="getStudent.faces">学生</a> &gt;&gt;
				</td>
				<td>
					<a href="getteacher.faces"> 教务员 </a>&gt;&gt;
				</td>
				<td>
					<a href="getcourse.faces">课程</a>&gt;&gt;
				</td>
				<td>
					<a href="getClass.faces">申请</a>
				</td>
			</tr>
		</table>

		<p>
			&nbsp;
		</p>
		<p>
			<a href="login_confirm? action=/logout">&lt;&lt;注销 </a>
		</p>
	</body>
</html>
