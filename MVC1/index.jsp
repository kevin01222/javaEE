<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
</head>
<body>
	<h1>welcome ${sessionScope.username }!</h1>
	<form action="${pageContext.request.contextPath }/LoginAction" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input name="username" type="text" value="root"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input name="password" type="password" value="root"></td>
			</tr>
			<tr>
				<td><input type="submit" value="登录"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
	<a href="${pageContext.request.contextPath }/registry.jsp">新用户注册</a>
	<a href="${pageContext.request.contextPath }/air_find_findAll.action">航班管理</a>
</body>
</html>