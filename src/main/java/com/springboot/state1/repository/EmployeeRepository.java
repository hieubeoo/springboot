package com.springboot.state1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.state1.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
