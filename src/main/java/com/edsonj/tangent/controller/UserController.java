package com.edsonj.tangent.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.edsonj.tangent.model.User;
import com.edsonj.tangent.util.AuthHelper;

@RestController
@RequestMapping(value="user")
public class UserController {
	
	@Value("${tangent.url}")
	private String url;

	@RequestMapping(value="me", method=RequestMethod.GET)
	public ModelAndView getAuthenticatedUser(@CookieValue(value="token") String token) {
		String profileUrl = url+"user/me/";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<>(AuthHelper.createHttpHeaders(token));
		ResponseEntity<User> responseEntity = restTemplate.exchange(profileUrl, HttpMethod.GET, entity, User.class);
		ModelAndView mav = new ModelAndView("userprofile");
		mav.addObject("user", responseEntity.getBody());
		return mav;
	}
}
