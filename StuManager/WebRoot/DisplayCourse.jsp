<%@page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
	<head>
	    <meta http-equiv="cache-control" content="no-cache">
		<title>ѡ���γ�</title>
	</head>
	<%
	  response.setHeader("progma","no-cache");

			%>
	<body>
		<p align="center">
			������ѡ���Ŀγ�Ϊ
		</p>
		<!--  <table border="1" align="center">
			<tr>
				<td width="54">
					�γ̺�
				</td>
				<td width="54">
					�γ���
				</td>
				<td width="57">
					Ԥ�޿�
				</td>
				<td width="58">
					ϵ��
				</td>
				<td width="59">
					�༶��
				</td>
				<td width="69">
					���Һ�
				</td>
				<td width="88">
					�Ͽ�ʱ��
				</td>
				<td width="88">
					��ʦ
				</td>
				<td width="83">
					ѡ��
				</td>
			</tr>
			<p>
			
		</table>-->
		<f:view>
		<h:form>
		<h:dataTable value="#{studentBean.courses}" var="course" border="1" width="75%">
        	<h:column>
        	    <f:facet name="header">
				    <h:outputText value="�κ�"/>
			    </f:facet>
            	<h:outputText value="#{course.id}"/>
        	</h:column>
        	<h:column>
        	    <f:facet name="header">
				    <h:outputText value="����"/>
				</f:facet>
            	<h:outputText value="#{course.name}"/>
        	</h:column>
        	<h:column>
        	    <f:facet name="header">
				    <h:outputText value="�༶��"/>
				</f:facet>
            	<h:outputText value="#{course.classes.id}"/>
        	</h:column>
        	<h:column>
        	    <f:facet name="header">
				    <h:outputText value="���Һ�"/>
				</f:facet>
            	<h:outputText value="#{course.classes.roomId}"/>
        	</h:column>
        	<h:column>
        	    <f:facet name="header">
				    <h:outputText value="�Ͽ�ʱ��"/>
				</f:facet>
            	<h:outputText value="#{course.classes.courTime}"/>
        	</h:column>
			<h:column>
			       <f:facet name="header">
				      <h:outputText value="ѡ��"/>
				   </f:facet>
				   <h:commandLink value="ע��" action="#{enrolBean.saveEnrol}"/>
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
