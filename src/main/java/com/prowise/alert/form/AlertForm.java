package com.prowise.alert.form;

public class AlertForm {
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTrigger() {
		return trigger;
	}
	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	private String message;
	private String trigger;
	private String rule;

}
