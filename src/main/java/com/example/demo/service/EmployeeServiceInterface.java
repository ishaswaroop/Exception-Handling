package com.example.demo.service;
import java.util.List;

import com.example.demo.Entity.Employee;



public interface EmployeeServiceInterface {

	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmpById(Long empidL);

	public void deleteEmpById(Long empidL);

}