package com.student.manager.test;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class BaseTest {

	@Test
	public void testDatasource() throws Exception{
		DataSource dataSource = new ComboPooledDataSource("zxxPool");
		System.out.println(dataSource.getConnection());
	}
}
