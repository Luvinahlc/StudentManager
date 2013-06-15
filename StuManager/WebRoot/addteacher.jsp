<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>



<html>
	<head>
		<title>增加教师</title>
	</head>
	<body>
	<f:view>
		<p>
			<%
			//String admin_id = (String) session.getAttribute("id");
		//	if (admin_id == null) {
		//		response.sendRedirect("login.faces");
		//	}
		%>
		</p>
		<p align="center">
			新增教务员
		</p>
		<%--<h:form method="post" action="/MyStuMan/addTeacher.do">
			--%>
			<h:form>
			<div align="center">
				<table width="51%" border="1">
					<tr>
						<td width="33%">
							教务员编号
						</td>
						<td width="67%">
							<h:inputText id="id" value="#{teacherBean.id}" />
						</td>
					</tr>
					<tr>
						<td>
							教务员姓名
						</td>
						<td>
							<h:inputText id="name" value="#{teacherBean.name}" />
						</td>
					</tr>
					<tr>
						<td>
							密码
						</td>
						<td>
							<h:inputSecret id="password" value="#{teacherBean.password}" />
						</td>
					</tr>
					<tr>
						<td>
							院系
						</td>
						<td>
							<h:selectOneListbox id="title" size="１" value="#{teacherBean.title}">
								<f:selectItem itemLabel="计算机系" itemValue="计算机系"/>
								<f:selectItem itemLabel="数学系" itemValue="数学系"/>
							</h:selectOneListbox>
						</td>
					</tr>
				</table>
				<p>
					<h:commandButton action="#{teacherBean.addTeacher}" id="Submit" value="提交"/>
				</p>
			</div>
		</h:form>
		<p>
			<a href="getteacher.faces">&lt;&lt;后退</a>
		</p>

		</f:view>
	</body>
</html>
