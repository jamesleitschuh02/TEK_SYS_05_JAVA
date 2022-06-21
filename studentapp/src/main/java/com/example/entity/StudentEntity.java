package com.example.entity;

import javax.persistence.Entity;

import lombok.Data;

//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode

//@Data
//@Entity
public class StudentEntity {

	private String rollNo;
	private String name;
	
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
