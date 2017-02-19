package com.tuturself.spring.boot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tuturself.spring.boot.model.Student;
import com.tuturself.spring.boot.service.StudentService;

@RestController
public class StudentAPI {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/students")
	public Student searchStudent(@RequestParam(name = "studentId", required = true) Integer studentId) {
		Student student = studentService.getStudentById(studentId);
		return student;
	}
}
