package com.tuturself.spring.boot.cassandra.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import info.archinnov.achilles.generated.ManagerFactory;
import info.archinnov.achilles.generated.manager.Student_Manager;

@Configuration
public class ManagerConfiguration {

	@Autowired
	private ManagerFactory managerFactory;

	@Bean
	public Student_Manager getStudentManager() {
		return managerFactory.forStudent();
	}
}
