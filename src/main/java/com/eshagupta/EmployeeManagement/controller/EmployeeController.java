package com.eshagupta.EmployeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.eshagupta.EmployeeManagement.entity.Employee;
import com.eshagupta.EmployeeManagement.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {

	
	@Autowired
	EmployeeServiceImpl employeeService;
	
	@GetMapping("/employees")
	public String listofemployees(Model model)
	{
		List<Employee> emplist = employeeService.getAllEmployees();
		model.addAttribute("employees",emplist);
		return "employees";
	}
	
	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model)
	{	
		Employee e1 = new Employee();
		model.addAttribute("employee",e1);
		return "create_employee";
		
	}
	
	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable int id , Model model)
	{	
		Employee empdb= employeeService.getEmployeeByID(id);
		model.addAttribute("employee",empdb);
		return "edit_employee";
		
	}
	
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) 
	{	
		employeeService.deleteEmployee(id);
		return "redirect:/employees";
			
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee e1) {
		
		employeeService.saveEmployee(e1);
		return "redirect:/employees";
		
	}
	
	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable int id, @ModelAttribute("employee") Employee newvalue) 
	{	
		Employee empdb =employeeService.getEmployeeByID(id);
		empdb.setFirstname(newvalue.getFirstname());
		empdb.setLastname(newvalue.getLastname());
		empdb.setEmail(newvalue.getEmail());
		employeeService.updateEmployee(empdb);
		return "redirect:/employees";
			
	}
	
	
}
