package com.edsonj.tangent.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.edsonj.tangent.ex.TangentException;
import com.edsonj.tangent.model.Token;
import com.edsonj.tangent.model.UsernamePassword;


@RestController
@RequestMapping(value="/")
@PropertySource(value = { "classpath:application.properties" })
public class AuthenticationController {
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Value(value="${auth.url}")
	private String authUrl;
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView authenticateUser(@Valid @ModelAttribute UsernamePassword usernamePassword, HttpServletResponse response, BindingResult result ) {
		logger.info("Authentication");
		RestTemplate restTemplate = new RestTemplate();
		ModelAndView mav = new ModelAndView();
		try {
			Token authToken = restTemplate.postForObject(authUrl, usernamePassword, Token.class);
			response.addCookie(new Cookie("token", authToken.getToken()));
			mav.setViewName("redirect:/employee/all");
		}catch (Exception e) {
			TangentException ex = new TangentException("400", "Invalid username, password combination");
			mav.addObject("ex", ex);
			mav.setViewName("redirect:/error");
			
		}	
		
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
