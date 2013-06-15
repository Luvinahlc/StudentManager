<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	
	<title>南京大学教务系统</title>
    <link href="css/homepage.css" rel="stylesheet" type="text/css">
    
</head>

<body>
<f:view>
	<h:form>
		<div id="Wrapper">
			<table width="740" height="100%" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td height="136">
						<div id="Logo">
							<a href="#"><img src="image/homepage/IndexLogo.jpg"
									border="0"> </a>
						</div>
					</td>
				</tr>
				<tr>
					<td height="39"></td>
				</tr>
				<tr>					
					<td height="341" id="Main">						    

					
						<div id="Login">
						<font style="font-size: 12px;font-weight:bold;color: #FF0000"></font><br>
						<form method="post" action="login.do">
							<label>
								用户
							</label>
							<h:inputText value="#{loginBean.username}" required="true" />
							<br />
							
							<label>
								密码
							</label>
							<h:inputSecret id="password" value="#{loginBean.password}" required="true" />
							<br />


							<h:commandButton action="#{loginBean.login}" value="登录" />
							<br/>		
							</form>
						</div>						
						<div id="News">							
							<ul>
								<label style="color: red;font-size: 12px;">教务员登录：</label>
								<li>
									 用户名为教务员工号。
								</li>
								<br/>
                                    <label style="color: red;font-size: 12px;">学生登陆：</label>
								<li>
									 用户名为学号。
								</li>
								<br/>
							</ul>
						</div>
					</td>					
				</tr>
				<tr>
					<td valign="top" id="Footer">
						Copyright &copy; 2007 All Rights Reserved. 版权所有：软件工程11组 <a href="#">联系我们</a>
					</td>
				</tr>
			</table>
		</div>
	</h:form>
	</f:view>
</body>
</html>
