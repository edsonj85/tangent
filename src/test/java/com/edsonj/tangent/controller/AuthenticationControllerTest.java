package com.edsonj.tangent.controller;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.edsonj.tangent.model.UsernamePassword;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthenticationController.class)
public class AuthenticationControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RestTemplate restTemplate;
	
	@Test
	public void givenAuthentication_whenAuthenticateUser_thenReturn_View() throws Exception {
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(model().attribute("usernamePassword", instanceOf(UsernamePassword.class)));
	}
}
