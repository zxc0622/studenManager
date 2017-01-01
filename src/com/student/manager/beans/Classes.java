package com.student.manager.beans;

public class Classes {
	private Integer id;
	private String className;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Classes(String className) {
		super();
		this.className = className;
	}
	
	public Classes() {
	}
	@Override
	public String toString() {
		return "Classes [id=" + id + ", className=" + className + "]";
	}
}
