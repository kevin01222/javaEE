<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<font size="5">订单修改</font>
	</div>
	<br />
	<%
		String num = request.getParameter("orderid");
		String state = new String(request.getParameter("state").getBytes("ISO-8859-1"),"utf-8");
	%>
	<form method="post" action="DealOrderServlet">
			 	<input type="hidden"  value="modify" name="action" >
		<table align="center">
			<tr>
				<td>要修改的订单编号:</td>
				<td><input type="text" name="orderid" readonly="readonly" value=<%=num%> /></td>
			</tr>

			<tr>
				<td>状态</td>
				<td><select name="state" > 
				<option selected="selected" value=<%=state%>  > <%=state%></option>
				<option value="待支付">未支付</option>
				<option value="待配送">待配送</option>
				<option value="已配送">已配送</option>
				<option value="交易完成">交易完成</option>
				</select>
				</td>
			</tr>
			<tr>
			<td colspan="2" align="center"><input type="submit" value="修改" />&nbsp;&nbsp;<input type="reset" value="重置" /> </td>
			</tr>
		</table>
	</form>
</body>
</html>