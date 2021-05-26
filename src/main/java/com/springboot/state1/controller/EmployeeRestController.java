package com.springboot.state1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.state1.model.Employee;
import com.springboot.state1.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeService employeeService;
	
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	//get all employee
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
		
	}
	//get employee by id
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Không tìm thấy id nhân viên - "+ employeeId);
		}
		return theEmployee;
	}
	//add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	//update employee
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	//delete employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if(theEmployee == null) {
			throw new RuntimeException("Không tìm thấy id nhân viên - " + employeeId);
		}
		employeeService.deleteById(employeeId);
		return "Đã xóa nhân viên có id - " + employeeId;
		
	}
	
}
