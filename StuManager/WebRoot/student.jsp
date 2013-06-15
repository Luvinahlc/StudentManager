<%@page language="java" contentType="text/html; charset=utf-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<head>
</head>
<body>  
  <%
String stuid = (String)session.getAttribute("id");

if(stuid==null){response.sendRedirect("login.faces");}                                 
%>
  <br>
  <br>
  <center>您已经成功通过验证! 您可以使用如下服务</center> 
  <br>
  <br>
  <br>
  	<f:view>
  	<h:form>
<table width="58%"  border="0" align="center">
  <tr> 
    <td>
     <!--<h:commandLink value="选修课程 ＞＞" action="#{studentBean.getCourses}"/>-->
      <a href="DisplayCourse.faces">选修课程　＞＞</a>
    
    </td>
    <td><h:commandLink value="察看成绩　＞＞" action="#{studentBean.preCheckMark}"/>
    <a href="checkmark.faces"></a></td>
    
    
    <td>
     <h:commandLink value="更改信息　＞＞" action="#{studentBean.preModifyStudent}"/>
    <a href="updateinformation.faces"></a></td>
  </tr>
</table>
	</h:form>
</f:view>
<p>&nbsp;&nbsp;&nbsp;&nbsp;<a href="login.faces">退出</a></p>
</body>
</html>