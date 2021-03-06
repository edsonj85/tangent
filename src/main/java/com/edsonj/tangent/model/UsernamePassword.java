package com.edsonj.tangent.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class UsernamePassword implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6969467432709785748L;
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
