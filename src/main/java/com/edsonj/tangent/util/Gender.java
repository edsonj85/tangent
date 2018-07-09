package com.edsonj.tangent.util;

public enum Gender {
	M("Male"),
	F("Female");
	
	private String value;

	public String getValue() {
		return value;
	}
	
	Gender(String gender) {
		this.value = gender;
	}
}
