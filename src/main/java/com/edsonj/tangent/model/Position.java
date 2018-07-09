package com.edsonj.tangent.model;

import java.io.Serializable;

import com.edsonj.tangent.util.EmployeeReview;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Position implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5073132209347315836L;
	private String id;
    private String sort;
    private EmployeeReview level;
    private String name;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public EmployeeReview getLevel() {
		return level;
	}
	public void setLevel(EmployeeReview level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
}
