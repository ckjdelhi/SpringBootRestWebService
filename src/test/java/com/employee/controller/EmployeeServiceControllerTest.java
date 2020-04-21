package com.employee.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.model.Employee;
import com.employee.service.EmployeeService.EmployeeServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeeServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeServiceControllerTest {
	@LocalServerPort
	private int port;
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testRetrieveAllEmployees() throws Exception {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/employeeService/"),
				HttpMethod.GET, entity, String.class);
		Assert.assertEquals(200, response.getStatusCodeValue());
	}
	@Test
	public void testRetrieveOneEmployee() throws Exception {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/employeeService/employee/100"),
				HttpMethod.GET, entity, String.class);
		Assert.assertEquals(200, response.getStatusCodeValue());
	}
	@Test
	public void testRetrieveOneEmployeeWithNotFoundEmpId() throws Exception {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/employeeService/employee/110"),
				HttpMethod.GET, entity, String.class);
		Assert.assertEquals(200, response.getStatusCodeValue());
	}
	@Test
	public void AddEmployee() throws Exception {
		Employee e1=new Employee(200, "Test", "US");
		HttpEntity<Employee> entity = new HttpEntity<Employee>(e1, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/employeeService/addEmployee"),
				HttpMethod.POST, entity, String.class);
		Assert.assertEquals(201, response.getStatusCodeValue());
	}
	@Test
	public void canTestUpdateEmployee() throws Exception {
		Employee e1=new Employee(100, "Test", "US");
		HttpEntity<Employee> entity = new HttpEntity<Employee>(e1, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/employeeService/updateEmployee/100"),
				HttpMethod.PUT, entity, String.class);
		Assert.assertEquals(202, response.getStatusCodeValue());
	}
	

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}