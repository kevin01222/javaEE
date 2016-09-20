<%@ page language="java" import="java.sql.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改管理员</title>
</head>
<body>
<%
String id2=request.getParameter("id");
String name2=new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
String password2= new String (request.getParameter("password").getBytes("ISO-8859-1"),"utf-8");
%>
	<div align="center"><font size="5">修改管理员</font></div><br/>
	<form name="form1" method="post" action="DealAdminServlet" >
	<input type="hidden" name="action" value="modify">
	 	<table align="center" border="1" >
		<tr>
	 	<td>要修改的用户id:</td>
	 	<td><input type="hidden" name="admid" value=<%=id2%> > <%=id2%> </td>
	 	</tr>
	 	<tr>
	 	<td>新的用户名:</td>
	 	<td><input type="text" name="admname" value=<%=name2 %> > </td>
	 	</tr>
		<tr>
	 	<td>新的密码:</td>
	 	<td><input type="text" name="password"value=<%=password2%>></td>
	 	</tr>
	 	<tr>
	 	<td colspan="2" align="center">
	 	<input type="submit"  value="确认"/>&nbsp;&nbsp;
	 	<input type="reset" value="重置"/>
	 	</td>
	 	</tr>
	 	</table>
	</form>
</body>
</html>