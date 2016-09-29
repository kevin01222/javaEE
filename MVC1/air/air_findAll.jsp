<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>航班信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/air_find_findAll" method="post">
	<table bgcolor="#CCCCCC" cellspacing=1 cellpadding=5 width=100%>
		<tr bgcolor=#DDDDDD>
			<th>航班号</th>
			<th>航空代码</th>
			<th>机型</th>
			<th>起始地</th>
			<th>抵达地</th>
			<th>起飞时间</th>
			<th>抵达时间</th>
			<th>全票价格</th>
			<th>操作</th>
		</tr>
		<!-- 
	必须通过循环，对传递来的集合数据进行遍历，然后显示--不允许使用java代码
	JSTL解决循环问题:1-添加jar包，2-添加tld文件配置
	EL表达式解决取值问题
	-->
	<c:forEach items="${airFromAction }" var="air">
			<tr bgcolor=#FFFFFF>
				<td>${air.airId }</td>
				<td>${air.aircNum }</td>
				<td>${air.ariType }</td>
				<td>${air.startSpace }</td>
				<td>${air.reachSpace }</td>
				<td>${air.startTime }</td>
				<td>${air.reachTime }</td>
				<td>${air.price }</td>
				
				<td>
				<a href="${pageContext.request.contextPath }/air_delete.action?airId=${air.airId}">删除</a>
				<a href="${pageContext.request.contextPath }/air/air_update.jsp?airId=${air.airId }&aircNum=${air.aircNum }&ariType=${air.ariType }&startSpace=${air.startSpace}&reachSpace=${air.reachSpace}&startTime=${air.startTime}&reachTime=${air.reachTime}&price=${air.price}">更新</a>
				</td>
			</tr>
		</c:forEach>
	</table>
<table bgcolor="#CCCCCC" cellspacing=1 cellpadding=5 width=100%>
	<tr bgcolor=#DDDDDD>
		<td align="center">
			<a href="${pageContext.request.contextPath }/index.jsp">返回后台首页</a>
			<a href="${pageContext.request.contextPath }/air/air_save.jsp">添加航班信息</a>
			<a href="${pageContext.request.contextPath }/air/air_findById.jsp">精确查询</a>
			<a href="${pageContext.request.contextPath }/air/air_findByNum.jsp">模糊查询</a>
			<a href="${pageContext.request.contextPath}/air_find_findAll.action">查询全部</a>
		</td>
	</tr>
</table>
</form>

</body>
</html>