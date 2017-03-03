package com.tuturself.spring.boot.cassandra.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tuturself.spring.boot.cassandra.entity.Student;
import com.tuturself.spring.boot.cassandra.repo.StudentRepository;

@RestController
public class StudentSearchAPI {

	@Autowired
	private StudentRepository studentRepository;

	@RequestMapping("/students/{studentId}")
	public Student searchStudent(@PathVariable("studentId") Integer studentId) {
		Student student = studentRepository.findById(studentId);
		return student;
	}

	@RequestMapping(value = "/students/add", method = RequestMethod.POST)
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		System.out.println(student);
		studentRepository.addStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
}
