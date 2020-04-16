package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;
import com.employee.model.Employees;

@RestController
@RequestMapping(path = "/employeeService")
public class EmployeeServiceController {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@GetMapping(path = "/")
	public Employees getEmployees() {
		System.out.println("Welcome");	
		return employeeDAO.getAllEmployees();
	}
	@PostMapping(path = "/addEmployee",consumes = "application/json", produces = "application/json")
	public String addEmployee(@RequestBody Employee emp) {
		employeeDAO.addEmployee(emp);
		return "successfully inserted";
	}
	
}
