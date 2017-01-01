package com.student.manager.beans;

public class User {

	private Integer id;
	private String name;
	private String password;
	
	// 1 表示老师身份 2表示学生身份
	private Integer role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public User(String name, String password, Integer role) {
		super();
		this.name = name;
		this.password = password;
		this.role = role;
	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", role=" + role + "]";
	}
	
	public User() {

	}
}
