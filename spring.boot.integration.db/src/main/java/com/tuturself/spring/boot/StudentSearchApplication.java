package com.tuturself.spring.boot;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentSearchApplication {
	
	@Autowired
    DataSource dataSource;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StudentSearchApplication.class, args);
	}
}
