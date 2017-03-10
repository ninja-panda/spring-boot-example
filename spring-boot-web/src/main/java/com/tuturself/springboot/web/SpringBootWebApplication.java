package com.tuturself.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tuturself.springboot.web.service.PersonService;

@SpringBootApplication
public class SpringBootWebApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

	/**
	 * Defining the bean {@link PersonService}
	 * 
	 * @return {@link PersonService}
	 */
	@Bean
	public PersonService personService() {
		return new PersonService();
	}
}
