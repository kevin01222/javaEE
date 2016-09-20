<%@ page language="java" import="java.sql.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/admin.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <table cellspacing=0 cellpadding=0 width="100%" 
               background="./img/header_bg2.jpg" border=0>
            <tr height=56>
                <td width=260><img height=56 src="./img/header_left2.jpg" 
                                   width=260></td>
                <td style="font-weight: bold; color: #fff; padding-top: 20px" align=middle>
				<%String username=(String)session.getAttribute("username");%>
	<%String admname=(String)session.getAttribute("admname");
	System.out.println("front_top1获取的admname="+admname);
	System.out.println("front_top1获取的username="+username);
	%>	
<%if(username==null||username.equals("")){%>
<form action="LoginUserServlet" method="post" >
<input type="hidden" name="action" value="head">
<div align="right">你还没有登录，请先登录!&nbsp;&nbsp;用户名：<input type="text" name="username" />密码：<input type="password" name="password"/><input type="submit" value="登录" />
<a href="loginAdmin.jsp" target="_black"><font color="yellow">管理员登录</font></a></div>
</form>
<%}
else{%>
<div align="right">用户名：<%=username %>&nbsp;&nbsp;欢迎访问！&nbsp;&nbsp;<a href="front_logoutUser.jsp"><font color="yellow">注销</font></a></div>
<%}%>	
			<!--	
				当前用户：admin &nbsp;&nbsp; 
				<a style="color: #fff" href="" target=main>修改口令</a>
				&nbsp;&nbsp; <a style="color: #fff"  onclick="if (confirm('确定要退出吗？')) return true; else return false;" href="" target=_top>退出系统</a> 
              -->
				</td>
                <td align=right width=260><img height=56 
                                            src="./img/header_left2.jpg" width=268></td></tr></table>
        <table cellspacing=0 cellpadding=0 width="100%" border=0>
            <tr bgcolor=#1c5db6 height=4>
                <td></td>
            </tr>
        </table>
    </body>
</html>
	