<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加航班页面</title>
</head>

<script type="text/javascript">
function validateNull(object){
	//js中的DOM编程
	var value = object.value;
	if(value == null || value == ""){
		document.getElementById("message").innerHTML = "内容不能为空";
		object.focus();
	}
}
</script>
<body>
<h5 id="message"></h5>
<form action="${pageContext.request.contextPath }/air_save.action" method="post">
	<table>
		<tr>
		<td>航班号</td>
		<td><input type="text" name="airId" id="aircId"  onblur="validateNull(this)"></td>
		</tr>
		<tr>
		<td>航空代码</td>
		<td><input type="text" name="aircNum" id="aircNum" onblur="validateNull(this)"></td>
		</tr>
		<tr>
		<td>机型</td>
		<td><input type="text" name="ariType" id="ariType" onblur="validateNull(this)"></td>
		</tr>
		<tr>
		<td>起始地</td>
		<td><input type="text" name="startSpace" id="spartSpace" onblur="validateNull(this)"></td>
		</tr>
		<tr>
		<td>抵达地</td>
		<td><input type="text" name="reachSpace" id="reachSpace" onblur="validateNull(this)"></td>
		</tr>
				<tr>
		<td>起始时间</td>
		<td><input type="time" name="startTime" id="StratTime" onblur="validateNull(this)"></td>
		</tr>
		<tr>
		<td>抵达时间</td>
		<td><input type="time" name="reachTime" id="aircphone" onblur="validateNull(this)"></td>
		</tr>
				<tr>
		<td>全票价格</td>
		<td><input type="number" name="price" id="price" onblur="validateNull(this)"></td>
		</tr>

		<tr>
		<td><input type="submit" value="添加"></td>
		<td><input type="reset" value="重置"></td>
		</tr>
	</table>
</form>

</body>
</html>