<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>精确查询</title>
</head>
<body>
	<h3 id="msg" style="color: red;"></h3>
	<form action="${pageContext.request.contextPath }/user_find_findById.action" method="post">
		<table>
			<tr>
				<td>编号</td>
				<td><input name="id" type="text" value="3"></td>
			</tr>
			<tr>
				<td><input type="submit" value="查询"></td>
			</tr>
		</table>
	</form>
</body>
</html>