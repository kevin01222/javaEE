<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新用户</title>
</head>
<body>
	<form action="/MVC/UpdateUserAction" method="post">
		<table>
			<tr>
				<td>编号</td>
				<td>${param.id } <input name="id" type="hidden"
					value="${param.id }"></td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><input name="username" type="text"
					value="${param.username }"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input id="pwd1" name="password" type="text"
					value="${param.password }"></td>
			</tr>
			<tr>
				<td>注册时间</td>
				<td><input type="date" name="regtime" value="${param.regtime }"></td>
			</tr>

			<tr>
				<td><input type="submit" value="更新"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>