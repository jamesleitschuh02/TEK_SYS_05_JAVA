package com.example.controller;

import com.example.entity.StudentEntity;
import com.example.service.StudentView;

import lombok.AllArgsConstructor;



public class StudentController {

	// using our model and view to update and control the data being passed through
	private StudentEntity model;
	private StudentView view;
	
	public StudentController(StudentEntity model, StudentView view) {
		// dependency injection (ID)
		// inversion control(ioC)
		this.model = model;
		this.view = view;
	}

	public String getStudentName() {
		return model.getName();
	}

	public void setStudentName(String name) {
		model.setName(name);;
	}
	
	public void setStudentRollNo(String rollNo) {
		model.setRollNo(rollNo);
	}
	
	public String getStudentRollNo() {
		return model.getRollNo();
	}

	public void updateView() {
		view.printStudentDetails(model.getName(), model.getRollNo());
	}
	
//	public String getStudentName() {
//		return model.name;
//	}
//
//	public void setStudentName(String name) {
//		model.setName(name);;
//	}
//	
//	public void setStudentRollNo(String rollNo) {
//		model.setRollNo(rollNo);
//	}
//	
//	public String getStudentRollNo() {
//		return model.getRollNo();
//	}
//
//	public void updateView() {
//		view.printStudentDetails(model.getName(), model.getRollNo());
//	}
	
	
	
}
