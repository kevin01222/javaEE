<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改新闻</title>
</head>
<style>
#t{
 width:100%;
}
</style>
<body>
<%
String id2=request.getParameter("id");
String news2=new String(request.getParameter("news").getBytes("ISO-8859-1"),"utf-8");

%>

	<form action="DealNewsServlet" method="post">
			<input type="hidden" name="action" value="newsmodify" >
		<fieldset>
    <legend ><font size="5">修改新闻</font></legend>
		<textarea rows="10" id="t" cols="180" name="news3" ><%=news2%></textarea>
		</fieldset>
		<br><br>
		<input type="hidden" name="id3" value=<%=id2%>>
		<input type="submit" value="确认"/>&nbsp;&nbsp;<input type="reset" value="重置"/>
		<a href="ListNewsServlet"><font color="blue">返回</font></a>
	</form>
</body>
</html>