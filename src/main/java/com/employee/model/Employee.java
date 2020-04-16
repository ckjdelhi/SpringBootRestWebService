package com.employee.model;

public class Employee {
	private int empId;
	private String name;
	private String country;
	
	public Employee() {}
	public Employee(int empId, String name, String country) {
		super();
		this.empId = empId;
		this.name = name;
		this.country = country;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", country=" + country + "]";
	}
	
}
