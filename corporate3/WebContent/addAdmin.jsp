<%@ page language="java" import="java.sql.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language= "javascript">
function check(){
	if(document.form1.admname.value==""){
		alert("请输入管理员用户名！");
	}
	else	if (document.form1.password.value==""){
			alert("请输入密码！");	
		}
	else{
		document.form1.submit();
	}
}
</script>
<title>注册用户</title>
</head>
<body>
	<div align="center"><font size="5">添加管理员</font></div><br/>
	<form name="form1" method="post" action="DealAdminServlet" >
	<input type="hidden" value="add" name="action">
	 	<table align="center" border="1" >
	 	<tr>
	 	<td>账号:</td>
	 	<td><input type="text" name="admname"/></td>
	 	</tr>
		<tr>
	 	<td>密码:</td>
	 	<td><input type="password" name="password"/></td>
	 	</tr>
	 	<tr>
	 	<td colspan="2" align="center">
	 	<input type="button" onClick="check()" value="确认"/>&nbsp;&nbsp;
	 	<input type="reset" value="重置"/>
	 	</td>
	 	</tr>
	 	</table>
	</form>
</body>
</html>