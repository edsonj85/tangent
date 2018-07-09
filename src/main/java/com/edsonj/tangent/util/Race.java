package com.edsonj.tangent.util;

public enum Race {
	B("Black African"),
	C("Coloured"),
	I("Indian or Asian"),
	W("White"),
	N("Non Dominant");
	
	private String description;

	public String getDescription() {
		return description;
	}
	
	Race(String raceName){
		this.description = raceName;
	}
}
