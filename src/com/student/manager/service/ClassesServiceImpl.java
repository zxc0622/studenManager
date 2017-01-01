package com.student.manager.service;

import java.util.List;

import com.student.manager.beans.Classes;
import com.student.manager.dao.ClassesDao;
import com.student.manager.dao.ClassesDaoImpl;
import com.student.manager.web.Page;

public class ClassesServiceImpl implements ClassesService {

	private ClassesDao classesDao = new ClassesDaoImpl();
	
	@Override
	public boolean addClasses(Classes classes){
		return classesDao.insertClasses(classes);
	}

	@Override
	public List<Classes> getAll() {
		return classesDao.getAllClasses();
	}

	@Override
	public void deleteClasses(Integer id) {
		classesDao.deleteClasses(id);
	}

	@Override
	public Page<Classes> getPageClasses(Integer pageNo) {
		return classesDao.getPageClasses(pageNo);
	}

}
