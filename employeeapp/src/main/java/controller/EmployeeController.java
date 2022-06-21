package controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import repositories.EmployeeRepository;
import entity.EmployeeEntity;

import java.util.List;

@RestController
public class EmployeeController {
	
	private final EmployeeRepository employeeRepository;
	
	EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@GetMapping("/employees")
	List<EmployeeEntity> all(){
		return employeeRepository.findAll();
	}
	
	@PostMapping("/employees")
	EmployeeEntity newEmployee(@RequestBody EmployeeEntity newEmployee) {
		return employeeRepository.save(newEmployee);
	}
	
	@GetMapping("/employees/{id}")
	EmployeeEntity employeeById(@PathVariable Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(()-> new EmployeeNotFoundException(id));
	}

}
