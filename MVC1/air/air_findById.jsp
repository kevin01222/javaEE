<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>精确查询</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/air_find_findById.action" method="post">
	<table>
		<tr>
		<td>航班号</td>
		<td><input type="text" name="airId" id="airId"></td>
		</tr>
		<tr>
		<td><input type="submit" value="精确查询"></td>
		<td><input type="reset" value="重置"></td>
		</tr>
	</table>
</form>
</body>
</html>