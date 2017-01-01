package com.student.manager.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.student.manager.beans.User;
import com.student.manager.utils.DataSourceUtil;

public class UserDaoImpl implements UserDao {

	private QueryRunner queryRunner;
	
	{
		queryRunner = new QueryRunner(DataSourceUtil.getDataSource());
	}
	
	@Override
	public User getUserByUserInfo(User user) {
		String sql = "select * from users where name = ? and password = ?";
		return findUser(sql, user.getName(), user.getPassword());
	}

	private User findUser(String sql, Object... params){
		User user;
		try {
			user = queryRunner.query(sql, new BeanHandler<User>(User.class),params);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
