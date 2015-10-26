package com.core.util;

public class DbParameter {
	
	public DbParameter() {}
	
	public DbParameter(String name) {
		setName(name);
	}
	
	public DbParameter(String name,int type) {
		setName(name);
		setType(type);
	}
	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private int type = -1;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
