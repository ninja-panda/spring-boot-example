package com.tuturself.spring.boot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuturself.spring.boot.model.Student;
import com.tuturself.spring.boot.service.StudentRepository;

@RestController
public class StudentAPI {

	@Autowired
	private StudentRepository studentRepository;

	@RequestMapping("/students")
	public List<Student> searchStudent() {
		List<Student> students = studentRepository.findAll();
		return students;
	}
}
