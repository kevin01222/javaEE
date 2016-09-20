<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台系统</title>
</head>
<body>
	<a href="DealAdminServlet?action=logout"target="_black" >返回前台</a>
	<div align="center"><font size="5" color="red">后台管理</font></div><br>
	<table bgcolor='#fac96c' align="center" cellpadding=10 cellspacing=5>
	<tr>
	<th><a href="ListAdminServlet" target="backstage_center">管理员管理</a></th>
	<th><a href="ListContactServlet" target="backstage_center">会员管理</a></th>
	<th><a href="ListNewsServlet" target="backstage_center">新闻管理</a></th>
	<th><a href="ListAppriseServlet" target="backstage_center">留言管理</a></th>
	<th><a href="ListProductServlet" target="backstage_center">产品管理</a></th>
	<th><a href="ListOrderServlet" target="backstage_center">订单管理</a></th>
	</tr>
	</table>
</body>
</html>