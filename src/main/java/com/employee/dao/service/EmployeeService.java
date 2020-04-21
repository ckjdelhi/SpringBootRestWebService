package com.employee.dao.service;

import com.employee.model.Employee;
import com.employee.model.Employees;

public interface EmployeeService {
	Employees getAllEmployees();
	void addEmployee(Employee emp);
	Employee findEmployee(int empid);
	void updateEmployee(Employee obj, int empid);
}
