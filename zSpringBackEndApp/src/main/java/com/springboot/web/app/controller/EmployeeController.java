package com.springboot.web.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.app.model.Employee;
import com.springboot.web.app.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//create employee REST API
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(
				employeeService.saveEmployee(employee),
				HttpStatus.CREATED);
	}
	
	//get all employees REST API
	@GetMapping()
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	//get all employees by ID
	// http://localhost:8080/api/employees/<id>
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
		return new ResponseEntity<Employee>(
				employeeService.getEmployeeById(employeeId),
				HttpStatus.OK);
	}
	
	//update employee REST API
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(
			@PathVariable("id") long employeeId, @RequestBody Employee employee ) {
		return new ResponseEntity<Employee>(
				employeeService.updateEmployee(employee, employeeId),
				HttpStatus.OK);
	}
	
	//delete employee REST API
	// http://localhost:8080/api/employees/<id>
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee Deleted", HttpStatus.OK);
	}
}
