package com.edsonj.tangent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
public class TangentConfig {

	/*@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		viewResolver.setOrder(1);
		viewResolver.setViewNames(new String[] {"*.html", "*.xhtml"});
		return viewResolver;
		
	}*/
}
