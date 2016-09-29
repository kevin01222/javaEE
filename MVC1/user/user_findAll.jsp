<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户管理</title>
</head>
<body>
	<h3>程序主页面</h3>
	<table border="1">
		<tr>
		<td>id</td>
		<td>username</td>
		<td>password</td>
		<td>regtime</td>
		<td>option</td>
		</tr>

		<c:forEach items="${users}" var="user">		
		<tr>
		<td>${user.id }</td>
		<td>${user.username }</td>
		<td>${user.password }</td>
		<td>${user.regtime }</td>
		<td>
		<a href="${pageContext.request.contextPath }/DeleteUserAction?id=${user.id }" onclick="return confirm('确定删除？')">delete</a>
		<a href="${pageContext.request.contextPath }/user/user_update.jsp?id=${user.id }&username=${user.username }&password=${user.password }&regtime=${user.regtime }">update</a>
		</td>
		</tr>
		</c:forEach>

	</table>
	
		<a href="${pageContext.request.contextPath }/user/user_save.jsp">create new user</a>
		<a href="${pageContext.request.contextPath }/user/user_findById.jsp">find by id</a>
		<a href="${pageContext.request.contextPath }/user/user_findByName.jsp">find by name</a>
		<a href="${pageContext.request.contextPath }/UserFindAllAction">find all</a>
		<a href="${pageContext.request.contextPath }/index.jsp">go back home</a>
	
</body>
</html>