package com.tuturself.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tuturself.spring.boot.model.Student;

@Repository
public class StudentRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Find all students, By Java 8 we can create a custom RowMapper 
	public List<Student> findAll() {

		List<Student> result = jdbcTemplate.query("SELECT studentId, firstName,lastName, email FROM student",
				(rs, rowNum) -> new Student(rs.getInt("studentId"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("email")));
		return result;
	}
}
