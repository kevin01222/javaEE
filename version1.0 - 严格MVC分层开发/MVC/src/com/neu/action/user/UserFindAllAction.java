package com.neu.action.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.pojo.User;
import com.neu.service.IUserService;
import com.neu.service.UserServiceImpl;


public class UserFindAllAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 

HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, 

HttpServletResponse response) throws ServletException, IOException {
		//1-取值(从V层的html或jsp页面中获取用户输入的数据信息)
		
		//2-处理(调用M层的Service,实现服务)
		IUserService userService = new UserServiceImpl();
		List<User> users = userService.findAll();
		//3-反馈(打印页面或跳转页面--转发,重定向)
		if(users != null && users.size() > 0){
			request.setAttribute("users", users);
			request.getRequestDispatcher("/user_main.jsp").forward(request, response);
		}else{
			String msg = "no data";
			response.sendRedirect(request.getContextPath()+"/error.jsp?msg="+msg);
		}
	}
}
