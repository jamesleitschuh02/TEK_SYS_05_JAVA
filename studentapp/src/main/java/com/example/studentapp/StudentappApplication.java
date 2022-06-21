package com.example.studentapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.controller.StudentController;
import com.example.entity.StudentEntity;
import com.example.service.StudentView;

//@SpringBootApplication
public class StudentappApplication {

	public static void main(String[] args) {
		//SpringApplication.run(StudentappApplication.class, args);
		StudentEntity model = retrieveStudent();
		
		StudentView view = new StudentView();
		
		StudentController controller = new StudentController(model,view);
		
		controller.updateView();
		
		// update model
		controller.setStudentName("Jeff");
		
		
		controller.updateView();
	}
	
	private static StudentEntity retrieveStudent() {
		StudentEntity student = new StudentEntity();
		student.setName("James");
		student.setRollNo("15");
		return student;
	}

}
