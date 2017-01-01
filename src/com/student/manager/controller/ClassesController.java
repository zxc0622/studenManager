package com.student.manager.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.manager.beans.Classes;
import com.student.manager.service.ClassesService;
import com.student.manager.service.ClassesServiceImpl;
import com.student.manager.web.Page;
/**
 * 用于处理Class相关的操作
 */
public class ClassesController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String methodName = req.getParameter("method");
		if(methodName == null){
			Integer pageNo = 1;
			String pageNoStr = req.getParameter("pageNo");
			if(pageNoStr != null){
				pageNo = Integer.parseInt(pageNoStr);
			}
			Page<Classes> page = classesService.getPageClasses(pageNo);
			req.setAttribute("page", page);
			req.getRequestDispatcher("/class.jsp").forward(req, resp);
			return;
		}
		
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private ClassesService classesService = new ClassesServiceImpl();
	
	protected void addClasses(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String className = req.getParameter("className");
		Classes classes = new Classes(className);
		classesService.addClasses(classes);
		resp.sendRedirect(req.getContextPath() + "/classes");
	}
	
	protected void deleteClasses(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		classesService.deleteClasses(id);
		resp.sendRedirect(req.getContextPath() + "/classes");
	}
	
	public ClassesController() {
		System.out.println("class controller");
	}
	
}
