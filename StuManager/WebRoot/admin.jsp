<%@page language="java" contentType="text/html; charset=GBK"%>
<%@page import="java.sql.*,com.stuman.domain.*" errorPage="errorpage.faces"%>
<html>
	<head>
		<title>����Ա��½</title>
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
			���Ծ���¼! �����������ִ����ز���
		</center>
		<br>
		<table align="center">
			<tr>
				<td>
					<a href="getStudent.faces">ѧ��</a> &gt;&gt;
				</td>
				<td>
					<a href="getteacher.faces"> ����Ա </a>&gt;&gt;
				</td>
				<td>
					<a href="getcourse.faces">�γ�</a>&gt;&gt;
				</td>
				<td>
					<a href="getClass.faces">����</a>
				</td>
			</tr>
		</table>

		<p>
			&nbsp;
		</p>
		<p>
			<a href="login_confirm? action=/logout">&lt;&lt;ע�� </a>
		</p>
	</body>
</html>
