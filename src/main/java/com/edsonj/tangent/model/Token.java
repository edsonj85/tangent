package com.edsonj.tangent.model;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Token implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7886805106870298829L;
	
	private String token;
	public Token() {
		super();
	}
	public Token(String token) {
		this.token = token;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
