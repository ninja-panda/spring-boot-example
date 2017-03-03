package com.tuturself.spring.boot.cassandra;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class StudentSearchApplication {

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder(StudentSearchApplication.class).web(true).run(args);
	}
}
