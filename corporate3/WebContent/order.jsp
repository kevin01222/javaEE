<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
<%String proname=new String(request.getParameter("proname").getBytes("ISO-8859-1"),"UTF-8");
String price=request.getParameter("price");
String proid=request.getParameter("proid");
String image=request.getParameter("image");
%>

	<div align="center"><font size="5">在线订购</font></div><br/>
	<img src=<%=image%> align="right" width="200" height="200"/>
	<form name="form_buyol" method="post" action="Order2Servlet">
	<input type="hidden" readonly="readonly" value=<%=proid%> name="proid">
	<table align="center">
	<tr>
	<td>
	名称：<input type="hidden" readonly="readonly" value=<%=proname%> name="proname"><%=proname%>
	</td>
	</tr>
	<tr>
	<td>
	单价：<input type="hidden" readonly="readonly" value=<%=price%> name="price"><%=price%>
	</td>
	</tr>
	<tr>
	<td>
	<br/>
	数量：<select name="number" >
	 		<option>1</option><option>2</option><option>3</option><option>4</option><option>5</option>
	 		<option>6</option><option>7</option><option>8</option><option>9</option><option>10</option>
	 	</select><br/>
	</td>
	</tr>
	<tr>
	<td>
	<br/>
	<input type="submit"  onclick="return confirm('提交订单？')" value="下单"/>
	</td>
	</tr>
	</table>
	 </form>
</body>
</html>