<%@page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
	<head>
	    <meta http-equiv="cache-control" content="no-cache">
		<title>选报课程</title>
	</head>
	<%
	  response.setHeader("progma","no-cache");

			%>
	<body>
		<p align="center">
			您可以选报的课程为
		</p>
		<!--  <table border="1" align="center">
			<tr>
				<td width="54">
					课程号
				</td>
				<td width="54">
					课程名
				</td>
				<td width="57">
					预修课
				</td>
				<td width="58">
					系别
				</td>
				<td width="59">
					班级号
				</td>
				<td width="69">
					教室号
				</td>
				<td width="88">
					上课时间
				</td>
				<td width="88">
					教师
				</td>
				<td width="83">
					选择
				</td>
			</tr>
			<p>
			
		</table>-->
		<f:view>
		<h:form>
		<h:dataTable value="#{studentBean.courses}" var="course" border="1" width="75%">
        	<h:column>
        	    <f:facet name="header">
				    <h:outputText value="课号"/>
			    </f:facet>
            	<h:outputText value="#{course.id}"/>
        	</h:column>
        	<h:column>
        	    <f:facet name="header">
				    <h:outputText value="课名"/>
				</f:facet>
            	<h:outputText value="#{course.name}"/>
        	</h:column>
        	<h:column>
        	    <f:facet name="header">
				    <h:outputText value="班级号"/>
				</f:facet>
            	<h:outputText value="#{course.classes.id}"/>
        	</h:column>
        	<h:column>
        	    <f:facet name="header">
				    <h:outputText value="教室号"/>
				</f:facet>
            	<h:outputText value="#{course.classes.roomId}"/>
        	</h:column>
        	<h:column>
        	    <f:facet name="header">
				    <h:outputText value="上课时间"/>
				</f:facet>
            	<h:outputText value="#{course.classes.courTime}"/>
        	</h:column>
			<h:column>
			       <f:facet name="header">
				      <h:outputText value="选择"/>
				   </f:facet>
				   <h:commandLink value="注册" action="#{enrolBean.saveEnrol}"/>
		     </h:column>
    	</h:dataTable>
		</h:form>
		</f:view>
		<p>
			&nbsp;
		</p>
		<p>
			<a href="student.faces">&lt;&lt;Back </a>
		</p>
	</body>
</html>
