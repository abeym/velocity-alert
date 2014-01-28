package com.prowise.alert.model;

public class Column {
	public String getLHS() {
		return LHS;
	}
	public void setLHS(String lHS) {
		LHS = lHS;
	}
	public String getRHS() {
		return RHS;
	}
	public void setRHS(String rHS) {
		RHS = rHS;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}

	private String LHS;
	private String RHS;
	private String condition;
}
