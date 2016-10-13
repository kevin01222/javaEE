<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>模糊查询</title>
</head>
<body>
	<h3 id="msg" style="color: red;"></h3>
	<form action="/MVC/UserFindByNameAction" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input name="username" type="text" value="root"></td>
			</tr>
			<tr>
				<td><input type="submit" value="查询"></td>
			</tr>
		</table>
	</form>
</body>
</html>