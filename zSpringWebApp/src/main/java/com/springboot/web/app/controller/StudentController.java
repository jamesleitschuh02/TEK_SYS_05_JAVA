package com.springboot.web.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.app.entity.Student;

@RestController
public class StudentController {

	@GetMapping("/student")
	public Student getStudent() {
		return new Student("James","L");
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("James", "L"));
		students.add(new Student("Tony", "Lhg"));
		students.add(new Student("San", "Lgfdg"));
		students.add(new Student("Karen", "Lfds"));
		students.add(new Student("Lee", "Lasdf"));
		return students;
	}
	
	// http://localhost:8080/student/firstname/lastname
	@GetMapping("/student/{firstName}/{lastName}")
	public Student studentPathVariable(
			@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		return new Student(firstName, lastName);
	}
	
	//http://localhost:8080/student/query?firstName=<name>&lastName=<lastName>
	@GetMapping("/student/query")
	public Student studentQueryParam(
			@RequestParam(name="firstName") String firstName,
			@RequestParam(name="lastName") String lastName) {
		return new Student(firstName, lastName);
	}
}
