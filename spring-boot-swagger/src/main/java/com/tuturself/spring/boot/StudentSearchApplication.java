package com.tuturself.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentSearchApplication {
	
	private final static Logger logger = LoggerFactory.getLogger(StudentSearchApplication.class);
	
	public static void main(String[] args) throws Exception {
		logger.debug("StudentSearchApplication is STARTing...");
		SpringApplication.run(StudentSearchApplication.class, args);
	}
}
