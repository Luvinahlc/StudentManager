<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ page import="java.sql.*,com.stuman.domain.Student,com.stuman.dao.StudentDAO,com.stuman.dao.DAOFactory"%>
<jsp:directive.page import="com.stuman.dao.imp.HibernateDAOFactory"/>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>


<html>
	<head>
		<title>修改学生信息</title>
	</head>
	<body>
	<f:view>
		<p align="center">
			修改信息
		</p>
		<%--<h:form method="post" action="editStudent2.do?student_id=<%=stu_id%>">
		--%>
		<h:form>
			<table width="49%" height="50" border="1" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						密码
					</td>
					<td>
						<h:inputSecret id="password" value="#{studentBean.student.password}" />
					</td>
				</tr>
				<tr>
					<td>
						确认密码
					</td>
					<td>
						<h:inputSecret id="password1" value="#{studentBean.password}" />
					</td>
				</tr>
				<tr>
					<td>
						电话
					</td>
					<td>
						<h:inputText id="tel" value="#{studentBean.student.tel}" />
					</td>
				</tr>
				<tr>
					<td>
						邮件地址
					</td>
					<td>
						<h:inputText id="email" value="#{studentBean.student.email}" />
					</td>
				</tr>
				
				
			</table>
			<p align="center">
				<h:commandButton action="#{studentBean.editStudentByAdmin}" id="Submit" value="提交"/>
			</p>
		</h:form>
		<p>
			<a href="student.faces">&lt;&lt;Back</a>
		</p>
		</f:view>
	</body>
</html>
