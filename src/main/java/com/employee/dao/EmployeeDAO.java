package com.employee.dao;

import org.springframework.stereotype.Repository;

import com.employee.model.Employee;
import com.employee.model.Employees;

@Repository
public class EmployeeDAO {
	private static Employees list = new Employees();
	static {
		list.getEmployeeList().add(new Employee(100, "Chandan", "India"));
		list.getEmployeeList().add(new Employee(101, "Soumya", "US"));
		list.getEmployeeList().add(new Employee(102, "Vineeth", "UK"));
	}
	
	public Employees getAllEmployees() {
		return list;
	}
	public void addEmployee(Employee emp) {
		list.getEmployeeList().add(emp);
	}
	public Employee findEmployee(int empid) {
		for(Employee e:list.getEmployeeList()) {
			if(e.getEmpId()==empid)
				return e;
		}
		return new Employee();
	}
	public void updateEmployee(Employee obj, int empid) {
		int index =0;
		for(int i=0; i<list.getEmployeeList().size();i++) {
			if(list.getEmployeeList().get(i).getEmpId() == empid){
				index = i;
				break;
			}
		}
		list.getEmployeeList().set(index, obj);
	}
}
