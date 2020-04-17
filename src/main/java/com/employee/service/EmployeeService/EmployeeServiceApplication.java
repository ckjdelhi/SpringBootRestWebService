package com.employee.service.EmployeeService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.employee.controller.EmployeeServiceController;
import com.employee.dao.EmployeeDAO;

@SpringBootApplication
@ComponentScan(basePackageClasses = {EmployeeServiceController.class, EmployeeDAO.class})
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}
	
}
