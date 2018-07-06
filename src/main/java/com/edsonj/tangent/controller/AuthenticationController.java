package com.edsonj.tangent.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.edsonj.tangent.model.Token;
import com.edsonj.tangent.model.UsernamePassword;


@RestController
@RequestMapping(value="auth")
@PropertySource(value = { "classpath:application.properties" })
public class AuthenticationController {
	@Value(value="${auth.url}")
	private String authUrl;
	
	@RequestMapping(method=RequestMethod.POST)
	public Token authenticateUser(@RequestBody UsernamePassword usernamePassword ) {
		//call the API authentication method.
		RestTemplate restTemplate = new RestTemplate();
		Token authToken = restTemplate.postForObject(authUrl, usernamePassword, Token.class);
		return authToken;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String authenticateUser(Model model) {
		UsernamePassword usernamePassword = new UsernamePassword();
		model.addAttribute("usernamePassword", usernamePassword);
		return "login";
	}
}
