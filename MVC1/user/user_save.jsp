<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加用户</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/SaveUserAction?option=create" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input name="username" type="text" value="root"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input id="pwd1" name="password" type="password" value="root"></td>
			</tr>
			<tr>
				<td>再输入一次</td>
				<td><input id="pwd2" type="password" value="root"></td>
			</tr>
			<tr>
				<td>注册时间</td>
				<td><input type="date" name="regtime" value="2016-08-08"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="添加"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>