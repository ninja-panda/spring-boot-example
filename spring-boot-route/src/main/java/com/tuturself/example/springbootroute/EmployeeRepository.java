package com.tuturself.example.springbootroute;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeRepository {

    List<Employee> employeeList = new ArrayList<>();

    public EmployeeRepository() {
        employeeList.add(new Employee(UUID.randomUUID(), "Robert Barnes"));
        employeeList.add(new Employee(UUID.randomUUID(), "Robin Bennett"));
        employeeList.add(new Employee(UUID.randomUUID(), "Harvey Berg"));
        employeeList.add(new Employee(UUID.randomUUID(), "Joanne Dalton"));
        employeeList.add(new Employee(UUID.randomUUID(), "Keifer Davey"));
        employeeList.add(new Employee(UUID.randomUUID(), "Grace Dobson"));
    }

    public List<Employee> findAll() {
        return this.employeeList;
    }

    public List<Employee> findById(String empIdStr) {
        UUID empId = UUID.fromString(empIdStr);
        Optional<Employee> optionalEmp = employeeList.stream().filter(e -> e.getEmployeeId().equals(empId)).findFirst();
        if (optionalEmp.isPresent())
            return Arrays.asList(optionalEmp.get());
        else return null;
    }
}
