package com.edsonj.tangent;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.edsonj.tangent.controller.AuthenticationController;
import com.edsonj.tangent.controller.EmployeeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TangentassignmentApplicationTest {
	
	@Autowired
	private AuthenticationController authController;
	
	@Autowired
	private EmployeeController employeeController;

	@Test
	public void contextLoads() {
		assertThat(authController).isNotNull();
		assertThat(employeeController).isNotNull();
	}

}
