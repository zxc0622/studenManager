package com.student.manager.utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtil {

	private static DataSource dataSource;
	private static DataSourceUtil dataSourceUtil = new DataSourceUtil();
	
	private DataSourceUtil(){
		dataSource = new ComboPooledDataSource("zxxPool");
	};
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	public static DataSourceUtil getDataSourceUtil() {
		return dataSourceUtil;
	}
}
