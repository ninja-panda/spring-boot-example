package com.tuturself.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tuturself.springboot.web.model.Person;
import com.tuturself.springboot.web.service.PersonService;

@RestController
@RequestMapping("/search")
public class PersonAPI {

	@Autowired
	private PersonService personService;

	@RequestMapping("/person")
	public Person searchStudent(@RequestParam(name = "personId", required = true) 
				Integer personId) {
		Person person = personService.getPersonById(personId);
		return person;
	}
}
