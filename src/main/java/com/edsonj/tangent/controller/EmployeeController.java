package com.edsonj.tangent.controller;

import static org.assertj.core.api.Assertions.catchThrowable;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.edsonj.tangent.model.Employee;
import com.edsonj.tangent.model.SearchParams;
import com.edsonj.tangent.util.AuthHelper;
import com.edsonj.tangent.util.Gender;
import com.edsonj.tangent.util.Race;

@RestController
@RequestMapping(value="employee")
public class EmployeeController {
	
	@Value("${tangent.url}")
	private String url;
	
	@RequestMapping(value="all")
	public ModelAndView allEmployees(@CookieValue(value="token") String token, 
			@RequestParam(value="race", required=false) Character race, @RequestParam(value="position", required=false) Integer position,
			@RequestParam(value="start_date_range", required=false) Integer startDateRange, @RequestParam(value="user", required=false) Integer userId, 
			@RequestParam(value="gender", required=false) Character gender, @RequestParam(value="birth_date_range", required= false) Integer birthDateRange,
			@RequestParam(value="email__contains", required=false) String emailContains) {
		String profileUrl = url+"employee/";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<>(AuthHelper.createHttpHeaders(token));
		String queryString = constructFinalUrl(race, position, startDateRange, userId, gender, birthDateRange, emailContains);
		if(queryString.length() > 4) {
			profileUrl = profileUrl + "?" + queryString;
		}
		ResponseEntity<Employee[]> responseEntity = restTemplate.exchange(profileUrl, HttpMethod.GET, entity, Employee[].class);
		ModelAndView mav = new ModelAndView();
		mav.addObject("employees", Arrays.asList(responseEntity.getBody()));
		mav.addObject("searchParams", new SearchParams());
		mav.addObject("races", Race.values());
		mav.setViewName("employees");
		return mav;
	}

	private String constructFinalUrl(Character race, Integer position, Integer startDateRange, Integer userId,
			Character gender, Integer birthDateRange, String emailContains) {
		StringBuilder sb = new StringBuilder();
		if(Objects.nonNull(race) )
			try {
				Race r = Race.valueOf(race.toString());
				sb.append("race=");
				sb.append(r.name());
			}catch(IllegalArgumentException e) {
				
			}
		
		if(Objects.nonNull(position))
			sb.append("position=" + position);
		
		if(Objects.nonNull(startDateRange) && startDateRange >= 1 && startDateRange <= 5)
			sb.append("start_date_range=" + startDateRange);
		
		if(Objects.nonNull(userId))
			sb.append("user=" + userId);
		
		if(Objects.nonNull(gender) )
			try {
				Gender r = Gender.valueOf(gender.toString());
				sb.append("gender=");
				sb.append(r.name());
			}catch(IllegalArgumentException e) {
				
			}
		
		if(Objects.nonNull(birthDateRange) && birthDateRange >= 1 && birthDateRange <= 5)
			sb.append("birth_date_range=" + birthDateRange);
		
		if(Objects.nonNull(emailContains) && !StringUtils.isEmpty(emailContains))
			sb.append("email__contains=" + emailContains);
		
		return sb.toString();
	}

	@RequestMapping(value="me")
	public ModelAndView myProfile(@CookieValue(value="token")String token) {
		String profileUrl = url+"employee/me/";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<>(AuthHelper.createHttpHeaders(token));
		ResponseEntity<Employee> responseEntity = restTemplate.exchange(profileUrl, HttpMethod.GET, entity, Employee.class);
		ModelAndView mav = new ModelAndView("profile");
		mav.addObject("employee", responseEntity.getBody());
		return mav;
	}
}
