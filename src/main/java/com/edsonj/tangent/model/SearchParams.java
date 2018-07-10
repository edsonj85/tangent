package com.edsonj.tangent.model;

import java.io.Serializable;

import com.edsonj.tangent.util.Gender;
import com.edsonj.tangent.util.Race;

public class SearchParams implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4891023066440954301L;
	private Race race;
	private Integer positionId;
	private Integer startDateRange;
	private Integer userId;
	private Gender gender;
	private String email;
	private Integer birthDateRange;
	
	public Race getRace() {
		return race;
	}
	public void setRace(Race race) {
		this.race = race;
	}
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public Integer getStartDateRange() {
		return startDateRange;
	}
	public void setStartDateRange(Integer startDateRange) {
		this.startDateRange = startDateRange;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getBirthDateRange() {
		return birthDateRange;
	}
	public void setBirthDateRange(Integer birthDateRange) {
		this.birthDateRange = birthDateRange;
	}
	
	
}
