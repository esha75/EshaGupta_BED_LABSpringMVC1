package com.eshagupta.EmployeeManagement.service;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.eshagupta.EmployeeManagement.entity.Employee;

@Repository
interface EmployeeService {
	
	
	
	List<Employee> getAllEmployees();
	
	Employee saveEmployee(Employee employee);
	
	Employee getEmployeeByID(int id);
	
	Employee updateEmployee(Employee employee);
	
	void deleteEmployee(int id);
	
}
