package com.edsonj.tangent.ex;

import java.io.Serializable;

public class TangentException implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7428163036219512127L;
	private String code;
	private String message;
	
	public TangentException() {
		super();
	}
	
	public TangentException(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
