package com.tuturself.datastax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManager {
	
	private final static Logger logger = LoggerFactory.getLogger(StudentManager.class);
	
	public static void main(String[] args) throws Exception {
		logger.debug("StudentManager is STARTing...");
		SpringApplication.run(StudentManager.class, args);
	}
}
