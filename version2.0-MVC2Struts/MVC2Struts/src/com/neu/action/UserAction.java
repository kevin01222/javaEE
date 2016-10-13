package com.neu.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.neu.dao.pojo.User;
import com.neu.service.IUserService;
import com.neu.service.UserServiceImpl;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction implements ModelDriven<User>,RequestAware {
	private IUserService userService;

	public UserAction() {
		userService = new UserServiceImpl();
	}
	/*应用RequestAware接口,实现对request对象的操作
	*将request对象的Attribute操作模拟成了一个Map--requestMap
	*request.setAttribute(key,value);  等价于  requestMap.put(key,value);
	*达到了与Servlet原型代码解耦合的目标
	*/
	private Map<String,Object> requestMap;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		requestMap = arg0;
	}
	
	// 1-实现自动取值(不用属性,而用对象)
	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	// 2-处理(CRUD+Login)
	public String save() {
		return userService.save(user);
	}

	public String delete() {
		return userService.delete(user);
	}

	public String update() {
		return userService.update(user);
	}

	public String registry() {
		return save();
	}

	public String login() {
		return userService.login(user) ? "success" : "error";
	}

	public String findAll() {
		String msg = "error";
		List<User> users = userService.findAll();
		if (users != null && users.size() > 0) {
			// 获取HttpServletRequest对象
			requestMap.put("users", users);
			msg = "success";
		}
		return msg;
	}

	public String findById() {
		User u = userService.findById(user.getId());
		String msg = "error";
		if (u != null) {
			List<User> users = new ArrayList<User>();
			users.add(u);
			// 获取HttpServletRequest对象
			requestMap.put("users", users);
			msg = "success";
		}
		return msg;
	}

	public String findByName() {
		List<User> users = userService.findByName(user.getUsername());
		String msg = "error";
		if (users != null && users.size() > 0) {
			// 获取HttpServletRequest对象
			requestMap.put("users", users);
			msg = "success";
		}
		return msg;
	}

	

}
