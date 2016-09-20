<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加新闻</title>
</head>
<style>
#t{
 width:100%;
}
</style>
<body>
	<form action="DealNewsServlet" method="post">
	<input type="hidden" name="action" value="newsadd">
	
			<fieldset>
    <legend ><font size="5">添加新闻</font></legend>
		<textarea rows="10" id="t" name="mytextarea" ></textarea>
		</fieldset>
		<br><br>
		<input type="submit" value="添加"/>&nbsp;&nbsp;<input type="reset" value="重置"/>
		<a href="ListNewsServlet"><font color="blue">返回</font></a>
	</form>
</body>
</html>