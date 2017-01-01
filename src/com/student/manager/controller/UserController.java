package com.student.manager.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.manager.beans.User;
import com.student.manager.service.UserService;
import com.student.manager.service.UserserviceImpl;

/**
 * 用于操作跟User相关的信息
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private UserService userService = new UserserviceImpl();
	
	protected void validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		if(request.getSession().getAttribute("user") !=null)
			request.getRequestDispatcher(path).forward(request, response);
		
		String name = request.getParameter("name");
		String password  = request.getParameter("password");
		User user = new User(name, password);
		User newUser = userService.validateUser(user);
		if(newUser == null){
			request.setAttribute("message", "不存在此用户,请检查账号和密码");
			path = "/login.jsp";
		}else{
			request.getSession().setAttribute("user", newUser);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
