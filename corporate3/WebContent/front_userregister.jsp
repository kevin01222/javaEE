<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function check() {
		if (document.form_user.username.value == "") {
			alert("请输入账号！");
		} else if (document.form_user.password.value == "") {
			alert("请输入密码！");
		} else if (document.form_user.password2.value == "") {
			alert("请输入确认密码！");
		} else if (document.form_user.phone.value == "") {
			alert("请输入电话！");
		} else if (document.form_user.address.value == "") {
			alert("请输入地址！");
		} else if (document.form_user.password.value != document.form_user.password2.value) {
			alert("两次密码不一致！");
		} else {
			var phonenum = document.form_user.phone.value;
			if (!(/^1[3|5|8][0-9]\d{4,8}$/.test(phonenum))) {
				alert("请输入正确的手机号码！");
			} else {
				document.form_user.submit();
			}
		}
	}
</script>

<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<font size=5>用户注册</font>
	</div>
	<br />
	<form name="form_user" method="post" action="AddUserServlet">
		<table align="center">
			<tr>
				<td>账号:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
			<tr>
				<td>确认密码:</td>
				<td><input type="password" name="password2" /></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="phone"
					onkeyup="this.value=this.value.replace(/[, ]/g,'')" /></td>
			</tr>
			<tr>
				<td>收货地址</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button"
					onClick="check()" value="注册" />&nbsp;&nbsp; <input type="reset"
					value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>