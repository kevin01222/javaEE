<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改产品</title>
</head>
<body>
<%
String id2=request.getParameter("id");
String name2=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
String price2=request.getParameter("price");
String introduce2=new String(request.getParameter("introduce").getBytes("ISO-8859-1"),"UTF-8");
%>

	<form action="DealProductServlet" method="post">
		<input type="hidden" name="action" value="productmodify">
		<div align="center"><font size="5">修改产品</font></div><br>
		<table align="center">
		<tr>
		<td>
		产品编号:<input type="hidden"  name="id3" value=<%=id2%>> <%=id2%>
		</td>
		</tr>
		<tr>
		<td>
		产品名:<input type="text" name="name3" value=<%=name2%> >
		</td>
		</tr>
		<tr>
		<td>
		单价:<input type="text" name="price3" value=<%=price2%> >
		</td>
		</tr>
		<tr>
		<td>
		介绍:<input type="text" name="introduce3" value=<%=introduce2%> >
		</td>
		</tr>
		<tr>
		<td>
		<input type="submit" value="确认"/>&nbsp;&nbsp;<input type="reset" value="重置"/>
		<a href="ListProductServlet"><font color="blue">返回</font></a>
		</td>
		</tr>
		</table>
	</form>
</body>
</html>