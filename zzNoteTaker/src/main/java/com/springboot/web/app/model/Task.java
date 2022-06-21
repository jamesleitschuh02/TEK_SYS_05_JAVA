package com.springboot.web.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "task")
public class Task {
	
	@Id
	@Column(name = "taskId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long taskId;
	
	@Column(name = "taskName")
	private String taskName;
	
	@Column(name = "completed")
	private boolean completed;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	@JsonBackReference
	private User user;

}
