package com.tuturself.httpsintegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class WebService {

	@Autowired
	private EmployeeRepository repository;

	@GetMapping("/employees")
	public Flux<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@GetMapping("/employees/{id}")
	public Mono<ResponseEntity<Employee>> getAllEmployees(@PathVariable("id") String employeeId) {
		return repository.findById(employeeId)
				.map(employee -> ResponseEntity.ok(employee))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
}
