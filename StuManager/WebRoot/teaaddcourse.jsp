<%@page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<html>
	<head>
		<title>�Ͼ���ѧ����ϵͳ</title>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="css/teacherinner.css" rel="stylesheet" type="text/css">  

	</head>
	<body>
	<div id="Header">
		




 
<div id="Logo"><a href="teacher.faces"><img src="image/Logo_Student.jpg" border="0"></a></div>
<div id="TopLink"><img src="image/Icon_Help.gif"><a href="student/index.do#">����</a>&nbsp;&nbsp;&nbsp;&nbsp;<img src="image/Icon_Exit.gif"><a href="login.faces">�˳�</a></div>
<div id="UserInfo">��ӭ�� &nbsp;&nbsp;&nbsp;&nbsp;��ǰ��ݣ�����Ա</div>
		
<script type="text/javascript" language="javascript" src="js/prototype.js"></script>
<div id="Nav">
  <ul>
    <li id="homepage"><a href="teacher.faces">��  ҳ</a></li>
    <li id="studentinfo"><a href="updatetea.faces">������Ϣ</a></li>
     <li id="teachinginfo"><a href="coursemanage.faces">�γ̹���</a></li>
    <li id="teachinginfo"><a href="studentmanage.faces">ѧ������</a></li>
    <li id="teachinginfo"><a href="coursescheduling.faces">�ſ�ϵͳ</a></li>
    <li id="studentinfo"><a href="courseselectingresult.faces">ѡ�ν��</a></li>
    <li id="studentinfo"><a href="teascoremanage.faces">�ɼ�����</a></li>
   
  </ul>
</div>
	</div>
	
	
<div class="Line"></div>
  </body>
	
	
	
	<f:view>
		<p>
		</p>
		<p align="center">
			�����γ�
		</p>
		<h:form>
			<div align="center"></div>
			<table width="37%" border="1" align="center">
				<tr>
					<td>
						�γ̺�
					</td>
					<td>
						<h:inputText id="id" value="#{courseBean.id}" />
					</td>
				</tr>
				<tr>
					<td width="37%">
						�γ���
					</td>
					<td width="63%">
						<h:inputText id="name" value="#{courseBean.name}" />
					</td>
				</tr>
				<tr>
					<td>
						ѧ��
					</td>
					<td>
						<h:selectOneListbox id="mark" size="3" value="#{courseBean.mark}">
							<f:selectItem itemLabel="1" itemValue="1"/>
							<f:selectItem itemLabel="2" itemValue="2"/>
							<f:selectItem itemLabel="3" itemValue="3"/>
							<f:selectItem itemLabel="4" itemValue="4"/>
						</h:selectOneListbox>
					</td>
				</tr>
				<tr>
					<td>
						ϵ��
					</td>
					<td>
						<h:selectOneListbox id="department" size="3" value="#{courseBean.dep}">
							<f:selectItem itemLabel="�����" itemValue="�����"/>
							<f:selectItem itemLabel="��еϵ" itemValue="��еϵ"/>
							<f:selectItem itemLabel="����ϵ" itemValue="����ϵ"/>
							<f:selectItem itemLabel="��ѧϵ" itemValue="��ѧϵ"/>
						</h:selectOneListbox>
					</td>
				</tr>
				<tr>
					<td>
						Ԥ�޿�
					</td>
					<td>

						<h:selectOneListbox id="department" size="3" value="#{courseBean.prepare}">
							<f:selectItem itemLabel="����" itemValue="����"/>
							<f:selectItem itemLabel="��ѧ" itemValue="��ѧ"/>
							<f:selectItem itemLabel="Ӣ��" itemValue="Ӣ��"/>
							<f:selectItem itemLabel="����" itemValue="����"/>
						</h:selectOneListbox>

					</td>
				</tr>
			</table>
			<p align="center">
				<h:commandButton action="#{courseBean.addCourse}" id="Submit2" value="ȷ��"/>
			</p>
			<p>
				&nbsp;
			</p>
		</h:form>
		<p>
			<a href="getcourse.faces">&lt;&lt;Back </a>
		</p>
		</f:view>
	</body>
</html>
