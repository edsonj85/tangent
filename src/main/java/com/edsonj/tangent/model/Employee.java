package com.edsonj.tangent.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.edsonj.tangent.util.Gender;
import com.edsonj.tangent.util.Race;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2025012270605476794L;
	@JsonProperty(value="years_worked")
	private Integer yearsWorked;
    private Position position;
    @JsonProperty(value="phone_number")
    private String phoneNumber;
    @JsonProperty(value="birth_date")
    private LocalDate birthDate;
    private String email;
    @JsonProperty(value="github_user")
    private String githubUser;
    private Integer age;
    @JsonProperty(value="days_to_birthday")
    private Integer daysToBirthday;
    private Gender gender;
    private Race race;
    private User user;
	
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
	public Integer getYearsWorked() {
		return yearsWorked;
	}
	public void setYearsWorked(Integer yearsWorked) {
		this.yearsWorked = yearsWorked;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getDaysToBirthday() {
		return daysToBirthday;
	}
	public void setDaysToBirthday(Integer daysToBirthday) {
		this.daysToBirthday = daysToBirthday;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Race getRace() {
		return race;
	}
	public void setRace(Race race) {
		this.race = race;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

    
}
