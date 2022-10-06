package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.exception.EmptyInputException;
import com.example.demo.repo.EmployeeCrudRepo;



@Service
public class EmployeeService implements EmployeeServiceInterface{
	
	@Autowired
	private EmployeeCrudRepo crudRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		if(employee.getName().isEmpty()) {
			throw new EmptyInputException("601","Input Fields are empty");
		}
		Employee savedEmployee = crudRepo.save(employee);
		return savedEmployee;
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return crudRepo.findAll();
	}

	@Override
	public Employee getEmpById(Long empidL) {
		return crudRepo.findById(empidL).get();
	}

	@Override
	public void deleteEmpById(Long empidL) {
		crudRepo.deleteById(empidL);
	}

}