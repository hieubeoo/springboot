package com.springboot.state1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.state1.model.Employee;
import com.springboot.state1.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) { 
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee employee = null;
		if(result.isPresent()) {
			employee = result.get();
		}else {
			throw new  RuntimeException("Không tìm thấy nhân viên có id - " + theId);
		}
		return employee;
		
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
