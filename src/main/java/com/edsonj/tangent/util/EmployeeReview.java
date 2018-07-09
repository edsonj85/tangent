package com.edsonj.tangent.util;

public enum EmployeeReview {
	P("Performance Increase"),
	S("Starting Salary"),
	A("Annual Increase"),
	E("Expectation Review");
	
	private String description;

	public String getDescription() {
		return description;
	}
	
	EmployeeReview(String description){
		this.description = description;
	}
}
