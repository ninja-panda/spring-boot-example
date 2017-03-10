package com.tuturself.springboot.web.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.tuturself.springboot.web.model.Person;

public class PersonService {

	private static Map<Integer, Person> personDB;

	@PostConstruct
	public void init() throws Exception {
		personDB = new HashMap<>();
		for (int i = 0; i < 100; i++) {
			Person person = new Person(i, "Person-name-" + i, System.currentTimeMillis());
			personDB.put(new Integer(i), person);
		}
	}

	public Person getPersonById(Integer id) {
		return personDB.get(id);
	}
}
