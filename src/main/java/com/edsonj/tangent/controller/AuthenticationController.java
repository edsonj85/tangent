package com.edsonj.tangent.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.edsonj.tangent.model.Token;
import com.edsonj.tangent.model.UsernamePassword;


@RestController
@RequestMapping(value="auth")
@PropertySource(value = { "classpath:application.properties" })
public class AuthenticationController {
	@Value(value="${auth.url}")
	private String authUrl;
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView authenticateUser(@Valid @ModelAttribute UsernamePassword usernamePassword, HttpServletResponse response, BindingResult result ) {
		//call the API authentication method.
		RestTemplate restTemplate = new RestTemplate();
		Token authToken = restTemplate.postForObject(authUrl, usernamePassword, Token.class);
		ModelAndView mav = new ModelAndView();
		response.addCookie(new Cookie("token", authToken.getToken()));
		mav.setViewName("home");
		return mav;
	}

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView authenticateUser(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		mav.addObject("usernamePassword", new UsernamePassword());
		//mav.addObject("allProfiles", getProfiles());
		return mav;
	}
}
