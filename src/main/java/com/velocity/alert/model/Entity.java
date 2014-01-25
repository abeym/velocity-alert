package com.velocity.alert.model;

import java.util.List;

public class Entity {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List getColumns() {
		return columns;
	}
	public void setColumns(List columns) {
		this.columns = columns;
	}
	private String name;
	private List columns;
}
