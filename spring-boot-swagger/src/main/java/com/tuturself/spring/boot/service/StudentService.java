package com.tuturself.spring.boot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.jfairy.Fairy;
import org.springframework.stereotype.Service;

import com.tuturself.spring.boot.model.Student;

@Service
public class StudentService {

	private static Map<Integer, Student> studentDB;
	private Fairy fairy = Fairy.create();

	@PostConstruct
	public void init() throws Exception {
		studentDB = new HashMap<>();
		for (int i = 0; i < 100; i++) {
			Student student = new Student(i, fairy.person());
			studentDB.put(new Integer(i), student);
		}
	}

	public Student getStudentById(Integer studentId) {
		return studentDB.get(studentId);
	}

	public List<Student> filterByAge(Integer age) {
		List<Student> studentList = studentDB.entrySet().stream().filter(e -> e.getValue().getAge() > age)
				.map(Map.Entry::getValue).collect(Collectors.toList());
		return studentList;
	}

	public List<Student> filterByCity(String cityName) {
		List<Student> studentList = studentDB.entrySet().stream()
				.filter(e -> e.getValue().getAddress().getCity().equals(cityName)).map(Map.Entry::getValue)
				.collect(Collectors.toList());
		return studentList;
	}

	public List<Student> filterByAgeAndCity(Integer age, String cityName) {
		List<Student> studentList = studentDB.entrySet().stream()
				.filter(e -> e.getValue().getAddress().getCity().equals(cityName) && e.getValue().getAge() > age)
				.map(Map.Entry::getValue).collect(Collectors.toList());
		return studentList;
	}
}
