package com.edsonj.tangent.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2025012270605476794L;
	@JsonProperty(value="years_worked")
	private String yearsWorked;
    private Position position;
    @JsonProperty(value="phone_number")
    private String phoneNumber;
    @JsonProperty(value="birth_date")
    private String birthDate;
    private String email;
    @JsonProperty(value="github_user")
    private String githubUser;
    private String age;
    @JsonProperty(value="days_to_birthday")
    private String daysToBirthday;
    private String gender;
    private String race;
    private User user;
	public String getYearsWorked() {
		return yearsWorked;
	}
	public void setYearsWorked(String yearsWorked) {
		this.yearsWorked = yearsWorked;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGithubUser() {
		return githubUser;
	}
	public void setGithubUser(String githubUser) {
		this.githubUser = githubUser;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDaysToBirthday() {
		return daysToBirthday;
	}
	public void setDaysToBirthday(String daysToBirthday) {
		this.daysToBirthday = daysToBirthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

    
}
