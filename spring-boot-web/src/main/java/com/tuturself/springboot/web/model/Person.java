package com.tuturself.springboot.web.model;

public class Person {

	private Integer personId;
	private String name;
	private Long ssn;
	
	public Person(Integer personId, String name, Long ssn) {
		super();
		this.personId = personId;
		this.name = name;
		this.ssn = ssn;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}
}
