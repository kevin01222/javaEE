<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript">
	function check(){
		if(document.form_.proname.value==""){
			alert("请输入产品名称！");
		}
		else if(document.form_.price.value==""){
			alert("请输入价格");
		}
		else if(document.form_.introduce.value==""){
			alert("请输入产品介绍！");
		}else{
			document.form_.submit();
		}
	}
</script>
</head>
<body>
	<form name="form_" method="post" action="${pageContext.request.contextPath }/UploadServlet" enctype="multipart/form-data">
	<input type="hidden" name="action" value="productadd"/>
	 	<table align="center"  >
	 	<tr>
	 	<td>产品名称:</td>
	 	<td><input type="text" name="proname" /></td>
	 	</tr>
		<tr>
	 	<td>产品价格</td>
	 	<td><input type="text" name="price"/></td>
	 	</tr>
	 	<tr>
	 	<tr>
	 	<td>图片:</td>
	 	<td><input type="file" name="image" /></td>
	 	</tr>
	 	<tr>
	 	<td>介绍</td>
	 	<td><input type="text" name="introduce"/></td>
	 	</tr>
	 	<tr>
	 	<td colspan="4" align="center">
	 	<input type="submit" onclick="check()" value="提交"/>&nbsp;&nbsp;
	 	<input type="reset" value="重置"/>	<a href="ListProductServlet"><font color="blue">返回</font></a>
	 	</td>
	 	</tr>
	 	</table>
	 </form>
</body>
</html>