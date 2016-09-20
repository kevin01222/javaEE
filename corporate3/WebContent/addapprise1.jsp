<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function check(){
	if(document.form2.info.value==""){
	alert("留言不许为空！");
	}else {document.form2.submit();}
}
</script>
<style>
#t{
 width:100%;
}
</style>
</head>
<body>
	<form action="DealAppriseServlet" method="post" name="form2">
	<input type="hidden" name="action" value="add">
	<fieldset>
    <legend ><font size="5">留言</font></legend>
		<textarea rows=10; id="t" name="info" ></textarea>
	</fieldset>
		<input type="button" value="添加"  onclick="check()" />&nbsp;&nbsp;<input type="reset"  onclick="return confirm('您确定重置吗？')"/>
		<a href="FrontAppriseServlet"  onclick="return confirm('您确定放弃留言吗？')"><font color="blue">返回</font></a>
	</form>
</body>
</html>