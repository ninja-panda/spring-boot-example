package com.tuturself.spring.boot.cassandra.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuturself.spring.boot.cassandra.entity.Student;

import info.archinnov.achilles.generated.manager.Student_Manager;

@Service
public class StudentRepository {

	@Autowired
	private Student_Manager student_Manager;

	public Student findById(Integer studentId) {
		return student_Manager.crud().findById(studentId).get();
	}
	
	public void addStudent(Student student) {
		student_Manager.crud().insert(student).ifNotExists(false).execute();
	}
}
