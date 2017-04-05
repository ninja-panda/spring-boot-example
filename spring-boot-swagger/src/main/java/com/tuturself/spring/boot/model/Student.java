package com.tuturself.spring.boot.model;

import org.jfairy.producer.person.Address;
import org.jfairy.producer.person.Person;
import org.jfairy.producer.person.Person.Sex;
import org.joda.time.DateTime;

public class Student {

	private Integer studentId;
	private Address address;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private Sex sex;
	private String telephoneNumber;
	private DateTime dateOfBirth;
	private Integer age;
	private String companyEmail;
	private String nationalIdentityCardNumber;
	private String nationalIdentificationNumber;

	public Student(int studentId, Person p) {
		this.studentId = studentId;
		this.nationalIdentityCardNumber = p.nationalIdentificationNumber();
		this.address = p.getAddress();
		this.firstName = p.firstName();
		this.middleName = p.middleName();
		this.lastName = p.lastName();
		this.email = p.email();
		this.sex = p.sex();
		this.telephoneNumber = p.telephoneNumber();
		this.dateOfBirth = p.dateOfBirth();
		this.age = p.age();
		this.nationalIdentificationNumber = p.nationalIdentificationNumber();
		this.companyEmail = p.companyEmail();
	}

	public Integer getStudentId() {
		return studentId;
	}

	public Address getAddress() {
		return address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public Sex getSex() {
		return sex;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public DateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public Integer getAge() {
		return age;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public String getNationalIdentityCardNumber() {
		return nationalIdentityCardNumber;
	}

	public String getNationalIdentificationNumber() {
		return nationalIdentificationNumber;
	}
}
