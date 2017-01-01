package com.student.manager.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.student.manager.beans.Classes;
import com.student.manager.exception.UpdateException;
import com.student.manager.utils.DataSourceUtil;
import com.student.manager.web.Page;

public class ClassesDaoImpl implements ClassesDao {

	private QueryRunner queryRunner;
	
	{
		queryRunner = new QueryRunner(DataSourceUtil.getDataSource());
	}
	
	@Override
	public boolean deleteClasses(Integer id){
		String sql = "delete from classes where id = ?";
		return updateClasses(sql, id);
	}
	
	
	@Override
	public boolean insertClasses(Classes classes){
		String sql = "insert into classes(class_name) values(?)";
		return updateClasses(sql, classes.getClassName());
	}
	
	private boolean updateClasses(String sql,  Object... params) {
		try {
			int result = queryRunner.update(sql, params);
			return result > 0 ? true : false;
		} catch (SQLException e) {
			throw new UpdateException("更新classes失败");
		}
	}

	@Override
	public List<Classes> getAllClasses() {
		String sql = "select id,class_name className from classes where 1 = ?";
		List<Classes> classes = getListClasses(sql, 1);
		return classes;
	}
	
	private List<Classes> getListClasses(String sql, Object... params) {
		try {
			List<Classes> classes = queryRunner.query(sql, new BeanListHandler<Classes>(Classes.class),params);
			return classes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<Classes> getPageClasses(Integer pageNo,Integer pageSize) {
		String sql = "select id,class_name className from classes limit ?,?";
		List<Classes> classes = getListClasses(sql,(pageNo - 1) * pageSize,pageSize);
		return classes;
	}
	
	@Override
	public Page<Classes> getPageClasses(Integer pageNo) {
		Page<Classes> page = new Page<Classes>();
		page.setPageNo(pageNo);
		int totalNumber = (int)getClassesCount();
		if(totalNumber < 1 ) return page;
		page.setTotalNumber(totalNumber);
		page.setList(getPageClasses(page.getPageNo(),page.getPageSize()));
		return page;
	}

	@SuppressWarnings("all")
	private <V> V getCount(String sql) {
		try {
			return (V) queryRunner.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public long getClassesCount() {
		String sql = "select count(id) from classes";
		return getCount(sql);
	}

}
