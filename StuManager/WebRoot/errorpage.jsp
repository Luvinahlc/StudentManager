<%@page language="java" contentType="text/html; charset=GBK"%>
<%@page import="java.sql.*,com.stuman.*,java.io.*" errorPage="errorpage.faces" %>
<HTML>
<HEAD><TITLE>Output</TITLE></HEAD>

<BODY>
<P align="center"><FONT COLOR="#660000" SIZE=2><B> 
  <%
	//if (exception != null) {
		//out.print(exception.toString());
	//} else 
		if (request.getAttribute("problem") != null) {
		String str =(String) request.getAttribute("problem");
		// byte[] tmpbyte=str.getBytes("ISO8859_1");
// str=new String(tmpbyte);
%>
  <%= str %> 
  <% } else { %>
  (No error code) 
  <% } %>
  </B></P>

<P><B>
<p> <a href="javascript:history.back();"> &lt;&lt;Back</a> </p>
</B></P>
</BODY>
</HTML>
