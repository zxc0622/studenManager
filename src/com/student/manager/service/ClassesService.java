package com.student.manager.service;

import java.util.List;

import com.student.manager.beans.Classes;
import com.student.manager.web.Page;

public interface ClassesService {

	public boolean addClasses(Classes classes);
	
	public List<Classes> getAll();
	
	public void deleteClasses(Integer id);
	
	public Page<Classes> getPageClasses(Integer pageNo);
}
