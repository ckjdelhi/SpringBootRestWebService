package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employees getEmployees() {
		System.out.println("Welcome");	
		return employeeDAO.getAllEmployees();
	}
	@GetMapping(path = "/employee/{empid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployee(@PathVariable("empid") int empid) {
		return employeeDAO.findEmployee(empid);
	}
	@PostMapping(path = "/addEmployee",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody Employee obj) {
		employeeDAO.addEmployee(obj);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	@PutMapping(path="/updateEmployee/{empid}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateEmployee(@RequestBody Employee obj, @PathVariable("empid") int empid) {
		employeeDAO.updateEmployee(obj, empid);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
}
