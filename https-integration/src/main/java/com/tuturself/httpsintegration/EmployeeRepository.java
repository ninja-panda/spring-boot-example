package com.tuturself.httpsintegration;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
class EmployeeRepository {

	List<Employee> employees = new ArrayList<>();

	public EmployeeRepository() {
		employees.add(new Employee(UUID.randomUUID(), "Robert Barnes"));
		employees.add(new Employee(UUID.randomUUID(), "Robin Bennett"));
		employees.add(new Employee(UUID.randomUUID(), "Harvey Berg"));
		employees.add(new Employee(UUID.randomUUID(), "Joanne Dalton"));
		employees.add(new Employee(UUID.randomUUID(), "Keifer Davey"));
		employees.add(new Employee(UUID.randomUUID(), "Grace Dobson"));
	}

	public Flux<Employee> findAll() {
		return Flux.fromStream(employees.stream());
	}

	public Mono<Employee> findById(String id) {
		UUID empId = UUID.fromString(id);
		return Mono.justOrEmpty(employees.stream().
				filter(e -> e.getEmployeeId().equals(empId)).findFirst());
	}
}
