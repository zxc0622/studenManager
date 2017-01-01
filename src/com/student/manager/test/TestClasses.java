package com.student.manager.test;

import java.util.List;

import org.junit.Test;

import com.student.manager.beans.Classes;
import com.student.manager.dao.ClassesDao;
import com.student.manager.dao.ClassesDaoImpl;
import com.student.manager.service.ClassesService;
import com.student.manager.service.ClassesServiceImpl;
import com.student.manager.web.Page;

public class TestClasses {

	private ClassesService service;
	private ClassesDao classesDao;
	
	{
		service = new ClassesServiceImpl();
		classesDao = new ClassesDaoImpl();
	}
	
	@Test
	public void testGetPage(){
		Page<Classes> page = classesDao.getPageClasses(4);
		System.out.println(page.getList());
		System.out.println(page.getNextPage());
		System.out.println(page.getPrePage());
	}
	
	@Test
	public void testGetCount(){
		long count = classesDao.getClassesCount();
		System.out.println(count);
	}
	
	@Test
	public void testDeleteClasses(){
		service.deleteClasses(6);
	}
	
	@Test
	public void insertClasses(){
		Classes classes = new Classes("ldh");
		boolean result = service.addClasses(classes);
		System.out.println(result);
	}
	
	@Test
	public void testClassesGetAll(){
		List<Classes> classes = service.getAll();
		System.out.println(classes);
	}
}
