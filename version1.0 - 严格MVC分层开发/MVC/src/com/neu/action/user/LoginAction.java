package com.neu.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.dao.pojo.User;
import com.neu.service.IUserService;
import com.neu.service.UserServiceImpl;

public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 

HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, 

HttpServletResponse response) throws ServletException, IOException {
		//1-取值(从V层的html或jsp页面中获取用户输入的数据信息)
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		//2-处理(调用M层的Service,实现服务)
		IUserService userService = new UserServiceImpl();
		boolean flag = userService.login(user);
		HttpSession session = request.getSession(true);
		session.setAttribute("username", username);
		//3-反馈(打印页面或跳转页面--转发,重定向)
		if(flag){
			response.sendRedirect(request.getContextPath()+"/UserFindAllAction");
		}else{
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
	}

}
