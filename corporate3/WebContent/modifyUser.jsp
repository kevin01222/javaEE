<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<font size="5">用户修改</front>
	</div>
	<br />
	<%
		String num = request.getParameter("id");
	%>
	<form method="post" action="ModifyUserServlet">
		<table align="center">
			<tr>
				<td>要修改的用户id:</td>
				<td><input type="hidden" name="userid" value=<%=num%> /><%=num%> </td>
			</tr>
			<tr>
				<td>新的用户名:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>新的密码:</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td>手机号</td>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td>收货地址</td>
				<td><input type="text" name="address" /></td>
			</tr>

			<td colspan="2" align="center"><input type="submit" value="修改" />&nbsp;&nbsp;
				<input type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>