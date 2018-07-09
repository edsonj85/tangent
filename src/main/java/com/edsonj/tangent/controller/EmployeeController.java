package com.edsonj.tangent.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.edsonj.tangent.model.Employee;
import com.edsonj.tangent.util.AuthHelper;

@RestController
@RequestMapping(value="employee")
public class EmployeeController {
	
	@Value("${tangent.url}")
	private String url;
	
	@RequestMapping(value="all")
	public List<Employee> allEmployees(@RequestHeader(value="Authorization", required=true) String token, 
			@RequestParam(value="race", required=false) Character race, @RequestParam(value="position", required=false) Integer position,
			@RequestParam(value="start_date_range", required=false) Integer startDateRange, @RequestParam(value="user", required=false) Integer userId, 
			@RequestParam(value="gender", required=false) Character gender, @RequestParam(value="birth_date_range", required= false) Integer birthDateRange,
			@RequestParam(value="email__contains", required=false) String emailContains) {
		String profileUrl = url+"employee/";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<>(AuthHelper.createHttpHeaders(token));
		ResponseEntity<Employee[]> responseEntity = restTemplate.exchange(profileUrl, HttpMethod.GET, entity, Employee[].class);
		return Arrays.asList(responseEntity.getBody());
	}

	@RequestMapping(value="me")
	public Employee myProfile(@RequestHeader(value="Authorization", required=true)String token) {
		String profileUrl = url+"employee/me/";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<>(AuthHelper.createHttpHeaders(token));
		ResponseEntity<Employee> responseEntity = restTemplate.exchange(profileUrl, HttpMethod.GET, entity, Employee.class);
		return responseEntity.getBody();
	}
}
