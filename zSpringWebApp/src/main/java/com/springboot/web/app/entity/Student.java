package com.springboot.web.app.entity;

import lombok.Data;

@Data
public class Student {
	
	private String firstName;
	private String lastName;
	
	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
