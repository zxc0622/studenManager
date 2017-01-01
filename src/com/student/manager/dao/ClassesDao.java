package com.student.manager.dao;

import java.util.List;

import com.student.manager.beans.Classes;
import com.student.manager.web.Page;

public interface ClassesDao {

	public boolean insertClasses(Classes classes);
	
	public List<Classes> getAllClasses();
	
	public boolean deleteClasses(Integer id);
	
	public Page<Classes> getPageClasses(Integer pageNo);
	
	public long getClassesCount();
}
